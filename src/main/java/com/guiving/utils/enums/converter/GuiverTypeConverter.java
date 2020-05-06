package com.guiving.utils.enums.converter;

import com.guiving.vo.enums.GuiverType;

import javax.persistence.Converter;

@Converter(autoApply = true)
public class GuiverTypeConverter extends AbstractEnumAttributeConverter<GuiverType>{
    public static final String ENUM_NAME = "가이버 유형";

    public GuiverTypeConverter(){
        super(GuiverType.class,false,ENUM_NAME);
    }
}
