package com.guiving.web.dto.operator;

import com.guiving.domain.operator.Operator;
import com.guiving.domain.vo.Name;
import com.guiving.domain.vo.PhoneNumber;
import com.guiving.domain.vo.enums.CityCode;
import com.guiving.domain.vo.enums.Gender;
import com.guiving.domain.vo.enums.JoinType;
import com.guiving.domain.vo.enums.Language;
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
