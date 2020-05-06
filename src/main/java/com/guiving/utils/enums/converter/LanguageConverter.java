package com.guiving.utils.enums.converter;

import com.guiving.vo.enums.Language;

import javax.persistence.Converter;

@Converter(autoApply = true)
public class LanguageConverter extends AbstractEnumAttributeConverter<Language>{
    public static final String ENUM_NAME = "사용 언어";

    public LanguageConverter(){
        super(Language.class,true,ENUM_NAME);
    }
}
