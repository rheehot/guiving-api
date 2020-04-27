package com.guiving.utils.enums.converter;

import com.guiving.domain.vo.enums.CountryCode;

import javax.persistence.Converter;

@Converter(autoApply = true)
public class CountryCodeConverter extends AbstractEnumAttributeConverter<CountryCode>{
    public static final String ENUM_NAME = "국가 정보";

    public CountryCodeConverter(){
        super(CountryCode.class,false,ENUM_NAME);
    }
}
