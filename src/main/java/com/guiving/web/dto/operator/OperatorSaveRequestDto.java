package com.guiving.web.dto.operator;

import com.guiving.domain.operator.Operator;
import com.guiving.vo.Name;
import com.guiving.vo.PhoneNumber;
import com.guiving.vo.enums.*;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@ToString
public class OperatorSaveRequestDto {
    private Name name;
    private String email;
    private LocalDate birthDate;
    private Gender gender;
    private String uid;
    private PhoneNumber phoneNumber;
    private Language language;
    private JoinType joinType;
    private String password;
    private CityCode cityCode;

    @Builder
    public OperatorSaveRequestDto(Name name, String email, LocalDate birthDate, Gender gender,
                                  String uid, PhoneNumber phoneNumber, Language language, JoinType joinType,
                                  String password, CityCode cityCode) {
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
        this.gender = gender;
        this.uid = uid;
        this.phoneNumber = phoneNumber;
        this.language = language;
        this.joinType = joinType;
        this.password = password;
        this.cityCode = cityCode;
    }

    public Operator toEntity(){
        return Operator.builder()
                .name(name)
                .email(email)
                .birthDate(birthDate)
                .uid(uid)
                .gender(gender)
                .phoneNumber(phoneNumber)
                .language(language)
                .joinType(joinType)
                .password(password)
                .build();
    }
}
