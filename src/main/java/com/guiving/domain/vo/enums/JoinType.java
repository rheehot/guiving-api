package com.guiving.domain.vo.enums;

import com.guiving.interfaces.CodeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.aspectj.apache.bcel.classfile.Code;

@ToString
@Getter
@AllArgsConstructor
public enum JoinType implements CodeEnum {
    EMAIL("E", "이메일"),
    GOOGLE("G", "구글"),
    FACEBOOK("F", "페이스북");

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
