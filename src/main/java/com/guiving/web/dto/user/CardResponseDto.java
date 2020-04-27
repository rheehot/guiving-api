package com.guiving.web.dto.user;

import com.guiving.domain.user.Card;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CardResponseDto {
    private Long id;
    private String pubCompany;
    private String cardNum;
    private Boolean isDefault;

    public CardResponseDto(Card card){
        this.id = card.getId();
        this.pubCompany = card.getPubCompany();
        this.cardNum = card.getCardNum();
        this.isDefault = card.getIsDefault();
    }
}
