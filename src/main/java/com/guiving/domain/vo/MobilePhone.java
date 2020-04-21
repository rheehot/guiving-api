package com.guiving.domain.vo;

import com.guiving.domain.vo.enums.DeviceType;
import lombok.Data;

import javax.persistence.Embeddable;


@Data
@Embeddable
public class MobilePhone {
    private String phoneNumber;
    private DeviceType deviceType;
    private String deviceModel;
    private String deviceOS;
    private String appVersion;
    private String deviceToken;
}
