package com.guiving.web.dto.user;

import com.guiving.vo.Name;
import com.guiving.vo.PhoneNumber;
import com.guiving.vo.enums.Language;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class UserUpdateRequestDto {
    private Name name;
    private Language language;
    private PhoneNumber phoneNumber;
    private String nation;

    @Builder
    public UserUpdateRequestDto(Name name, Language language, PhoneNumber phoneNumber, String nation) {
        this.name = name;
        this.language = language;
        this.phoneNumber = phoneNumber;
        this.nation = nation;
    }
}
