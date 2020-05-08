package com.guiving.domain.cost;

import com.guiving.domain.car.Car;
import com.guiving.domain.reservation.Trip;
import com.guiving.vo.enums.Currency;
import com.guiving.vo.enums.status.GuivingStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@ToString
@NoArgsConstructor
@Getter
@Entity
@Table(name = "TB_COST")
public class Cost implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cost_idx")
    private Long id;

    @ManyToOne
    @JoinColumn(name="cost_car_idx")
    private Car car;

    @Column(name="cost_date")
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    @Column(name="cost_currency")
    private Currency currency;

    @Column(name="cost_gd")
    private Double guivingDefault;

    @Column(name="cost_god")
    private Double guivingOverDistance;

    @Column(name="cost_got")
    private Double guivingOverTime;

    @Column(name="cost_ad")
    private Double airpickDeault;

    @Column(name="cost_aod")
    private Double airpickOverDistance;


}
