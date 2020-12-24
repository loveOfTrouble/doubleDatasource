package com.sinosoft.doubledatasource.service;

import com.mongodb.client.gridfs.model.GridFSFile;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

public interface GridFsService {

    /**
     * 保存文件
     *
     * @param file
     * @return
     * @throws Exception
     */
    String save(MultipartFile file) throws Exception;

    /**
     * 保存文件
     *
     * @param in
     * @param fileName
     * @return
     * @throws Exception
     */
    String save(InputStream in, String fileName) throws Exception;

    /**
     * 保存文件
     *
     * @param in
     * @param fileName
     * @param contentType
     * @param extra
     * @return
     * @throws Exception
     */
    String save(InputStream in, String fileName, String contentType, Map<String, Object> extra) throws Exception;


    /**
     * 下载文件
     *
     * @param id
     * @param out
     * @return
     */
    GridFSFile download(String id, OutputStream out) throws Exception;
    byte[] downloadByte(String id) throws Exception;

    /**
     * 下载文件 加密
     *
     * @param id
     * @param out
     * @return
     */
    public GridFSFile downloadDecrypt(String id, OutputStream out) throws Exception;
    public String downloadDecrypt(String id, String fileType) throws Exception;
    public GridFSFile downloadDecrypt2(String id, OutputStream out) throws Exception;

    /**
     * 获取文件流
     *
     * @param id
     * @return
     */
    GridFsResource download(String id) throws Exception;

    /**
     * 获取材料页所有历史版本数据
     */
    List<String> getHistoryList(String fileName);

    /**
     * 更新档案提交状态
     *
     * @param id
     */
    void updateSubmittedStatus(String id);

    /**
     * 删除图片
     *
     * @param id
     */
    void delete(String id);

    /**
     * 如果未提交，则删除图片
     *
     * @param id
     */
    void deleteIfUnsubmitted(String id);

    /**
     * 删除档案下所有图片
     *
     * @param materialId
     */
    void deleteByMaterialId(String materialId);

    /**
     * 删除档案下所有未提交的图片
     *
     * @param materialId
     */
    void deleteUnsubmittedByMaterialId(String materialId);
}
