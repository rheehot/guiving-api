package com.guiving.repository;

import com.guiving.domain.entity.Company;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company,Long> {

    @EntityGraph(attributePaths ={"city","city.country","operatorList"} )
    @Query("select DISTINCT a from Company a")
    List<Company> findAll();

}
