package com.guiving.web.dto.guiver;

import com.guiving.vo.Picture;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@ToString
public class GuiverLicenseDto {
    private String licenseNum;
    private LocalDate expiredDate;
    private Picture licensePic;

    @Builder
    public GuiverLicenseDto(String licenseNum, LocalDate expiredDate, Picture licensePic) {
        this.licenseNum = licenseNum;
        this.expiredDate = expiredDate;
        this.licensePic = licensePic;
    }
}
