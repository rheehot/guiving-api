package com.guiving.service;

import com.guiving.domain.city.City;
import com.guiving.domain.city.CityRepository;
import com.guiving.domain.company.Company;
import com.guiving.domain.company.CompanyRepository;
import com.guiving.domain.guiver.Guiver;
import com.guiving.domain.guiver.GuiverRepository;
import com.guiving.domain.operator.Operator;
import com.guiving.domain.operator.OperatorRepository;
import com.guiving.web.dto.guiver.GuiverResponseDto;
import com.guiving.web.dto.guiver.GuiverSaveRequestDto;
import com.guiving.web.dto.guiver.GuiverUpdateRequestDto;
import com.guiving.web.dto.operator.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class OperatorService {
    private final OperatorRepository operatorRepository;
    private final CompanyRepository companyRepository;

    @Transactional(readOnly = true)
    public Page<OperatorResponseDto> searchAll(OperatorSearchDto search, Pageable pageable){
        return operatorRepository.searchAll(search,pageable)
                .map(OperatorResponseDto::new);
    }

    @Transactional
    public Long save(OperatorSaveRequestDto request) {
        checkDuplicatedEmail(request.getEmail());
        Operator operator = request.toEntity();

        return operatorRepository.save(operator).getId();
    }
    public void checkDuplicatedEmail(String email) {
        if (operatorRepository.findAllByEmail(email).size() > 0) {
            throw new IllegalArgumentException(String.format("%s is Duplicated Email.", email));
        }
    }

    @Transactional(readOnly = true)
    public OperatorResponseDto findById(Long id){
        return new OperatorResponseDto(findGuiverById(id));
    }

    @Transactional
    public void update(Long id, OperatorUpdateRequestDto request){
        Operator operator = findGuiverById(id);
        operator.updateInfo(request);
    }

    @Transactional
    public void register(Long id, OperatorRegisterRequestDto request){
        Operator operator = findGuiverById(id);
        Company company = companyRepository.findByAuthCode(request.getAuthCode());
        operator.registerInfo(request);
        operator.setCompany(company);
    }

    @Transactional
    public void approval(Long id){
        Operator operator = findGuiverById(id);
        operator.approval();
    }

    private Operator findGuiverById(Long id){
        return operatorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("GUIVER Doen't exist id : " + id));
    }

}
