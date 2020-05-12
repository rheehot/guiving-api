package com.guiving.service;

import com.guiving.domain.vehicle.Vehicle;
import com.guiving.domain.vehicle.VehicleRepository;
import com.guiving.vo.enums.CarGrade;
import com.guiving.vo.enums.OwnType;
import com.guiving.vo.enums.Provider;
import com.guiving.vo.enums.status.VehicleStatus;
import com.guiving.web.dto.PageRequest;
import com.guiving.web.dto.operator.OperatorResponseDto;
import com.guiving.web.dto.operator.OperatorSearchDto;
import com.guiving.web.dto.vehicle.VehicleResponseDto;
import com.guiving.web.dto.vehicle.VehicleSaveReqeustDto;
import com.guiving.web.dto.vehicle.VehicleSearchDto;
import com.guiving.web.dto.vehicle.VehicleUpdateReqeustDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VehicleServiceTest {
    @Autowired
    VehicleService vehicleService;
    @Autowired
    VehicleRepository vehicleRepository;

    List<Vehicle> list = new ArrayList<>();

    @After
    public void tearDown(){
        list.forEach(
                x-> vehicleRepository.deleteById(x.getId())
        );
    }

    @Test
    public void save() {
        VehicleSaveReqeustDto dto = VehicleSaveReqeustDto.builder()
                .color("red")
                .number("230jfj")
                .year("3919")
                .modelId(Long.parseLong("3"))
                .ownType(OwnType.PERSONAL)
                .ownerId(Long.parseLong("127"))
                .build();

        Long id = vehicleService.save(dto);

        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("vehicle does not exist"));

        System.out.println("inserted vehicle : " + vehicle);

        list.add(vehicle);


    }

    @Test
    public void saveCompanyVehicle() {
        VehicleSaveReqeustDto dto = VehicleSaveReqeustDto.builder()
                .color("red")
                .number("230jfj")
                .year("3919")
                .modelId(Long.parseLong("3"))
                .ownType(OwnType.BUSINESS)
                .ownerId(Long.parseLong("71"))
                .build();

        Long id = vehicleService.save(dto);

        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("vehicle does not exist"));

        System.out.println("inserted vehicle : " + vehicle);
        list.add(vehicle);
    }

    @Test
    public void update() {
        VehicleUpdateReqeustDto dto = VehicleUpdateReqeustDto.builder()
                .color("yellow")
                .year("1994")
                .number("56230320")
                .build();
        Long id = Long.parseLong("106");

        vehicleService.update(id,dto);

        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("vehicle does not exist"));

        System.out.println("updated vehicle : " + vehicle);
    }

    @Test
    public void searchAll() {
        VehicleSearchDto dto = VehicleSearchDto
                .builder()
                .grade(CarGrade.SEDAN)
                .ownType(OwnType.BUSINESS)
                .status(VehicleStatus.AVAILABLE)
                .build();

        PageRequest pageRequest = new PageRequest();
        pageRequest.setDirection(Sort.Direction.ASC);
        pageRequest.setSize(10);
        pageRequest.setPage(0);
        Page<VehicleResponseDto> result = vehicleService.searchAll(dto,pageRequest.of());

        result.forEach(
                x -> System.out.println("element : " + x)
        );
    }
}