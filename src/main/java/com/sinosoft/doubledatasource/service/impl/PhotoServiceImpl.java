package com.sinosoft.doubledatasource.service.impl;

import com.sinosoft.doubledatasource.model.primary.ArchiveMaterial;
import com.sinosoft.doubledatasource.model.primary.ArchiveMaterialPage;
import com.sinosoft.doubledatasource.model.primary.Cadre;
import com.sinosoft.doubledatasource.model.secondary.DaElectronic;
import com.sinosoft.doubledatasource.model.secondary.PersBasicInfo;
import com.sinosoft.doubledatasource.repository.primary.ArchiveMaterialPageRepository;
import com.sinosoft.doubledatasource.repository.primary.ArchiveMaterialRepository;
import com.sinosoft.doubledatasource.repository.primary.CadreRepository;
import com.sinosoft.doubledatasource.repository.secondary.DaElectronicRepository;
import com.sinosoft.doubledatasource.repository.secondary.PersBasicInfoRepository;
import com.sinosoft.doubledatasource.service.GridFsService;
import com.sinosoft.doubledatasource.service.PhotoService;
import com.sinosoft.doubledatasource.util.FileUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PhotoServiceImpl implements PhotoService {

    @Value("${archive.old.photo}")
    private String filePath;

    @Autowired
    private PersBasicInfoRepository persBasicInfoRepository;

    @Autowired
    private DaElectronicRepository daElectronicRepository;

    @Autowired
    private CadreRepository toCadreRepository;

    @Autowired
    private ArchiveMaterialPageRepository archiveMaterialPageRepository;

    @Autowired
    private GridFsService gridFsService;

    @Autowired
    private ArchiveMaterialRepository archiveMaterialRepository;


    @Override
    public void synchronizeCadreFilePhoto() {

        List<PersBasicInfo> all = persBasicInfoRepository.findAll();
        for (PersBasicInfo p : all) {
            String id = p.getPersID();
            String name = p.getName();

            id="41ACA991-15C0-416D-B057-8364D0F5D5F0";
            name="刘祥龙";

            List<Cadre> byName = toCadreRepository.findByName(name);

            if (byName.size() != 1) {
                continue;
            }
            Cadre cadre = byName.get(0);

            List<ArchiveMaterial> archiveMaterials = archiveMaterialRepository.findAllByCadreId(cadre.getId());


            //文件
//            List<DaElectronic> electronics = daElectronicRepository.findByPersId(id);

            List<ArchiveMaterialPage> saveList = new ArrayList<>();

            String md5;


            for (ArchiveMaterial archiveMaterial : archiveMaterials) {

                List<ArchiveMaterialPage> archiveMaterialPages = archiveMaterialPageRepository.findByMaterialId(archiveMaterial.getId());

                for (ArchiveMaterialPage archiveMaterialPage : archiveMaterialPages) {
                        //path
                        String fileName = archiveMaterialPage.getImgName();

                        String path = filePath + id + "\\" + fileName;

                        File file = new File(path);

                        if (file.isFile()) {
                            try {
                                FileInputStream fileInputStream = new FileInputStream(file);

                                byte[] bytesByFile = FileUtil.getBytesByFile(path);
                                Long size = Long.valueOf(bytesByFile.length);
                                md5 = DigestUtils.md5Hex(bytesByFile);

                                //存到mongo中返回主键
                                String save = gridFsService.save(fileInputStream, fileName);

                                archiveMaterialPage.setCadreId(cadre.getId());

                                archiveMaterialPage.setHdId(save);
                                archiveMaterialPage.setHdSize(size);
                                archiveMaterialPage.setHdLastModifiedTime(new Date());
                                archiveMaterialPage.setHdMd5(md5);
                                archiveMaterialPage.setHdDpi(0);
                                archiveMaterialPage.setHdGrayScale(0);

                                archiveMaterialPage.setImgId(save);
                                archiveMaterialPage.setImgSize(size);
                                archiveMaterialPage.setImgMd5(md5);
                                archiveMaterialPage.setHdDpi(0);
                                archiveMaterialPage.setImgGrayScale(0);
                                archiveMaterialPage.setImgLastModifiedTime(new Date());

                                saveList.add(archiveMaterialPage);

                            } catch (Exception e) {
                                //把图片存进mongo出错
                                System.out.println(fileName + "没存进去");
                                e.printStackTrace();
                                continue;
                            }
                        }
                    }


            }



            archiveMaterialPageRepository.saveAll(saveList);
            break;
        }
    }


}
