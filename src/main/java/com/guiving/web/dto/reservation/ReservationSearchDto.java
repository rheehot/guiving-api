package com.guiving.web.dto.reservation;

import com.guiving.vo.enums.CityCode;
import com.guiving.vo.enums.status.ReservationStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ReservationSearchDto {
    private CityCode cityCode;
    private ReservationStatus status;

    @Builder
    public ReservationSearchDto(CityCode cityCode, ReservationStatus status) {
        this.cityCode = cityCode;
        this.status = status;
    }
}
