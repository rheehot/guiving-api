package com.guiving.vo.enums.status;

import com.guiving.interfaces.CodeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public enum TripStatus implements CodeEnum {
    STANDBY("0","새 운행"),
    AWAIT("1","호출 대기"),
    CALLING("2","호출 중"),
    DEPARTING("3","운행 시작"),
    BOARDED("4","승객 승차"),
    ARRIVED("5","목적지 도착"),
    ALIGHTED("6","승객 하차"),
    AWAITED("7","기사 대기"),
    TERMINATED("8","운행 완료"),
    NEW_TRIP("9","다음 운행"),
    CANCELED("10","호출 취소"),
    CANCEL_NEW_TRIP("11","취소 후 다음 운행");

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