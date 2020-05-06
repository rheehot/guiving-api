package com.guiving.vo.enums.status;

import com.guiving.interfaces.CodeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public enum ReservationStatus implements CodeEnum {
    WANTED("1", "매칭대기"),
    MATCHED("2", "매칭완료"),
    COMPANY_MATCHED("22", "업체매칭"),
    VEHICLE_MATCHED("23", "차량매칭"),
    DRIVER_MATCHED("24", "드라이버매칭"),
    CANCELED("3", "예약취소"),
    COMPLETED("4", "운행완료");

    private final String code;
    private final String comment;

    @Override
    public String getKey() {
        return name();
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getComment() {
        return comment;
    }

}