package com.guiving.domain.reservation;

import com.guiving.vo.enums.CityCode;
import com.guiving.vo.enums.status.ReservationStatus;
import com.guiving.web.dto.reservation.ReservationSearchDto;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import static com.guiving.domain.reservation.QReservation.reservation;

@RequiredArgsConstructor
public class ReservationRepositoryImpl implements ReservationRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    @Override
    public Page<Reservation> searchAll(ReservationSearchDto search, Pageable pageable){
        QueryResults<Reservation> result = queryFactory
                .selectFrom(reservation)
                .where(
                        eqCity(search.getCityCode()),
                        eqStatus(search.getStatus())
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();
        return new PageImpl<>(result.getResults(),pageable,result.getTotal());
    }

    private BooleanExpression eqCity(CityCode cityCode) {
        if (ObjectUtils.isEmpty(cityCode)) {
            return null;
        }
        return reservation.city.code.eq(cityCode);
    }
    private BooleanExpression eqStatus(ReservationStatus status) {
        if (ObjectUtils.isEmpty(status)) {
            return null;
        }
        return reservation.status.eq(status);
    }


}
