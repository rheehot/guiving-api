package com.guiving.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyServiceTest {
    @Autowired
    CompanyService companyService;

    @Test
    public void findAllTest() throws Exception{
        companyService.findAll().stream()
                .forEach(x -> System.out.println("element  : " + x));
    }

}