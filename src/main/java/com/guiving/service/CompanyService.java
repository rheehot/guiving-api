package com.guiving.service;

import com.guiving.domain.entity.Company;
import com.guiving.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public List<Company> findAll() throws Exception{
        return companyRepository.findAll();
    }
}
