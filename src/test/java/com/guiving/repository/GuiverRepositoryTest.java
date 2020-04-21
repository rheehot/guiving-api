package com.guiving.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GuiverRepositoryTest {
    @Autowired
    GuiverRepository gp;

    @Test
    public void findAllTest() throws Exception {
        gp.findAll().stream()
                .forEach(x ->
                        System.out.println("element : " + x)
                );
    }
}