package com.guiving.utils.enums.converter;

import com.guiving.vo.enums.Gender;

import javax.persistence.Converter;

@Converter(autoApply = true)
public class GenderConverter extends AbstractEnumAttributeConverter<Gender>{
    public static final String ENUM_NAME = "성별";

    public GenderConverter(){
        super(Gender.class,false,ENUM_NAME);
    }
}
