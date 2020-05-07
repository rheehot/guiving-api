package com.guiving.domain.carmodel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarModelRepositoryTest {
    @Autowired
    CarModelRepository carModelRepository;

    @Test
    public void findAll(){
        carModelRepository.findAll()
                .forEach(x-> System.out.println("element : " + x));
    }
}