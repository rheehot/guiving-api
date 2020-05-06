package com.guiving.web.dto.company;

import com.guiving.vo.Address;
import com.guiving.vo.enums.CityCode;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@ToString
public class CompanyUpdateDto {
    private String name;
    private String ownerName;
    private LocalDate builDate;
    private CityCode cityCode;
    private Address address;


    @Builder
    public CompanyUpdateDto(String name,LocalDate builDate, String ownerName, CityCode cityCode, Address address) {
        this.name = name;
        this.ownerName = ownerName;
        this.builDate = builDate;
        this.cityCode = cityCode;
        this.address = address;
    }
}
