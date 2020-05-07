package com.guiving.utils.enums.converter;

import com.guiving.vo.enums.status.GuivingStatus;

import javax.persistence.Converter;

@Converter(autoApply = true)
public class GuivingStatusConverter extends AbstractEnumAttributeConverter<GuivingStatus>{
    public static final String ENUM_NAME = "서비스 상태";

    public GuivingStatusConverter(){
        super(GuivingStatus.class,false,ENUM_NAME);
    }
}
