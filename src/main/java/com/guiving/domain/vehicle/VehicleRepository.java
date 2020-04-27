package com.guiving.domain.vehicle;

import com.guiving.domain.vehicle.Vehicle;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle,Long> {

    @EntityGraph(attributePaths = {"company","company.city", "guiver","guiver.city"} )
    @Query("select DISTINCT v from Vehicle v join fetch v.carModel")
    List<Vehicle> findAll();

}
