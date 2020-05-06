package com.guiving.web;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import com.guiving.vo.Name;
import com.guiving.vo.enums.*;
import com.guiving.web.dto.guiver.GuiverSaveRequestDto;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GuiverControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void save() throws Exception{

        GuiverSaveRequestDto dto = GuiverSaveRequestDto.builder()
                .birthDate(LocalDate.now())
                .cityCode(CityCode.BOR.getKey())
                .deviceType(DeviceType.ANDROID.getKey())
                .email("email123@email.com")
                .language(Language.ENGLISH.getKey())
                .gender(Gender.FEMALE.getKey())
                .name(Name.builder().firstName("firstGG").lastName("lastGG").build())
                .type(GuiverType.EMPLOYED.getKey())
                .phoneNumber("123123123123")
                .uid("uiduiduiduiduiduid")
                .joinType(JoinType.EMAIL.getKey())
                .password("password")
                .build();

        System.out.println("dto param : " + dto);
        //this.mockMvc.perform(post("/api/v1/guiver",dto))
        //        .andExpect(status().isOk())
        //        .andDo(print());
    }
}