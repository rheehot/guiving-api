package com.guiving.domain.reservation;

import com.guiving.web.dto.reservation.ReservationSearchDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReservationRepositoryCustom {
    Page<Reservation> searchAll(ReservationSearchDto search, Pageable pageable);
}
