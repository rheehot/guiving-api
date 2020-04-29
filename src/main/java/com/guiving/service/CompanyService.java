package com.guiving.service;

import com.guiving.domain.city.City;
import com.guiving.domain.city.CityRepository;
import com.guiving.domain.company.Company;
import com.guiving.domain.company.CompanyFee;
import com.guiving.domain.company.CompanyRepository;
import com.guiving.web.dto.company.CompanyListResponseDto;
import com.guiving.web.dto.company.CompanySaveRequestDto;
import com.guiving.web.dto.company.CompanyUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final CityRepository cityRepository;


    @Transactional(readOnly = true)
    public List<CompanyListResponseDto> findAll() throws Exception{
        return companyRepository.findAll().stream()
                .map(CompanyListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public Long save(CompanySaveRequestDto request) throws Exception{

        checkDuplicatedBizNum(request.getBizNum());

        Company company = request.toEntity();
        City city = cityRepository.findByCode(request.getCityCode());
        company.setCity(city);
        company.setCompanyFee(new CompanyFee());

        Long id = companyRepository.saveAndFlush(company).getId();

        company.generateAuthCode();

        return id;
    }

    public void checkDuplicatedBizNum(String bizNum){
        if (companyRepository.findAllByBizNum(bizNum).size()>0) {
            throw new IllegalArgumentException(String.format("%s is Duplicated Business number.", bizNum));
        }
    }

    @Transactional
    public void update(Long id,CompanyUpdateDto request){
        Company company = findCompanyById(id);
        City city = cityRepository.findByCode(request.getCityCode());
        company.setCity(city);
        company.updateInfo(request);
    }

    private Company findCompanyById(Long id){
        return companyRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Company does not exist. id : " + id));
    }
}
