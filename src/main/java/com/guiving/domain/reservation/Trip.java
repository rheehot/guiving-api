package com.guiving.domain.reservation;

import com.guiving.domain.place.Place;
import com.guiving.vo.enums.status.TripStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@ToString
@NoArgsConstructor
@Getter
@Entity
@Table(name = "TB_TRIP")
public class Trip implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trip_idx")
    private Long id;

    @Column(name="trip_status")
    private TripStatus status;

    @Column(name="trip_s_time")
    private LocalDate startTime;

    @Column(name="trip_e_time")
    private LocalDate endTime;

    @Column(name="trip_dep_time")
    private LocalDate departedTime;

    @Column(name="trip_quit_time")
    private LocalDate arrivalTime;

    @Column(name="trip_num")
    private Long tripOrder;

    @Column(name="trip_distance")
    private Double distance;

    @OneToOne
    @JoinColumn(name="trip_s_place_idx")
    private Place startPlace;

    @OneToOne
    @JoinColumn(name="trip_e_place_idx")
    private Place finishedPlace;
}
