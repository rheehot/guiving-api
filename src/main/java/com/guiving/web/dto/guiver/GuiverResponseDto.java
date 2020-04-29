package com.guiving.web.dto.guiver;

import com.guiving.domain.guiver.Guiver;
import com.guiving.domain.vo.CityInfo;
import com.guiving.domain.vo.DeviceInfo;
import com.guiving.domain.vo.Name;
import com.guiving.domain.vo.enums.*;
import com.guiving.web.dto.company.CompanyResponseDto;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@ToString
public class GuiverResponseDto {
    private Long id;
    private Name name;
    private String email;
    private GuiverType type;
    private LocalDate birthDate;
    private Gender gender;
    private String uid;
    private Language language;
    private DeviceInfo deviceInfo;
    private CityInfo cityInfo;
    private CompanyResponseDto companyInfo;

    public GuiverResponseDto(Guiver guiver) {
        this.id = guiver.getId();
        this.name = guiver.getName();
        this.email = guiver.getEmail();
        this.type = guiver.getType();
        this.birthDate = guiver.getBirthDate();
        this.gender = guiver.getGender();
        this.uid = guiver.getUid();
        this.language = guiver.getLanguage();
        this.deviceInfo = guiver.getDeviceInfo();
        this.cityInfo = new CityInfo(guiver.getCity());
        this.companyInfo = new CompanyResponseDto(guiver.getCompany());
    }
}
