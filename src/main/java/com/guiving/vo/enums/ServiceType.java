package com.guiving.vo.enums;

import com.guiving.interfaces.CodeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public enum ServiceType implements CodeEnum {

    GUIVING("GUIVING", "가이빙"),
    AIRPICK("AIRPICK", "공항픽업");

    private String code;
    private String comment;


    @Override
    public String getKey() {
        return name();
    }

    @Override
    public String getComment() {
        return comment;
    }


    @Override
    public String getCode() {
        return code;
    }
}
