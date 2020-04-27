package com.guiving.web.dto.user;

import com.guiving.domain.user.Card;
import com.guiving.domain.vo.Name;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CardSaveRequestDto {
    private Name name;
    private Boolean isDefault;

    @Builder
    public CardSaveRequestDto(Name name, Boolean isDefault) {
        this.name = name;
        this.isDefault = isDefault;
    }
}
