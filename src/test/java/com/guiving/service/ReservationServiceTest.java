package com.guiving.service;

import com.guiving.vo.enums.CityCode;
import com.guiving.vo.enums.status.ReservationStatus;
import com.guiving.web.dto.PageRequest;
import com.guiving.web.dto.reservation.ReservationResponseDto;
import com.guiving.web.dto.reservation.ReservationSearchDto;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReservationServiceTest {

    @Autowired
    ReservationService reservationService;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void searchAll() {
        ReservationSearchDto dto = ReservationSearchDto
                .builder()
                .status(ReservationStatus.WANTED)
                .cityCode(CityCode.MNL)
                .build();

        PageRequest pageRequest = new PageRequest();
        pageRequest.setDirection(Sort.Direction.ASC);
        pageRequest.setSize(10);
        pageRequest.setPage(0);
        Page<ReservationResponseDto> result = reservationService.searchAll(dto,pageRequest.of());

        result.forEach(
                x -> System.out.println("element : " + x)
        );

        result.forEach(x -> assertThat(x.getStatus(),is(ReservationStatus.WANTED)));
    }
}