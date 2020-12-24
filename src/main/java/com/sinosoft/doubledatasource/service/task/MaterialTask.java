package com.sinosoft.doubledatasource.service.task;

import com.sinosoft.doubledatasource.model.primary.ArchiveMaterial;
import com.sinosoft.doubledatasource.model.primary.ArchiveMaterialPage;
import com.sinosoft.doubledatasource.model.primary.Cadre;
import com.sinosoft.doubledatasource.model.secondary.DaElectronic;
import com.sinosoft.doubledatasource.model.secondary.MaterialItem;
import com.sinosoft.doubledatasource.model.secondary.PersBasicInfo;
import com.sinosoft.doubledatasource.repository.primary.ArchiveMaterialPageRepository;
import com.sinosoft.doubledatasource.repository.primary.ArchiveMaterialRepository;
import com.sinosoft.doubledatasource.repository.primary.CadreRepository;
import com.sinosoft.doubledatasource.repository.secondary.DaElectronicRepository;
import com.sinosoft.doubledatasource.repository.secondary.MaterialItemRepository;
import com.sinosoft.doubledatasource.repository.secondary.PersBasicInfoRepository;
import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author guodi
 * @Description:
 * @Date 2020/12/23
 */
@Component
public class MaterialTask {

    @Autowired
    CadreRepository cadreRepository;

    @Autowired
    PersBasicInfoRepository persBasicInfoRepository;

    @Autowired
    MaterialItemRepository materialItemRepository;

    @Autowired
    ArchiveMaterialRepository archiveMaterialRepository;

    @Autowired
    DaElectronicRepository daElectronicRepository;

    @Autowired
    ArchiveMaterialPageRepository archiveMaterialPageRepository;

    //档案目录十大类
    private static Map MaterialCategoryMap = new HashMap();

    static {
        //key:旧数据材料类型的code  value: 新材料十大类id
        MaterialCategoryMap.put("01", "402880586bcf5eeb016bcf5f073b0000");//履历材料
        MaterialCategoryMap.put("02", "402880586bcf5eeb016bcf5f50180001");//自传材料
        MaterialCategoryMap.put("03", "402880586bcf5eeb016bcf5f52a10002");//鉴定考核考察材料
        MaterialCategoryMap.put("04", "402880586bcf5eeb016bcf5f54910003");//学历培训聘评专业技术职务材料
        MaterialCategoryMap.put("0401", "402880586bcf5eeb016bcf5f56590004");//学历学位材料
        MaterialCategoryMap.put("0402", "402880586bcf5eeb016bcf5f57f40005");//职业资格专业技术职务材料
        MaterialCategoryMap.put("0403", "402880586bcf5eeb016bcf5f59af0006");//科研学术水平材料
        MaterialCategoryMap.put("0404", "402880586bcf5eeb016bcf5f5b380007");//培训材料
        MaterialCategoryMap.put("05", "402880586bcf5eeb016bcf5f5cde0008");//政治历史审查材料
        MaterialCategoryMap.put("06", "402880586bcf5eeb016bcf5f5e6e0009");//参加党团及民主党派材料
        MaterialCategoryMap.put("07", "402880586bcf5eeb016bcf5f5ffd000a");//奖励材料
        MaterialCategoryMap.put("08", "402880586bcf5eeb016bcf5f6186000b");//处分材料
        MaterialCategoryMap.put("09", "402880586bcf5eeb016bcf5f6320000c");//工资任免出国退离休等材料
        MaterialCategoryMap.put("0908", "402880586bcf5eeb016bcf5f64d4000d");//工资材料
        MaterialCategoryMap.put("0909", "402880586bcf5eeb016bcf5f668d000e");//任免材料
        MaterialCategoryMap.put("0910", "402880586bcf5eeb016bcf5f6838000f");//出国(境)审批材料
        MaterialCategoryMap.put("0911", "402880586bcf5eeb016bcf5f69ed0010");//会议代表材料
        MaterialCategoryMap.put("10", "402880586bcf5eeb016bcf5f6bad0011");//其他材料
    }

