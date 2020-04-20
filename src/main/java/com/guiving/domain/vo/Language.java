package com.guiving.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Embeddable;

@AllArgsConstructor
@Getter
@Embeddable
public enum Language {
    EN("English","영어"),
    KR("Korean", "한국어");

    private String code;
    private String comment;
}
