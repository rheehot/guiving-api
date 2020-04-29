package com.guiving.service;

import com.guiving.domain.guiver.Guiver;
import com.guiving.domain.guiver.GuiverRepository;
import com.guiving.domain.vo.Name;
import com.guiving.domain.vo.enums.*;
import com.guiving.web.dto.guiver.GuiverSaveRequestDto;
import com.guiving.web.dto.guiver.GuiverUpdateRequestDto;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GuiverServiceTest {
    @Autowired
    GuiverService guiverService;
    @Autowired
    GuiverRepository guiverRepository;

    List<Guiver> list = new ArrayList<>();

    @Before()
    public void setUp(){

    }
    @Test
    public void save() throws Exception{
        GuiverSaveRequestDto dto = GuiverSaveRequestDto.builder()
                .birthDate(LocalDate.now())
                .cityCode(CityCode.BOR.getKey())
                .deviceType(DeviceType.ANDROID.getKey())
                .email("emaisfafd@email.com")
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
        list.add(guiver);
    }

    @After
    public void After(){
        list.forEach(x -> guiverRepository.deleteById(x.getId()));
    }


    @Test
    public void update() {
        GuiverUpdateRequestDto dto = GuiverUpdateRequestDto.builder()
                .name(Name.builder().firstName("saasdasd").lastName("zxczxzv").build())
                .phoneNumber("fasfasf")
                .build();

        Long id = Long.parseLong("127");
        guiverService.update(id,dto);

        Guiver guiver = guiverRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("GUIVER Doen't exist id : " + id));

        System.out.println("updated guiver : " + guiver);

    }
}