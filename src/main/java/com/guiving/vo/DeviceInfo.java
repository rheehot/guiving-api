package com.guiving.vo;

import com.guiving.vo.enums.DeviceType;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;


@EqualsAndHashCode
@NoArgsConstructor
@Data
@Embeddable
public class DeviceInfo {
    private DeviceType deviceType;
    private String deviceModel;
    private String deviceOS;
    private String appVersion;
    private String deviceToken;

    @Builder
    public DeviceInfo(DeviceType deviceType, String deviceModel, String deviceOS, String appVersion, String deviceToken) {

        this.deviceType = deviceType;
        this.deviceModel = deviceModel;
        this.deviceOS = deviceOS;
        this.appVersion = appVersion;
        this.deviceToken = deviceToken;
    }

}
