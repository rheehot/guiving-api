package com.guiving.web.dto.reservation;

import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.Getter;
import lombok.ToString;

import java.util.function.Function;

import static com.guiving.domain.reservation.QReservation.reservation;

@ToString
@Getter
public enum ReservationSearchType {
    REG_USER_NAME(str -> reservation.user.name.firstName.concat(" ").concat(reservation.user.name.lastName).contains(str)),
    REG_USER_EMAIL(str -> reservation.user.email.contains(str)),
    REG_USER_PHONE(str -> reservation.user.phoneNumber.phoneNumber.contains(str));

    private Function<String, BooleanExpression> expression;

    ReservationSearchType(Function<String,BooleanExpression> expression){this.expression = expression;}

    public BooleanExpression getEq(String keyWord){
        return expression.apply(keyWord);
    }
}
