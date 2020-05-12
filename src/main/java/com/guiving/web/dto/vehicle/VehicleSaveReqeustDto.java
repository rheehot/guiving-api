package com.guiving.web.dto.vehicle;

import com.guiving.domain.vehicle.Vehicle;
import com.guiving.vo.Picture;
import com.guiving.vo.enums.OwnType;
import com.guiving.vo.enums.Provider;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class VehicleSaveReqeustDto {
    private Long ownerId;
    private OwnType ownType;
    private String number;
    private Long modelId;
    private String color;
    private String year;
    private Picture[] pictures;

    @Builder
    public VehicleSaveReqeustDto(Long ownerId, OwnType ownType, String number, Long modelId, String color, String year, Picture[] pictures) {
        this.ownerId = ownerId;
        this.ownType = ownType;
        this.number = number;
        this.modelId = modelId;
        this.color = color;
        this.year = year;
        this.pictures = pictures;
    }

    public Vehicle toEntity(){
        return Vehicle.builder()
                .color(color)
                .number(number)
                .year(year)
                .build();
    }
}
