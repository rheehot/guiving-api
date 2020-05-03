package com.guiving.service;

import com.guiving.domain.city.City;
import com.guiving.domain.city.CityRepository;
import com.guiving.domain.guiver.Guiver;
import com.guiving.domain.guiver.GuiverRepository;
import com.guiving.domain.operator.Operator;
import com.guiving.domain.operator.OperatorRepository;
import com.guiving.web.dto.guiver.GuiverResponseDto;
import com.guiving.web.dto.guiver.GuiverSaveRequestDto;
import com.guiving.web.dto.guiver.GuiverUpdateRequestDto;
import com.guiving.web.dto.operator.OperatorResponseDto;
import com.guiving.web.dto.operator.OperatorSaveRequestDto;
import com.guiving.web.dto.operator.OperatorUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class OperatorService {
    private final OperatorRepository operatorRepository;

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

    private Operator findGuiverById(Long id){
        return operatorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("GUIVER Doen't exist id : " + id));
    }

}