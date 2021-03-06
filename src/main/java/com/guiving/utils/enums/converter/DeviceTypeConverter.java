package com.guiving.utils.enums.converter;

import com.guiving.vo.enums.DeviceType;

import javax.persistence.Converter;

@Converter(autoApply = true)
public class DeviceTypeConverter extends AbstractEnumAttributeConverter<DeviceType>{
    public static final String ENUM_NAME = "디바이스 종류";

    public DeviceTypeConverter(){
        super(DeviceType.class,true,ENUM_NAME);
    }
}
