package com.guiving.service;

import com.guiving.domain.company.Company;
import com.guiving.domain.company.CompanyRepository;
import com.guiving.vo.Address;
import com.guiving.vo.enums.CityCode;
import com.guiving.web.dto.PageRequest;
import com.guiving.web.dto.company.CompanyListResponseDto;
import com.guiving.web.dto.company.CompanySaveRequestDto;
import com.guiving.web.dto.company.CompanySearchDto;
import com.guiving.web.dto.company.CompanyUpdateDto;
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
public class CompanyServiceTest {
    @Autowired
    CompanyService companyService;
    @Autowired
    CompanyRepository companyRepository;

    List<Company> list = new ArrayList<>();

    @Test
    public void findAll() throws Exception{
        companyService.findAll().stream()
                .forEach(x -> System.out.println("element  : " + x));
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        list.forEach(
                x-> companyRepository.deleteById(x.getId())
        );
    }

    @Test
    public void save() throws Exception{
        CompanySaveRequestDto dto = CompanySaveRequestDto.builder()
                .bizNum("bizNum123123")
                .buildDate(LocalDate.now())
                .cityCode(CityCode.BOR)
                .ownerName("mr. sosos")
                .name("companyName")
                .address(Address.builder().city("city").state("state").street("street").build())
                .build();

        Long id = companyService.save(dto);
        Company company = companyRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("Company Not Found"));

        list.add(company);
        System.out.println("inserted company : " + company);

    }

    @Test
    public void update() {
        CompanyUpdateDto dto = CompanyUpdateDto.builder()
                .cityCode(CityCode.DAN)
                .name("companyname")
                .ownerName("ownername")
                .address(Address.builder().street("streetsfsdf").state("state123").build())
                .build();
        Long id = Long.parseLong("71");
        companyService.update(id,dto);

        Company company = companyRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("Company Not Found"));

        System.out.println("updated company : " + company);
    }

    @Test
    public void searchAll() {
        CompanySearchDto dto = CompanySearchDto.builder()
                .cityCode(CityCode.MNL)
                .build();
        PageRequest pageRequest = new PageRequest();
        pageRequest.setDirection(Sort.Direction.ASC);
        pageRequest.setSize(10);
        pageRequest.setPage(0);
        Page<CompanyListResponseDto> result = companyService.searchAll(dto,pageRequest.of());

        result.forEach(x-> System.out.println("element :" +x));
    }
}