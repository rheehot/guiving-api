package com.guiving.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Embeddable;

@Getter
@AllArgsConstructor
@Embeddable
public enum Gender {
    MALE("Male","남성"),
    FEMALE("Female","여성"),
    NONE("None","알리지 않음");

    private String code;
    private String comment;
}
