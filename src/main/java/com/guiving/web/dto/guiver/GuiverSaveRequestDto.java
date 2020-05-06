package com.guiving.web.dto.guiver;

import com.guiving.domain.guiver.Guiver;
import com.guiving.vo.Name;
import com.guiving.vo.PhoneNumber;
import com.guiving.vo.enums.*;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@ToString
public class GuiverSaveRequestDto {
    private Name name;
    private String email;
    private GuiverType type;
    private LocalDate birthDate;
    private Gender gender;
    private String uid;
    private PhoneNumber phoneNumber;
    private Language language;
    private JoinType joinType;
    private String password;
    private CityCode cityCode;

    @Builder
    public GuiverSaveRequestDto(Name name, String email, String type,
                                LocalDate birthDate, String gender, String uid, String language,
                                String joinType, String password, String phoneNumber, String deviceType,
                                String cityCode) {
        this.name = name;
        this.email = email;
        this.type = GuiverType.valueOf(type);
        this.birthDate = birthDate;
        this.gender = Gender.valueOf(gender);
        this.language = Language.valueOf(language);
        this.uid = uid;
        this.phoneNumber = PhoneNumber.builder().phoneNumber(phoneNumber).build();
        this.joinType = JoinType.valueOf(joinType);
        this.password = password;
        this.cityCode = CityCode.valueOf(cityCode);
    }

    public Guiver toEntity(){
        return Guiver.builder()
                .name(name)
                .email(email)
                .type(type)
                .language(language)
                .birthDate(birthDate)
                .gender(gender)
                .uid(uid)
                .joinType(joinType)
                .password(password)
                .phoneNumber(phoneNumber)
                .build();
    }
}
