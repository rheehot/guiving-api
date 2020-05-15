package com.guiving.web.dto.reservation;

import com.guiving.domain.reservation.Reservation;
import com.guiving.vo.CityInfo;
import com.guiving.vo.enums.ServiceType;
import com.guiving.vo.enums.status.ReservationStatus;
import com.guiving.web.dto.guiver.GuiverResponseDto;
import com.guiving.web.dto.operator.OperatorResponseDto;
import com.guiving.web.dto.user.UserResponseDto;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
public class ReservationResponseDto {
    private Long id;
    private UserResponseDto user;
    private OperatorResponseDto operator;
    private GuiverResponseDto guiver;
    private ServiceType serviceType;
    private Integer numberOfPersons;
    private ReservationStatus status;
    private LocalDateTime requestedDate;
    private CityInfo cityInfo;

    public ReservationResponseDto(Reservation reservation) {
        this.id = reservation.getId();
        this.user = new UserResponseDto(reservation.getUser());
        this.operator = new OperatorResponseDto(reservation.getOperator());
        this.guiver = new GuiverResponseDto(reservation.getGuiver());
        this.serviceType = reservation.getServiceType();
        this.numberOfPersons = reservation.getNumberOfPersons();
        this.status = reservation.getStatus();
        this.requestedDate = reservation.getRegTime();
        this.cityInfo = new CityInfo(reservation.getCity());
    }
}
