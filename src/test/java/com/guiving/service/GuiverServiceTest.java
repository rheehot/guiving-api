package com.guiving.service;

import com.guiving.domain.guiver.Guiver;
import com.guiving.domain.guiver.GuiverRepository;
import com.guiving.vo.Address;
import com.guiving.vo.Name;
import com.guiving.vo.Picture;
import com.guiving.vo.enums.*;
import com.guiving.web.dto.guiver.*;
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

    @Test
    public void register() {
        GuiverPersonalInfoDto personalInfoDto = GuiverPersonalInfoDto.builder()
                .address(Address.builder().state("state").city("city").street("street").build())
                .idCard(Picture.builder().url("upload/common/e4becda62c1848178099ade15bfecded.jpg").build())
                .policeClearance(Picture.builder().url("upload/common/0eb2484a4575463bb1d444b2dc3746ec.jpg").build())
                .profile(Picture.builder().url("upload/common/e4becda62c1848178099ade15bfecded.jpg").build())
                .build();

        GuiverLicenseDto guiverLicenseDto = GuiverLicenseDto.builder()
                .licenseNum("123123num")
                .expiredDate(LocalDate.now())
                .licensePic(Picture.builder().url("upload/common/65b9977afc5b4a7c992e65b8a5a16b02.jpg").build())
                .build();

        GuiverRegisterRequestDto dto = GuiverRegisterRequestDto.builder()
                .authCode("a7071b")
                .personalInfo(personalInfoDto)
                .license(guiverLicenseDto)
                .build();
        Long id = Long.parseLong("134");
        guiverService.register(id,dto);

        Guiver guiver = guiverRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("GUIVER Doen't exist id : " + id));

        System.out.println("registered guiver : " + guiver);

    }
}