package com.guiving.vo.enums;

import com.guiving.interfaces.CodeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public enum GuiverType implements CodeEnum {
    EMPLOYED("2", "소속 드라이버"),
    FREELANCER("3", "프리랜서 드라이버");

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
