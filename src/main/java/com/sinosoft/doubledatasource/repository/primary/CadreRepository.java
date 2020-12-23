package com.sinosoft.doubledatasource.repository.primary;

import com.sinosoft.doubledatasource.model.primary.Cadre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

/**
 * @author guodi
 * @Description:
 * @Date 2020/12/23
 */
public interface CadreRepository extends JpaRepository<Cadre, String>{
    Cadre findByNameAndIdCard(String name, String idCard);

    List<Cadre> findByName(String name);
}
