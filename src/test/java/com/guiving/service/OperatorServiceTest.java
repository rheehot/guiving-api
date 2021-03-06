package com.guiving.service;

import com.guiving.domain.operator.Operator;
import com.guiving.domain.operator.OperatorRepository;
import com.guiving.vo.Name;
import com.guiving.vo.PhoneNumber;
import com.guiving.vo.enums.CityCode;
import com.guiving.vo.enums.Gender;
import com.guiving.vo.enums.JoinType;
import com.guiving.vo.enums.Language;
import com.guiving.utils.CoreUtils;
import com.guiving.vo.enums.status.GuiverStatus;
import com.guiving.vo.enums.status.OperatorStatus;
import com.guiving.web.dto.PageRequest;
import com.guiving.web.dto.guiver.GuiverResponseDto;
import com.guiving.web.dto.guiver.GuiverSearchDto;
import com.guiving.web.dto.operator.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OperatorServiceTest {
    @Autowired
    OperatorService operatorService;

    @Autowired
    OperatorRepository operatorRepository;

    List<Operator> list = new ArrayList<>();


    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        list.forEach(
                x-> operatorRepository.deleteById(x.getId())
        );
    }

    @Test
    public void save() {
        OperatorSaveRequestDto dto = OperatorSaveRequestDto.builder()
                .birthDate(LocalDate.now())
                .cityCode(CityCode.HCM)
                .gender(Gender.FEMALE)
                .joinType(JoinType.EMAIL)
                .language(Language.KOREAN)
                .phoneNumber(PhoneNumber.builder().phoneNumber("123123123").build())
                .email("testOp@email.com")
                .name(Name.builder().firstName("Sdfsdf").lastName("operatror").build())
                .password("password")
                .uid("uiduid1231213")
                .build();

        Long id =operatorService.save(dto);

        Operator operator = operatorRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Operator not found"));

        System.out.println("inserted Operator : " + operator);
        list.add(operator);
    }

    @Test
    public void checkDuplicatedEmail() {
    }

    @Test
    public void update() {
        OperatorUpdateRequestDto dto = OperatorUpdateRequestDto.builder()
                .birthDate(LocalDate.now())
                .language(Language.KOREAN)
                .name(Name.builder().lastName("so3or23r").firstName("sdfsf").build())
                .phoneNumber(PhoneNumber.builder().phoneNumber("203402304234").build())
                .build();

        Long id = Long.parseLong("50");
        operatorService.update(id,dto);

        Operator operator = operatorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Operator Not Found"));

        System.out.println("updated operator : " + operator);
    }

    @Test
    public void register() {
        OperatorRegisterRequestDto dto = OperatorRegisterRequestDto.builder()
                .department("department")
                .position("position")
                .authCode("a7071b")
                .joinDate(LocalDate.now())
                .build();

        Long id = Long.parseLong("55");
        operatorService.register(id,dto);

        Operator operator = operatorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Operator Not Found"));

        System.out.println("registered operator : " + operator);
    }

    @Test
    public void searchAll() {
        OperatorSearchDto dto = OperatorSearchDto
                .builder()
                .status(OperatorStatus.STANDBY)
                .companyId(Long.parseLong("71"))
                .build();

        PageRequest pageRequest = new PageRequest();
        pageRequest.setDirection(Sort.Direction.ASC);
        pageRequest.setSize(10);
        pageRequest.setPage(0);
        Page<OperatorResponseDto> result = operatorService.searchAll(dto,pageRequest.of());

        result.forEach(
                x -> System.out.println("element : " + x)
        );
    }
}