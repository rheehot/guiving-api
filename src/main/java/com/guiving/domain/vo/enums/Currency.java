package com.guiving.domain.vo.enums;

import com.guiving.interfaces.CodeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public enum Currency implements CodeEnum {
    ZAR("ZAR","란드"),
    USD("USD","달러"),
    VND("VND","동"),
    TRY("TRY","터키리라"),
    THB("THB","바트"),
    SGD("SGD","싱가폴 달러"),
    SEK("SEK","스웨덴 크로나"),
    RUB("RUB","러시아 루블"),
    RON("RON","레우"),
    PLN("PLN","P즐로티"),
    PHP("PHP","필리핀 페소"),
    NZD("NZD","뉴질랜드 달러"),
    NOK("NOK","노르웨이 크로네"),
    MYR("MYR","말레이시아 링겟"),
    MXN("MXN","멕시코 페소"),
    KRW("KRW","대한민국 원"),
    JPY("JPY","옌"),
    ISK("ISK","아이슬랜드 크로나"),
    INR("INR","인디안 루피"),
    ILS("ILS","새 이스라엘 셰켈"),
    IDR("IDR","루피아"),
    HUF("HUF","포린트"),
    HRK("HRK","크로아티안 쿠나"),
    HKD("HKD","홍콩 달러"),
    GBP("GBP","영국 파운드"),
    EUR("EUR","유로"),
    DKK("DKK","덴마크 크로네"),
    CZK("CZK","체코 코루나"),
    CNY("CNY","위안"),
    CHF("CHF","스위스 프랑"),
    CAD("CAD","캐니디안 달러"),
    BRL("BRL","브라질리안 레알"),
    BGN("BGN","불가리안 레프"),
    AUD("AUD","오스트레일리아 달러");


    private String code;
    private String comment;

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
