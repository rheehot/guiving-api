package com.guiving.domain.company;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company,Long>,CompanyRepositoryCustom {

    @EntityGraph(attributePaths ={"operatorList"} )
    @Query("select DISTINCT a from Company a join fetch a.city ct ")
    List<Company> findAll();

    List<Company> findAllByBizNum(String bizNum);

    Company findByAuthCode(String authCode);
}
