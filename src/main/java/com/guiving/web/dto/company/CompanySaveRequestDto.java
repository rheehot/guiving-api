package com.guiving.web.dto.company;

import com.guiving.domain.company.Company;
import com.guiving.vo.Address;
import com.guiving.vo.enums.CityCode;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@ToString
public class CompanySaveRequestDto {
    private String name;
    private String ownerName;
    private CityCode cityCode;
    private String bizNum;
    private LocalDate buildDate;
    private Address address;

    @Builder
    public CompanySaveRequestDto(String name, String ownerName, CityCode cityCode, String bizNum, LocalDate buildDate, Address address) {
        this.name = name;
        this.ownerName = ownerName;
        this.cityCode = cityCode;
        this.bizNum = bizNum;
        this.buildDate = buildDate;
        this.address = address;
    }

    public Company toEntity(){
        return Company.builder()
                .name(name)
                .bizNum(bizNum)
                .buildDate(buildDate)
                .ownerName(ownerName)
                .address(address)
                .build();

    }
}
