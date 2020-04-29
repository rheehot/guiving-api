package com.guiving.web.dto.company;

import com.guiving.domain.company.Company;
import com.guiving.domain.vo.CityInfo;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@Getter
@ToString
public class CompanyResponseDto {
    private Long id;
    private String name;
    private String authCode;
    private String ownerName;
    private CityInfo cityInfo;

    public CompanyResponseDto(Company company) {
        this.id = company.getId();
        this.name = company.getName();
        this.authCode = company.getAuthCode();
        this.ownerName = company.getOwnerName();
        this.cityInfo = new CityInfo(company.getCity());
    }
}
