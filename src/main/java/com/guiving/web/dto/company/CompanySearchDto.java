package com.guiving.web.dto.company;

import com.guiving.domain.company.Company;
import com.guiving.vo.CityInfo;
import com.guiving.vo.enums.CityCode;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@ToString
public class CompanySearchDto {
    private CityCode cityCode;

    @Builder
    public CompanySearchDto(CityCode cityCode) {
        this.cityCode = cityCode;
    }
}
