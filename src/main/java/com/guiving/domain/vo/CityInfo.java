package com.guiving.domain.vo;

import com.guiving.domain.entity.City;
import com.guiving.domain.entity.Country;
import com.guiving.domain.vo.enums.CityCode;
import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang3.ObjectUtils;

@Data
public class CityInfo {
    private CityCode cityCode;
    private String currency;

    @Builder
    public CityInfo(City city) {
        if(ObjectUtils.isEmpty(city))
            return;
        this.cityCode = city.getCode();
        this.currency = city.getCurrency();
    }
}
