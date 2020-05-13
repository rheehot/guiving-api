package com.guiving.utils.enums.converter;

import com.guiving.vo.enums.status.OperatorStatus;
import com.guiving.vo.enums.status.ReservationStatus;

import javax.persistence.Converter;

@Converter(autoApply = true)
public class ReservationStatusConverter extends AbstractEnumAttributeConverter<ReservationStatus>{
    public static final String ENUM_NAME = "예약 상태";

    public ReservationStatusConverter(){
        super(ReservationStatus.class,false,ENUM_NAME);
    }
}
