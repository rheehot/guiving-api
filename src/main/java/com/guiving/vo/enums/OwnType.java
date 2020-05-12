package com.guiving.vo.enums;

import com.guiving.interfaces.CodeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public enum OwnType implements CodeEnum {

    PERSONAL("PERSONAL","개인소유"),
    BUSINESS("BUSINESS", "업체소유");

    private final String code;
    private final String comment;


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
