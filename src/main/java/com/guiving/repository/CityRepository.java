package com.guiving.repository;

import com.guiving.domain.entity.City;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CityRepository extends JpaRepository<City,Long> {
    @Query("select c from City c ")
    List<City> findAll();

}
