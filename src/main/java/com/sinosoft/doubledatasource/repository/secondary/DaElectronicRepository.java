package com.sinosoft.doubledatasource.repository.secondary;

import com.sinosoft.doubledatasource.model.primary.ArchiveMaterialCategory;
import com.sinosoft.doubledatasource.model.secondary.DaElectronic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author guodi
 * @Description:
 * @Date 2020/12/23
 */
public interface DaElectronicRepository extends JpaRepository<DaElectronic, String> {
    List<DaElectronic> findByMaterialId(long materialID);

    List<DaElectronic> findByPersId(String persionId);
}
