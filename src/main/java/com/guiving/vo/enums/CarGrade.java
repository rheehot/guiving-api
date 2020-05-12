package com.guiving.vo.enums;

import com.guiving.interfaces.CodeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public enum CarGrade implements CodeEnum {

    SEDAN("1", "승용차"),
    SUV("2", "SUV"),
    VAN("3", "벤"),
    MINIBUS("4", "미니버스");

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
