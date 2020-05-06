package com.guiving.web.dto.operator;

import com.guiving.domain.operator.Operator;
import com.guiving.vo.Name;
import com.guiving.vo.PhoneNumber;
import com.guiving.vo.enums.Gender;
import com.guiving.vo.enums.JoinType;
import com.guiving.vo.enums.Language;
import com.guiving.web.dto.company.CompanyResponseDto;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@ToString
public class OperatorResponseDto {
    private Long id;
    private Name name;
    private String email;
    private LocalDate birthDate;
    private Gender gender;
    private String uid;
    private PhoneNumber phoneNumber;
    private Language language;
    private JoinType joinType;
    private CompanyResponseDto companyInfo;


    @Builder
    public OperatorResponseDto(Operator operator) {
        this.id = operator.getId();
        this.name = operator.getName();
        this.email = operator.getEmail();
        this.birthDate = operator.getBirthDate();
        this.gender = operator.getGender();
        this.uid = operator.getUid();
        this.phoneNumber = operator.getPhoneNumber();
        this.language = operator.getLanguage();
        this.joinType = operator.getJoinType();
        this.companyInfo = new CompanyResponseDto(operator.getCompany());
    }
}
