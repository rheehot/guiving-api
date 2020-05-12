package com.guiving.utils.enums.converter;

import com.guiving.vo.enums.CarGrade;
import com.guiving.vo.enums.CityCode;

import javax.persistence.Converter;

@Converter(autoApply = true)
public class CarGradeConverter extends AbstractEnumAttributeConverter<CarGrade>{
    public static final String ENUM_NAME = "차량 등급";

    public CarGradeConverter(){
        super(CarGrade.class,false,ENUM_NAME);
    }
}
