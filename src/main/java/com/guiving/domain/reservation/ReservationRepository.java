package com.guiving.domain.reservation;

import com.guiving.domain.reservation.Reservation;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,Long>, ReservationRepositoryCustom {
    @EntityGraph(attributePaths ={"company","guiver","guiver.vehicle","guiver.vehicle.carModel","operator"} )
    @Query("select r from Reservation r join fetch r.city ct join fetch r.user join fetch r.car join fetch r.exchangeRateSet")
    List<Reservation> findAll();

}
