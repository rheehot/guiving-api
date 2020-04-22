package com.guiving.domain.vo.enums.status.web.dto;

import com.guiving.domain.entity.Company;
import com.guiving.domain.vo.CityInfo;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@Getter
@ToString
public class CompanyListResponseDto {
    private Long id;
    private String name;
    private String authCode;
    private String ownerName;
    private CityInfo cityInfo;
    private int opCount;
    private int guiverCount;
    private Date buildDate;

    public CompanyListResponseDto(Company company) {
        this.id = company.getId();
        this.name = company.getName();
        this.authCode = company.getComAuthCode();
        this.ownerName = company.getOwnerName();
        this.cityInfo = new CityInfo(company.getCity());
        this.opCount = company.getOpCount();
        this.guiverCount = company.getGuiverCount();
        this.buildDate = company.getBuildDate();
    }
}
