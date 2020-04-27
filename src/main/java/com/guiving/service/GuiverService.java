package com.guiving.service;

import com.guiving.domain.city.City;
import com.guiving.domain.city.CityRepository;
import com.guiving.domain.guiver.Guiver;
import com.guiving.domain.guiver.GuiverRepository;
import com.guiving.web.dto.guiver.GuiverSaveRequestDto;
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
        if (checkDuplicatedEmail(request.getEmail())) {
            throw new IllegalArgumentException(String.format("%s is Duplicated Email.", request.getEmail()));
        }

        Guiver guiver = request.toEntity();
        City city = cityRepository.findByCode(request.getCityCode())
                .orElseThrow(() -> new IllegalArgumentException("city does not exit"));
        guiver.setCity(city);


        return guiverRepository.save(guiver).getId();
    }

    public boolean checkDuplicatedEmail(String email) {
        return guiverRepository.findAllByEmail(email).size() > 0;
    }

    /*
    @Transactional(readOnly = true)
    public UserResponseDto findById(Long id){
        User user =  userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("user가 존재하지 않습니다. id : " + id));
        return new UserResponseDto(user);
    }

    @Transactional
    public void update(Long id, UserUpdateRequestDto request){
        User user =  userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("user가 존재하지 않습니다. id : " + id));
        user.updateInfo(request);

    }*/


}
