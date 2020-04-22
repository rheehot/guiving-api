package com.guiving.domain.vo.enums.status.web.dto;

import com.guiving.interfaces.CodeEnum;

public class EnumValueDto {
    private String key;
    private String value;
    private String comment;

    public EnumValueDto(CodeEnum codeEnum) {
        key = codeEnum.getKey();
        value = codeEnum.getCode();
        comment = codeEnum.getComment();
    }

    public String getComment() {
        return comment;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}