package com.guiving.web.dto.guiver;

import com.guiving.vo.Address;
import com.guiving.vo.Picture;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class GuiverPersonalInfoDto {
    private Picture profile;
    private Address address;
    private Picture idCard;
    private Picture policeClearance;

    @Builder
    public GuiverPersonalInfoDto(Picture profile, Address address, Picture idCard, Picture policeClearance) {
        this.profile = profile;
        this.address = address;
        this.idCard = idCard;
        this.policeClearance = policeClearance;
    }
}
