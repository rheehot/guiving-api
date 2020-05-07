package com.guiving.utils.enums.converter;

import com.guiving.vo.enums.status.TripStatus;

import javax.persistence.Converter;

@Converter(autoApply = true)
public class TripStatusConverter extends AbstractEnumAttributeConverter<TripStatus>{
    public static final String ENUM_NAME = "운행 상태";

    public TripStatusConverter(){
        super(TripStatus.class,false,ENUM_NAME);
    }
}
