package com.sinosoft.doubledatasource.repository.primary;

import com.sinosoft.doubledatasource.model.primary.ArchiveMaterialPage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Map;

/**
 * @author guodi
 * @Description:
 * @Date 2020/12/23
 */
public interface ArchiveMaterialPageRepository extends JpaRepository<ArchiveMaterialPage, String> {
    List<ArchiveMaterialPage> findByCadreId(String cadreId);

    List<ArchiveMaterialPage> findByMaterialId(String id);

    ArchiveMaterialPage findByMaterialIdAndImgName(String id, String fileName);
}
