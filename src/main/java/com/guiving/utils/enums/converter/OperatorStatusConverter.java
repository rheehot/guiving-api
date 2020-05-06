package com.guiving.utils.enums.converter;

import com.guiving.vo.enums.status.OperatorStatus;

import javax.persistence.Converter;

@Converter(autoApply = true)
public class OperatorStatusConverter extends AbstractEnumAttributeConverter<OperatorStatus>{
    public static final String ENUM_NAME = "오퍼레이터 상태";

    public OperatorStatusConverter(){
        super(OperatorStatus.class,false,ENUM_NAME);
    }
}
