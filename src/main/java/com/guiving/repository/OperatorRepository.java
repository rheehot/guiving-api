package com.guiving.repository;

import com.guiving.domain.entity.Company;
import com.guiving.domain.entity.Operator;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OperatorRepository extends JpaRepository<Operator,Long> {

    @EntityGraph(attributePaths ={"company","company.city"} )
    @Query("select DISTINCT o from Operator o")
    List<Operator> findAll();

}
