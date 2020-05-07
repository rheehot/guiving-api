package com.guiving.service;

import com.guiving.domain.company.Company;
import com.guiving.domain.company.CompanyRepository;
import com.guiving.domain.guiver.Guiver;
import com.guiving.domain.guiver.GuiverRepository;
import com.guiving.domain.carmodel.CarModel;
import com.guiving.domain.carmodel.CarModelRepository;
import com.guiving.domain.vehicle.Vehicle;
import com.guiving.domain.vehicle.VehicleRepository;
import com.guiving.vo.enums.Provider;
import com.guiving.web.dto.vehicle.VehicleSaveReqeustDto;
import com.guiving.web.dto.vehicle.VehicleUpdateReqeustDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class VehicleService {
    private final VehicleRepository vehicleRepository;
    private final CarModelRepository carModelRepository;
    private final CompanyRepository companyRepository;
    private final GuiverRepository guiverRepository;

    @Transactional
    public Long save(VehicleSaveReqeustDto request) {

        Vehicle vehicle= request.toEntity();

        CarModel carModel = carModelRepository.findById(request.getModelId())
                .orElseThrow(() -> new IllegalArgumentException("car model does not exit. id :" + request.getModelId()));
        vehicle.setCarModel(carModel);


        if(request.getOwnerType().equals(Provider.COMPANY)){
            Company company = companyRepository.findById(request.getOwnerId())
                    .orElseThrow(()-> new IllegalArgumentException("company does not exsit id : "+ request.getOwnerId()));

            vehicle.setCompany(company);
        }

        if(request.getOwnerType().equals(Provider.GUIVER)){
            Guiver guiver = guiverRepository.findById(request.getOwnerId())
                    .orElseThrow(()-> new IllegalArgumentException("guiver does not exsit id : "+ request.getOwnerId()));

            vehicle.setGuiver(guiver);
        }


        return vehicleRepository.save(vehicle).getId();

    }

    @Transactional
    public void update(Long id, VehicleUpdateReqeustDto request) {
        Vehicle vehicle = findVehicleById(id);

        vehicle.updateInfo(request);

    }

    private Vehicle findVehicleById(Long id){
        return vehicleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("vehicle does not exist id : "+ id));
    }

}
