package com.guiving.domain.reservation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReservationRepositoryTest {

    @Autowired
    ReservationRepository reservationRepository;


    @Test
    @Transactional
    public void findAll() {
        reservationRepository.findAll()
                .forEach(x ->
                        System.out.println("element : " + x)
                );
    }
}