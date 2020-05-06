package com.guiving.utils.enums.converter;

import com.guiving.vo.enums.status.GuiverCompanyStatus;

import javax.persistence.Converter;

@Converter(autoApply = true)
public class GuiverCompanyStatusConverter extends AbstractEnumAttributeConverter<GuiverCompanyStatus>{
    public static final String ENUM_NAME = "가이버 업체승인 상태";

    public GuiverCompanyStatusConverter(){
        super(GuiverCompanyStatus.class,true,ENUM_NAME);
    }
}
