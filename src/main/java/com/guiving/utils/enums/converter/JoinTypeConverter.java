package com.guiving.utils.enums.converter;

import com.guiving.domain.vo.enums.JoinType;
import com.guiving.domain.vo.enums.Language;

import javax.persistence.Converter;

@Converter(autoApply = true)
public class JoinTypeConverter extends AbstractEnumAttributeConverter<JoinType>{
    public static final String ENUM_NAME = "가입 유형";

    public JoinTypeConverter(){
        super(JoinType.class,false,ENUM_NAME);
    }
}
