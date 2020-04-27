package com.guiving.domain.city;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CityRepositoryTest {

    @Autowired
    CityRepository cp;

    @Test
    public void findAllTest(){
        cp.findAll()
                .forEach(x-> System.out.println("element : " + x));
    }
}
