package com.guiving.utils.enums.converter;

import com.guiving.vo.enums.CityCode;

import javax.persistence.Converter;

@Converter(autoApply = true)
public class CityCodeConverter extends AbstractEnumAttributeConverter<CityCode>{
    public static final String ENUM_NAME = "도시 정보";

    public CityCodeConverter(){
        super(CityCode.class,false,ENUM_NAME);
    }
}
