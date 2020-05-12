package com.guiving.web.dto.vehicle;

import com.guiving.domain.vehicle.Vehicle;
import com.guiving.vo.enums.CarGrade;
import com.guiving.vo.enums.OwnType;
import com.guiving.vo.enums.Provider;
import com.guiving.vo.enums.status.VehicleStatus;
import com.guiving.web.dto.company.CompanyResponseDto;
import com.guiving.web.dto.guiver.GuiverResponseDto;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class VehicleResponseDto {
    private Long id;
    private OwnType ownType;
    private String number;
    private String year;
    private CarGrade grade;
    private VehicleStatus status;
    private CompanyResponseDto company;
    private GuiverResponseDto guiver;

    @Builder
    public VehicleResponseDto(Vehicle vehicle) {
        this.id = vehicle.getId();
        this.ownType = vehicle.getOwnType();
        this.number = vehicle.getNumber();
        this.year = vehicle.getYear();
        this.grade = vehicle.getCarModel().getGrade();
        this.status = vehicle.getStatus();
        if(vehicle.getOwnType().equals(OwnType.PERSONAL))
            this.guiver = new GuiverResponseDto(vehicle.getGuiver());

        if(vehicle.getOwnType().equals(OwnType.BUSINESS))
            this.company = new CompanyResponseDto(vehicle.getCompany());
    }
}
