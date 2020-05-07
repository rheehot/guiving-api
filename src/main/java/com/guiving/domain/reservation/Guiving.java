package com.guiving.domain.reservation;

import com.guiving.domain.car.Car;
import com.guiving.domain.city.City;
import com.guiving.domain.company.Company;
import com.guiving.domain.exchangerate.ExchangeRate;
import com.guiving.domain.guiver.Guiver;
import com.guiving.domain.operator.Operator;
import com.guiving.domain.user.User;
import com.guiving.domain.vehicle.Vehicle;
import com.guiving.vo.enums.status.GuivingStatus;
import com.guiving.vo.enums.status.ReservationStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@ToString
@NoArgsConstructor
@Getter
@Entity
@Table(name = "TB_GUIVING")
public class Guiving implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "guiving_idx")
    private Long id;

    @Column(name="guiving_status")
    private GuivingStatus status;

    @Column(name="res_date")
    private LocalDate serviceDate;

    @OneToMany
    @JoinColumn(name = "guiving_idx")
    private Set<Trip> tripSet = new LinkedHashSet<>();

    public void addTrip(Trip trip){
        tripSet.add(trip);
    }

}
