package com.guiving.domain.city;

import com.guiving.vo.enums.CityCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CityRepository extends JpaRepository<City,Long> {
    @Query("select c from City c ")
    List<City> findAll();

    City findByCode(CityCode cityCode);

}
