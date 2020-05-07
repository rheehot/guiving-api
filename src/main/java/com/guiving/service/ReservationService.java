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
public class ReservationService {

    private final CompanyRepository companyRepository;

    private final CityRepository cityRepository;


    @Transactional
    public Long save(CompanySaveRequestDto request) throws Exception{


        return 1L;
    }


    private Company findCompanyById(Long id){
        return companyRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Company does not exist. id : " + id));
    }
}
