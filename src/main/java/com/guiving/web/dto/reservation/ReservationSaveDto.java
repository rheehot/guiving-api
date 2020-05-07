package com.guiving.web.dto.reservation;

import com.guiving.domain.user.Card;
import com.guiving.vo.enums.CityCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ReservationSaveDto {
    private Long userId;
    private CityCode cityCode;
    private Long carId;
    //private Long[] costId;


}
