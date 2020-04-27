package com.guiving.service;

import com.guiving.domain.guiver.Guiver;
import com.guiving.domain.guiver.GuiverRepository;
import com.guiving.domain.vo.Name;
import com.guiving.domain.vo.enums.*;
import com.guiving.web.dto.guiver.GuiverSaveRequestDto;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GuiverServiceTest {
    @Autowired
    GuiverService guiverService;
    @Autowired
    GuiverRepository guiverRepository;

    @Test
    @Transactional
    public void save() throws Exception{
        GuiverSaveRequestDto dto = GuiverSaveRequestDto.builder()
                .birthDate(LocalDate.now())
                .cityCode(CityCode.BOR.getKey())
                .deviceType(DeviceType.ANDROID.getKey())
                .email("emaissss@email.com")
                .language(Language.KOREAN.getKey())
                .gender(Gender.FEMALE.getKey())
                .name(Name.builder().firstName("firstGG").lastName("lastGG").build())
                .type(GuiverType.EMPLOYED.getKey())
                .phoneNumber("123123123123")
                .uid("uiduiduiduiduiduid")
                .joinType(JoinType.EMAIL.getKey())
                .password("password")
                .build();

        Long id = guiverService.save(dto);

        Guiver guiver = guiverRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Not Found"));

        System.out.println("inserted guiver : " + guiver);
    }

    @Test
    public void checkDuplicatedEmail() {
    }
}