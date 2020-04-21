package com.guiving.utils.enums.converter;

import com.guiving.domain.vo.enums.DeviceType;
import com.guiving.domain.vo.enums.Language;

import javax.persistence.Converter;

@Converter(autoApply = true)
public class DeviceTypeConverter extends AbstractEnumAttributeConverter<DeviceType>{
    public static final String ENUM_NAME = "디바이스 종류";

    public DeviceTypeConverter(){
        super(DeviceType.class,false,ENUM_NAME);
    }
}
