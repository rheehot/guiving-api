package com.guiving.service;

import com.guiving.domain.city.City;
import com.guiving.domain.city.CityRepository;
import com.guiving.domain.guiver.Guiver;
import com.guiving.domain.guiver.GuiverRepository;
import com.guiving.web.dto.guiver.GuiverResponseDto;
import com.guiving.web.dto.guiver.GuiverSaveRequestDto;
import com.guiving.web.dto.guiver.GuiverUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class GuiverService {
    private final GuiverRepository guiverRepository;
    private final CityRepository cityRepository;

    @Transactional
    public Long save(GuiverSaveRequestDto request) {
        checkDuplicatedEmail(request.getEmail());

        Guiver guiver = request.toEntity();
        City city = cityRepository.findByCode(request.getCityCode());
        guiver.setCity(city);


        return guiverRepository.save(guiver).getId();
    }

    public void checkDuplicatedEmail(String email) {
        if (guiverRepository.findAllByEmail(email).size() > 0) {
            throw new IllegalArgumentException(String.format("%s is Duplicated Email.", email));
        }
    }


    @Transactional(readOnly = true)
    public GuiverResponseDto findById(Long id){
        return new GuiverResponseDto(findGuiverById(id));
    }

    @Transactional
    public void update(Long id, GuiverUpdateRequestDto request){
        Guiver guiver = findGuiverById(id);
        guiver.updateInfo(request);
    }

    private Guiver findGuiverById(Long id){
        return guiverRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("GUIVER Doen't exist id : " + id));
    }

}
