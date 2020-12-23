package com.sinosoft.doubledatasource.repository.secondary;

import com.sinosoft.doubledatasource.model.secondary.MaterialItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author guodi
 * @Description:
 * @Date 2020/12/23
 */
public interface MaterialItemRepository extends JpaRepository<MaterialItem, String> {
    List<MaterialItem> findByPersID(String persID);
}
