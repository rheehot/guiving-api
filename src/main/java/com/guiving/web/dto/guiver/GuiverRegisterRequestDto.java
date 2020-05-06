package com.guiving.web.dto.guiver;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class GuiverRegisterRequestDto {
    private GuiverPersonalInfoDto personalInfo;
    private String authCode;
    private GuiverLicenseDto license;

    @Builder
    public GuiverRegisterRequestDto(GuiverPersonalInfoDto personalInfo, String authCode, GuiverLicenseDto license) {
        this.personalInfo = personalInfo;
        this.authCode = authCode;
        this.license = license;
    }
}
