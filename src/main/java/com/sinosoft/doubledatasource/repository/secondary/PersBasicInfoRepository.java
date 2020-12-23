package com.sinosoft.doubledatasource.repository.secondary;

import com.sinosoft.doubledatasource.model.secondary.PersBasicInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author guodi
 * @Description:
 * @Date 2020/12/23
 */
public interface PersBasicInfoRepository extends JpaRepository<PersBasicInfo,String> {
}
