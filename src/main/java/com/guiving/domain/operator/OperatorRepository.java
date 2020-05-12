package com.guiving.domain.operator;

import com.guiving.domain.operator.Operator;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OperatorRepository extends JpaRepository<Operator,Long>, OperatorRepositoryCustom {

    @EntityGraph(attributePaths ={"company","company.city"} )
    @Query("select DISTINCT o from Operator o")
    List<Operator> findAll();


    List<Operator> findAllByEmail(String email);

}
