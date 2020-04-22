package com.guiving.repository;

import com.guiving.domain.entity.Guiver;
import com.guiving.domain.entity.Operator;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GuiverRepository extends JpaRepository<Guiver,Long> {

    @EntityGraph(attributePaths ={"company"} )
    @Query("select DISTINCT g from Guiver g join fetch g.city t ")
    List<Guiver> findAll();

}
