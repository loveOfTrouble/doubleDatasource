package com.sinosoft.doubledatasource.service.impl;

import com.mongodb.client.MongoCursor;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSDownloadStream;
import com.mongodb.client.gridfs.GridFSFindIterable;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.mongodb.client.gridfs.model.GridFSUploadOptions;
import com.sinosoft.doubledatasource.enums.FilePathEnum;
import com.sinosoft.doubledatasource.service.GridFsService;
import com.sinosoft.doubledatasource.util.*;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.bson.BsonString;
import org.bson.Document;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;


import static org.springframework.data.mongodb.core.query.Criteria.where;

@Service
@SuppressWarnings("all")
public class GridFsServiceImpl implements GridFsService {
    private static final String MATERIAL_COLLECTION_NAME = "fs.files";
    private static final byte[] PWD_BYTES = "0123456789ABCDEF".getBytes();

    private final GridFSBucket bucket;
    private final GridFsTemplate gridFsTemplate;
    private final MongoTemplate mongoTemplate;

    public GridFsServiceImpl(GridFSBucket bucket, GridFsTemplate gridFsTemplate, MongoTemplate mongoTemplate) {
        this.bucket = bucket;
        this.gridFsTemplate = gridFsTemplate;
        this.mongoTemplate = mongoTemplate;
    }

    /**
     * 保存文件
     *
     * @param file
     * @return
     * @throws Exception
     */
    @Override
    public String save(MultipartFile file) throws Exception {
        return save(file.getInputStream(), file.getOriginalFilename(), file.getContentType(), null);
    }

    /**
     * 保存文件
     *
     * @param in
     * @param fileName
     * @return
     * @throws Exception
     */
    @Override
    public String save(InputStream in, String fileName) throws Exception {
        return save(in, fileName, null, null);
    }

    /**
     * 保存文件
     *
     * @param in
     * @param fileName
     * @param contentType
     * @param extra
     * @return
     */
    @Override
    public String save(InputStream in, String fileName, String contentType, Map<String, Object> extra) throws Exception {
        String newId = IdUtil.uuidWithoutMinus();
        ByteArrayInputStream bin = null;
        try {
            if (StringUtils.isEmpty(contentType)) {
                contentType = Files.probeContentType(Paths.get(fileName));
            }

            String fileExtension = com.google.common.io.Files.getFileExtension(fileName);

            Document doc = new Document("extension", fileExtension).append("content_type", contentType);
            if (extra != null) {
                doc.putAll(extra);
            }

            //图像加密
            byte[] bytes = IOUtils.toByteArray(in);
            byte[] encryptedBytes = CryptoUtil.encryptAes(bytes, PWD_BYTES);
            bin = new ByteArrayInputStream(encryptedBytes);

            //计算MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            doc.put("md5", String.valueOf(Hex.encodeHex(md.digest(bytes))));

            GridFSUploadOptions uploadOptions = new GridFSUploadOptions().metadata(doc);
            bucket.uploadFromStream(new BsonString(newId), fileName, bin, uploadOptions);
        } finally {
            IOUtils.closeQuietly(bin);
            IOUtils.closeQuietly(in);
        }

        return newId;
    }

    /**
     * 下载文件
     *
     * @param id
     * @param out
     * @return
     */
    @Override
    public GridFSFile download(String id, OutputStream out) throws Exception {
        if (out != null) {
            GridFSDownloadStream stream = bucket.openDownloadStream(new BsonString(id));
            byte[] bytes = IOUtils.toByteArray(stream);
            out.write(bytes);
        }
        return gridFsTemplate.findOne(Query.query(where("_id").is(id)));
    }
    @Override
    public byte[] downloadByte(String id) throws Exception {
        GridFSDownloadStream stream = bucket.openDownloadStream(new BsonString(id));
        return IOUtils.toByteArray(stream);
    }

    /**
     * 下载文件 解密(加水印)
     *
     * @param id
     * @param out
     * @return
     */
    @Override
    public GridFSFile downloadDecrypt2(String id, OutputStream out) throws Exception {
        if (out != null) {
            String loginName= SecurityUtils.getSubject().getCurrentLoginName();
            GridFSDownloadStream stream = bucket.openDownloadStream(new BsonString(id));
            out.write(decrypt(stream, StringUtil.isEmptyOrNull(loginName)?"组织部":loginName));
        }
        return gridFsTemplate.findOne(Query.query(where("_id").is(id)));
    }