    //状态
    private static Integer normal = 1;
    //HD-DPI
    private static Integer HD_DPI = 300;
    //当前位置
    private static int cadreNum =0;


    public void syncMaterial(){

        long startTime = System.currentTimeMillis();
        System.out.println("同步档案材料信息开始");
        int totalCount = 0;

        try {

            //查询 干部 表的总条数
            totalCount = (int) persBasicInfoRepository.count();
            System.out.println(" oracle PersBasicInfo 表共" + totalCount + "条数据");

            List<PersBasicInfo> persBasicInfoList = persBasicInfoRepository.findAll();


            for (PersBasicInfo persBasicInfo : persBasicInfoList) {
                String name = persBasicInfo.getName();
                String persId = persBasicInfo.getPersID();

//                persId="41ACA991-15C0-416D-B057-8364D0F5D5F0";
//                name="刘祥龙";

                ++cadreNum;
                //查询toSession中的人员
//                Cadre cadre = cadreRepository.findByNameAndIdCard(name, persBasicInfo.getIdCard());
                List<Cadre> cadre = cadreRepository.findByName(name);
                if (cadre.size() != 1) {
                    System.out.println(cadreNum+"干部 " + name + ":" + persBasicInfo.getIdCard() + "在目标源中不存在！");
                } else {

                    //同步剩余部分
                    if (archiveMaterialPageRepository.findByCadreId(cadre.get(0).getId()).size()==daElectronicRepository.findByPersId(persId).size()){
                        continue;
                    }

                    //获取fromSession干部材料
                    List<MaterialItem> materialItems = materialItemRepository.findByPersID(persId);
                    if (CollectionUtils.isEmpty(materialItems)) {
                        System.out.println("--------干部材料信息为空");
                    } else {

                        System.out.println(cadreNum+"同步干部 " + name + ":" + persBasicInfo.getIdCard() + "开始" +"材料总数 ：" + materialItems.size());
                        for (MaterialItem materialItem : materialItems) {

                            ArchiveMaterial archiveMaterial = new ArchiveMaterial();
                            archiveMaterial.setId(materialItem.getMaterialID());
                            archiveMaterial.setCadreId(cadre.get(0).getId());
                            if (materialItem.getMaterialType()!=null){
                                archiveMaterial.setCategoryId(MaterialCategoryMap.get(materialItem.getMaterialType())==null?"":MaterialCategoryMap.get(materialItem.getMaterialType()).toString());
                            }
                            archiveMaterial.setEntryDateStr(materialItem.getCreateDate());
                            archiveMaterial.setCreateTime(materialItem.getScanTime());
                            archiveMaterial.setName(materialItem.getDescription());
                            archiveMaterial.setPageCount(materialItem.getPageNumber());
                            archiveMaterial.setSortNumber(materialItem.getOrderID());
                            archiveMaterial.setStatus(normal);
                            archiveMaterialRepository.save(archiveMaterial);

                            //查询材料页数
                            List<DaElectronic> materialPages = daElectronicRepository.findByMaterialId(Integer.parseInt(materialItem.getMaterialID()));
                            for (DaElectronic materialPage : materialPages) {
                                ArchiveMaterialPage archiveMaterialPage = new ArchiveMaterialPage();
                                archiveMaterialPage.setId(materialPage.getElecId());
                                archiveMaterialPage.setCadreId(cadre.get(0).getId());
                                archiveMaterialPage.setMaterialId(archiveMaterial.getId());
                                archiveMaterialPage.setImgName(materialPage.getFileName());
                                archiveMaterialPage.setPageNumber(materialPage.getOrderId());
                                archiveMaterialPage.setStatus(normal);
                                archiveMaterialPageRepository.save(archiveMaterialPage);
                            }
                        }

                        System.out.println(cadreNum+"同步干部 " + name + ":" + persBasicInfo.getIdCard() + "结束"+"材料总数 ：" + materialItems.size());
                    }


                }
//                break;

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            long endTime = System.currentTimeMillis();
            System.out.println("同步档案材料信息 结束 totalCount：" + totalCount
                    + ";共耗时:" + (endTime - startTime) / 1000 + "ms");
        }
    }



}
