package com.guiving.repository;

import com.guiving.domain.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

    @Query("select c from Car c join fetch c.city ct")
    List<Car> findAll();

}
