package com.guiving.web.dto.trip;

import com.guiving.interfaces.CodeEnum;
import com.guiving.vo.enums.CityCode;
import com.guiving.vo.enums.CountryCode;
import com.guiving.vo.enums.status.ReservationStatus;
import com.guiving.vo.enums.status.TripStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class TripSearchDto {
    private CityCode cityCode;
    private TripStatus status;
    private SearchType searchType;
    private String keyWord;

    public TripSearchDto(CityCode cityCode, TripStatus status) {
        this.cityCode = cityCode;
        this.status = status;
    }
    @ToString
    @Getter
    @AllArgsConstructor
    public enum SearchType implements CodeEnum {
        REG_USER_NAME("REG_USER_NAME","예약자 이름"),
        REG_USER_EMAIL("REG_USER_EMAIL","예약자 이메일"),
        REG_USER_PHONE("REG_USER_PHONE","예약자 전화번호");

        private final String code;
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
}
