package com.guiving.domain.vo.enums;

import com.guiving.interfaces.CodeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.Embeddable;

@ToString
@AllArgsConstructor
@Getter
public enum Language implements CodeEnum {
    ENGLISH("en", "영어"),
    KOREAN("ko", "한국어");

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
