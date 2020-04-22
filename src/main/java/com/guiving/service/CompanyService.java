package com.guiving.service;

import com.guiving.repository.CompanyRepository;
import com.guiving.domain.vo.enums.status.web.dto.CompanyListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    @Transactional(readOnly = true)
    public List<CompanyListResponseDto> findAll() throws Exception{
        return companyRepository.findAll().stream()
                .map(CompanyListResponseDto::new)
                .collect(Collectors.toList());
    }
}
