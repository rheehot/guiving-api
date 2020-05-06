package com.guiving.web.dto.operator;

import com.guiving.vo.Name;
import com.guiving.vo.PhoneNumber;
import com.guiving.vo.enums.Language;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@ToString
public class OperatorUpdateRequestDto {
    private Name name;
    private LocalDate birthDate;
    private PhoneNumber phoneNumber;
    private Language language;

    @Builder
    public OperatorUpdateRequestDto(Name name, LocalDate birthDate, PhoneNumber phoneNumber, Language language) {
        this.name = name;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.language = language;
    }
}
