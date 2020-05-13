package com.guiving.domain.guiver;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GuiverRepository extends JpaRepository<Guiver,Long>, GuiverRepositoryCustom {

    @EntityGraph(attributePaths ={"company","vehicle","vehicle.carModel"} )
    @Query("select DISTINCT g from Guiver g join fetch g.city t")
    List<Guiver> findAll();

    List<Guiver> findAllByEmail(String email);
}
