package com.guiving.web.dto.user;

import com.guiving.domain.user.User;
import com.guiving.vo.DeviceInfo;
import com.guiving.vo.Name;
import com.guiving.vo.PhoneNumber;
import com.guiving.vo.enums.DeviceType;
import com.guiving.vo.enums.JoinType;
import com.guiving.vo.enums.Language;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class UserSaveRequestDto {
    private String firstName;
    private String lastName;
    private String email;
    private String uid;
    private String language;
    private String joinType;
    private String password;
    private String phoneNumber;
    private String nation;
    private String deviceType;

    @Builder
    public UserSaveRequestDto(String firstName, String lastName, String email, String nation,String deviceType,
                              String uid, String language, String joinType, String password, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.uid = uid;
        this.language = language;
        this.joinType = joinType;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.nation = nation;
        this.deviceType = deviceType;
    }

    public User toEntity(){
        return User.builder()
                .name(Name.builder().firstName(firstName).lastName(lastName).build())
                .email(email)
                .uid(uid)
                .language(Language.valueOf(language))
                .joinType(JoinType.valueOf(joinType))
                .password(password)
                .phoneNumber(PhoneNumber.builder().phoneNumber(phoneNumber).build())
                .deviceInfo(DeviceInfo.builder().deviceType(DeviceType.valueOf(deviceType)).build())
                .nation(nation)
                .build();
    }
}
