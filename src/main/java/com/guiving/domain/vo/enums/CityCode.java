package com.guiving.domain.vo.enums;

import com.guiving.interfaces.CodeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public enum CityCode implements CodeEnum {

    SEL("SEL",CountryCode.KR,"서울"),
    PUS("PUS",CountryCode.KR, "부산"),
    CEB("CEB",CountryCode.PH, "세부"),
    MNL("MNL",CountryCode.PH, "마닐라"),
    BOR("BOR",CountryCode.PH, "보라카이"),
    DAN("DAN",CountryCode.VN, "다낭"),
    HCM("HCM",CountryCode.VN, "호치민"),
    NHA("NHA",CountryCode.VN, "나트랑"),
    TAG("TAG",CountryCode.PH, "보홀");

    private final String code;
    private final CountryCode parentCode;
    private final String comment;


    @Override
    public String getKey() {
        return name();
    }

    @Override
    public String getComment() {
        return comment;
    }


    @Override
    public String getCode() {
        return code;
    }
}
