package com.guiving.domain.city;

import com.guiving.domain.city.City;
import com.guiving.domain.vo.enums.CityCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CityRepository extends JpaRepository<City,Long> {
    @Query("select c from City c ")
    List<City> findAll();

    Optional<City> findByCode(CityCode cityCode);

}
