package com.guiving.repository;

import com.guiving.domain.entity.CarModel;
import com.guiving.domain.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country,Long> {

    List<Country> findAll();

}
