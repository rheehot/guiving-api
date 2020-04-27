package com.guiving.web.dto.guiver;

import com.guiving.domain.city.City;
import com.guiving.domain.guiver.Guiver;
import com.guiving.domain.user.User;
import com.guiving.domain.vo.MobilePhone;
import com.guiving.domain.vo.Name;
import com.guiving.domain.vo.enums.*;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Date;

@Getter
@ToString
public class GuiverSaveRequestDto {
    private Name name;
    private String email;
    private GuiverType type;
    private LocalDate birthDate;
    private Gender gender;
    private String uid;
    private Language language;
    private MobilePhone mobilePhone;
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
        this.joinType = JoinType.valueOf(joinType);
        this.password = password;
        this.mobilePhone = MobilePhone.builder().phoneNumber(phoneNumber).deviceType(DeviceType.valueOf(deviceType)).build();
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
                .mobilePhone(mobilePhone)
                .build();
    }
}
