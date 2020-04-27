package com.guiving.domain.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    UserRepository up;

    @Test
    public void findAllTest(){
        up.findAll()
                .forEach(x-> System.out.println("element : " + x ));
    }

    @Test
    public void findAllByEmail() {
        up.findAllByEmail("email@email.com")
                .forEach(x-> System.out.println("element : " + x ));
    }
}