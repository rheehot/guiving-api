package com.guiving.service;

import com.guiving.domain.reservation.Reservation;
import com.guiving.domain.reservation.ReservationRepository;
import com.guiving.web.dto.reservation.ReservationResponseDto;
import com.guiving.web.dto.reservation.ReservationSearchDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    @Transactional(readOnly = true)
    public Page<ReservationResponseDto> searchAll(ReservationSearchDto search, Pageable pageable){
        return reservationRepository.searchAll(search,pageable)
                .map(ReservationResponseDto::new);
    }

    private Reservation findReservationById(Long id){
        return reservationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Company does not exist. id : " + id));
    }
}
