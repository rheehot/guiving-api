package com.guiving.web.dto.vehicle;

import com.guiving.domain.vehicle.Vehicle;
import com.guiving.vo.Picture;
import com.guiving.vo.enums.Provider;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class VehicleUpdateReqeustDto {
    private String number;
    private String color;
    private String year;
    private Picture[] pictures;

    @Builder
    public VehicleUpdateReqeustDto(String number, String color, String year, Picture[] pictures) {
        this.number = number;
        this.color = color;
        this.year = year;
        this.pictures = pictures;
    }
}
