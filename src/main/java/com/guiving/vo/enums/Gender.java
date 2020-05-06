package com.guiving.vo.enums;

import com.guiving.interfaces.CodeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;


@ToString
@Getter
@AllArgsConstructor
public enum Gender implements CodeEnum {
    MALE("m", "남성"),
    FEMALE("f", "여성"),
    NONE("n", "알리지 않음");

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
