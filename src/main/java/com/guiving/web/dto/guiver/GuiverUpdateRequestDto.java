package com.guiving.web.dto.guiver;

import com.guiving.vo.Name;
import com.guiving.vo.enums.*;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@ToString
public class GuiverUpdateRequestDto {
    private Name name;
    private LocalDate birthDate;
    private Language language;
    private String phoneNumber;
    private String password;

    @Builder
    public GuiverUpdateRequestDto(Name name, LocalDate birthDate, Language language,
                                  String phoneNumber, String password) {
        this.name = name;
        this.birthDate = birthDate;
        this.language = language;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }
}
