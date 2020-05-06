package com.guiving.web.dto.operator;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@ToString
public class OperatorRegisterRequestDto {
    private LocalDate joinDate;
    private String position;
    private String department;
    private String authCode;

    @Builder
    public OperatorRegisterRequestDto(LocalDate joinDate, String position, String department, String authCode) {
        this.joinDate = joinDate;
        this.position = position;
        this.department = department;
        this.authCode = authCode;
    }
}
