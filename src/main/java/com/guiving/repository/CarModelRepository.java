package com.guiving.repository;

import com.guiving.domain.entity.CarModel;
import com.guiving.domain.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarModelRepository extends JpaRepository<CarModel,Long> {

    List<CarModel> findAll();

}
