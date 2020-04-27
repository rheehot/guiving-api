package com.guiving.domain.vehicle;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarModelRepository extends JpaRepository<CarModel,Long> {

    List<CarModel> findAll();

}
