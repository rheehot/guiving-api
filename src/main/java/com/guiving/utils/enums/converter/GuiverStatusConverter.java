package com.guiving.utils.enums.converter;

import com.guiving.domain.vo.enums.status.GuiverStatus;
import com.guiving.domain.vo.enums.status.OperatorStatus;

import javax.persistence.Converter;

@Converter(autoApply = true)
public class GuiverStatusConverter extends AbstractEnumAttributeConverter<GuiverStatus>{
    public static final String ENUM_NAME = "가이버 상태";

    public GuiverStatusConverter(){
        super(GuiverStatus.class,false,ENUM_NAME);
    }
}
