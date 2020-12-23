package com.sinosoft.doubledatasource.repository.primary;

import com.sinosoft.doubledatasource.model.primary.ArchiveMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface ArchiveMaterialRepository extends JpaRepository<ArchiveMaterial, String> {

    void deleteByCadreId(String cadreId);

    List<ArchiveMaterial> findAllByCadreId(String cadreId);

    List<ArchiveMaterial> findAllByCadreIdOrderBySortNumberAsc(String cadreId);
    List<ArchiveMaterial> findAllByCadreIdAndStatusOrderBySortNumberAsc(String cadreId,Integer status);

    List<ArchiveMaterial> findAllByCadreIdAndCategoryIdOrderBySortNumberAsc(String cadreId, String categoryId);
    List<ArchiveMaterial> findAllByCadreIdAndCategoryIdAndStatusOrderBySortNumberAsc(String cadreId, String categoryId,Integer status);

    List<ArchiveMaterial> findAllByCadreIdAndIdInOrderBySortNumberAsc(String cadreId, List<String> ids);
    List<ArchiveMaterial> findAllByCadreIdAndIdInAndStatusOrderBySortNumberAsc(String cadreId, List<String> ids ,Integer status);

    List<ArchiveMaterial> findByIdIn(List<String> strings);

    List<ArchiveMaterial> findFirstById(String id);
}
