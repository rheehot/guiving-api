package com.guiving.domain.vo;

import com.guiving.domain.vo.enums.DeviceType;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;


@NoArgsConstructor
@Data
@Embeddable
public class MobilePhone {
    private String phoneNumber;
    private DeviceType deviceType;
    private String deviceModel;
    private String deviceOS;
    private String appVersion;
    private String deviceToken;

    @Builder
    public MobilePhone(String phoneNumber, DeviceType deviceType, String deviceModel, String deviceOS, String appVersion, String deviceToken) {
        this.phoneNumber = phoneNumber;
        this.deviceType = deviceType;
        this.deviceModel = deviceModel;
        this.deviceOS = deviceOS;
        this.appVersion = appVersion;
        this.deviceToken = deviceToken;
    }
}
