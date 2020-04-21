package com.guiving.utils.enums.converter;

import com.guiving.domain.vo.enums.GuiverType;
import com.guiving.domain.vo.enums.JoinType;

import javax.persistence.Converter;

@Converter(autoApply = true)
public class GuiverTypeConverter extends AbstractEnumAttributeConverter<GuiverType>{
    public static final String ENUM_NAME = "가이버 유형";

    public GuiverTypeConverter(){
        super(GuiverType.class,false,ENUM_NAME);
    }
}