    /**
     * 下载文件 解密
     *
     * @param id
     * @param out
     * @return
     */
    @Override
    public GridFSFile downloadDecrypt(String id, OutputStream out) throws Exception {
        if (out != null) {
            GridFSDownloadStream stream = bucket.openDownloadStream(new BsonString(id));
            out.write(decrypt(stream));
        }
        return gridFsTemplate.findOne(Query.query(where("_id").is(id)));
    }

    @Override
    public String downloadDecrypt(String id,String fileType) throws Exception {
        GridFSDownloadStream stream = bucket.openDownloadStream(new BsonString(id));
        return decryptToPdf(stream,fileType);
    }

    private String decryptToPdf(InputStream in,String fileType) throws Exception {
        try {
            byte[] b = decrypt(in);
            String filePath = FilePathEnum.下载路径+ UUID.randomUUID().toString()+fileType;
            File file = new File(filePath);

            if (file.exists()){
                file.mkdir();
            }
            OutputStream output = new FileOutputStream(file);

            BufferedOutputStream bufferedOutput = new BufferedOutputStream(output);

            bufferedOutput.write(b);

            bufferedOutput.flush();
            bufferedOutput.close();
            output.close();
            return filePath;
        } catch (Exception e) {
            System.out.println("byte[]转file失败！");
            throw e;
        }
    }
    /**
     * 获取文件流
     *
     * @param id
     * @return
     */
    @Override
    public GridFsResource download(String id) throws Exception {
        GridFSFile file = gridFsTemplate.findOne(Query.query(where("_id").is(id)));
        if (file == null) {
            return null;
        }

        GridFSDownloadStream stream = bucket.openDownloadStream(new BsonString(id));
        return new GridFsResource(file, new ByteArrayInputStream(decrypt(stream)));
    }

    private byte[] decrypt(InputStream in) throws Exception {
        try {
            byte[] bytes = IOUtils.toByteArray(in);
            return CryptoUtil.decryptAes(bytes, PWD_BYTES);

        } catch (Exception e) {
            System.out.println("图片解密失败！");
            throw e;
        }
    }
    private byte[] decrypt(InputStream in,String waterMarkContent) throws Exception {
        try {
            byte[] bytes = IOUtils.toByteArray(in);
            WatermarkImgUtils watermarkImgUtils = new WatermarkImgUtils();
            byte[] b = CryptoUtil.decryptAes(bytes, PWD_BYTES);
            return watermarkImgUtils.addWatermark(b,waterMarkContent);
        } catch (Exception e) {
            System.out.println("图片解密失败！");
            throw e;
        }
    }

    @Override
    public List<String> getHistoryList(String fileName) {
        List<String> ids = new ArrayList<>();
        Sort sort = new Sort(Sort.Direction.DESC, "uploadDate");
        GridFSFindIterable files = gridFsTemplate.find(Query.query(where("filename").is(fileName)).with(sort));
        MongoCursor<GridFSFile> iterator = files.iterator();
        for (; iterator.hasNext(); ) {
            GridFSFile file = iterator.next();
            ids.add(file.getId().toString());
        }

        return ids;
    }

    /**
     * 更新档案提交状态
     *
     * @param id
     */
    @Override
    public void updateSubmittedStatus(String id) {
        mongoTemplate.updateFirst(Query.query(where("_id").is(id)), Update.update("metadata.submitted", "1"), MATERIAL_COLLECTION_NAME);
    }

    /**
     * 删除图片
     *
     * @param id
     */
    @Override
    public void delete(String id) {
        bucket.delete(new BsonString(id));
    }

    /**
     * 如果未提交，则删除图片
     *
     * @param id
     */
    @Override
    public void deleteIfUnsubmitted(String id) {
        try {
            GridFSFile imgFile = download(id, null);
            String submitted = imgFile.getMetadata() != null ? imgFile.getMetadata().getString("submitted") : null;

            if (!StringUtils.equals(submitted, "1")) {
                delete(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除档案下所有图片
     *
     * @param materialId
     */
    @Override
    public void deleteByMaterialId(String materialId) {
        mongoTemplate.remove(Query.query(where("metadata.materialId").is(materialId)), MATERIAL_COLLECTION_NAME);
    }

    /**
     * 删除档案下所有未提交的图片
     *
     * @param materialId
     */
    @Override
    public void deleteUnsubmittedByMaterialId(String materialId) {
        mongoTemplate.remove(Query.query(where("metadata.materialId").is(materialId)
                .and("metadata.submitted").is("0")), MATERIAL_COLLECTION_NAME);
    }

}