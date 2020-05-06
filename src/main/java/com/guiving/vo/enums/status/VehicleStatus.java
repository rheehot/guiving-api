package com.guiving.vo.enums.status;

import com.guiving.interfaces.CodeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public enum VehicleStatus implements CodeEnum {
    UNAVAILABLE("0", "사용불가"),
    AVAILABLE("1", "사용가능");

    private final String code;
    private final String comment;

    @Override
    public String getKey() {
        return name();
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getComment() {
        return comment;
    }

}