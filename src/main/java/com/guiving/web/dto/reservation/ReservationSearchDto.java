package com.guiving.web.dto.reservation;

import com.guiving.domain.reservation.QReservation;
import com.guiving.interfaces.CodeEnum;
import com.guiving.vo.enums.CityCode;
import com.guiving.vo.enums.status.ReservationStatus;
import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.function.Function;

@Getter
@ToString
public class ReservationSearchDto {
    private CityCode cityCode;
    private ReservationStatus status;
    private ReservationSearchType searchType;
    private String keyWord;

    @Builder
    public ReservationSearchDto(CityCode cityCode, ReservationStatus status,
                                ReservationSearchType searchType,String keyWord) {
        this.cityCode = cityCode;
        this.status = status;
        this.searchType = searchType;
        this.keyWord = keyWord;
    }

}
