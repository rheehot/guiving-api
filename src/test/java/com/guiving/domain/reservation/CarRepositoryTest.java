package com.guiving.domain.reservation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarRepositoryTest {
    @Autowired
    CarRepository carRepository;
    @Test
    public void findAll() {
        carRepository.findAll()
                .forEach(x-> System.out.println("element : " + x));
    }
}