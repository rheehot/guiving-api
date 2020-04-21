package com.guiving.domain.vo.enums;

import com.guiving.interfaces.CodeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.Embeddable;

@ToString
@Getter
@AllArgsConstructor
public enum DeviceType implements CodeEnum {

    ANDROID("0", "android"),
    IOS("1", "iOS");

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
