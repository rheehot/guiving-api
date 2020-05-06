package com.guiving.utils.enums.converter;

import com.guiving.vo.enums.status.GuiverStatus;

import javax.persistence.Converter;

@Converter(autoApply = true)
public class GuiverStatusConverter extends AbstractEnumAttributeConverter<GuiverStatus>{
    public static final String ENUM_NAME = "가이버 상태";

    public GuiverStatusConverter(){
        super(GuiverStatus.class,false,ENUM_NAME);
    }
}
