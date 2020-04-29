package com.guiving.web.dto.company;

import com.guiving.domain.company.Company;
import com.guiving.domain.vo.CityInfo;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
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
    private LocalDate buildDate;

    public CompanyListResponseDto(Company company) {
        this.id = company.getId();
        this.name = company.getName();
        this.authCode = company.getAuthCode();
        this.ownerName = company.getOwnerName();
        this.cityInfo = new CityInfo(company.getCity());
        this.opCount = company.getOpCount();
        this.guiverCount = company.getGuiverCount();
        this.buildDate = company.getBuildDate();
    }
}
