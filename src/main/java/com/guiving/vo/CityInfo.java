package com.guiving.vo;

import com.guiving.domain.city.City;
import com.guiving.vo.enums.CityCode;
import com.guiving.vo.enums.Currency;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.ObjectUtils;

@EqualsAndHashCode
@Data
public class CityInfo {
    private CityCode cityCode;
    private Currency currency;

    @Builder
    public CityInfo(City city) {
        if(ObjectUtils.isEmpty(city))
            return;
        this.cityCode = city.getCode();
        this.currency = city.getCurrency();
    }
}
