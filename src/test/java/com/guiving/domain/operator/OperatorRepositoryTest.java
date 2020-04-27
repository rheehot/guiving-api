package com.guiving.domain.operator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class OperatorRepositoryTest {

    @Autowired
    OperatorRepository op;

    @Test
    public void findAllTest(){
        op.findAll()
                .forEach(x-> System.out.println("element : " + x ));
    }
}