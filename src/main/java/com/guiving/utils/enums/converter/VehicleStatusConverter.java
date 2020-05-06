package com.guiving.utils.enums.converter;

import com.guiving.domain.vehicle.Vehicle;
import com.guiving.vo.enums.status.GuiverStatus;
import com.guiving.vo.enums.status.VehicleStatus;

import javax.persistence.Converter;

@Converter(autoApply = true)
public class VehicleStatusConverter extends AbstractEnumAttributeConverter<VehicleStatus>{
    public static final String ENUM_NAME = "차량 상태";

    public VehicleStatusConverter(){
        super(VehicleStatus.class,false,ENUM_NAME);
    }
}
