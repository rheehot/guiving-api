package com.guiving.web.dto.user;

import com.guiving.domain.user.User;
import com.guiving.domain.vo.Name;
import com.guiving.domain.vo.Picture;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
@ToString
public class UserUpdateRequestDto {
    private Name name;
    private String language;
    private String phoneNumber;
    private String nation;

    @Builder
    public UserUpdateRequestDto(Name name, String language, String phoneNumber, String nation) {
        this.name = name;
        this.language = language;
        this.phoneNumber = phoneNumber;
        this.nation = nation;
    }
}
