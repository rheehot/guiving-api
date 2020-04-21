package com.guiving.domain.vo.enums.status;

import com.guiving.interfaces.CodeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public enum GuiverStatus implements CodeEnum {
    STANDBY("0", "승인대기"),
    DENIED("1", "승인거절"),
    COMPLETED("2", "승인완료"),
    WITHDRAWN("77", "탈퇴회원"),
    TERMINATED("88", "만료회원"),
    JOINED("99", "회원가입");

    private final String code;
    private final String comment;

    @Override
    public String getKey() {
        return name();
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getComment() {
        return comment;
    }

}