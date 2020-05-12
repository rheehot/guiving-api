package com.guiving.service;

import com.guiving.domain.city.City;
import com.guiving.domain.city.CityRepository;
import com.guiving.domain.company.Company;
import com.guiving.domain.company.CompanyRepository;
import com.guiving.domain.guiver.*;
import com.guiving.web.dto.guiver.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class GuiverService {
    private final GuiverRepository guiverRepository;
    private final CityRepository cityRepository;
    private final CompanyRepository companyRepository;

    @Transactional(readOnly = true)
    public Page<GuiverResponseDto> searchAll(GuiverSearchDto search,Pageable pageable){
        return guiverRepository.searchAll(search,pageable)
                .map(GuiverResponseDto::new);
    }

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

    @Transactional
    public void register(Long id, GuiverRegisterRequestDto request){
        Guiver guiver = findGuiverById(id);

        guiver.registerInfo(request.getPersonalInfo());

        guiver.setDriverLicense(request.getLicense());

        Company company = companyRepository.findByAuthCode(request.getAuthCode());
        guiver.setCompany(company);
    }

    @Transactional
    public void approval(Long id){
        Guiver guiver = findGuiverById(id);
        guiver.approval();
    }

    private Guiver findGuiverById(Long id){
        return guiverRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("GUIVER Doen't exist id : " + id));
    }


}
