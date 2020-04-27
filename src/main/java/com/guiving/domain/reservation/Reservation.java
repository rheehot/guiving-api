package com.guiving.domain.reservation;

import com.guiving.domain.company.Company;
import com.guiving.domain.city.City;
import com.guiving.domain.guiver.Guiver;
import com.guiving.domain.operator.Operator;
import com.guiving.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@ToString(exclude = "exchangeRateSet")
@NoArgsConstructor
@Getter
@Entity
@Table(name = "TB_RESERVATION")
public class Reservation implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "res_idx")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_idx")
    private User user;

    @ManyToOne
    @JoinColumn(name = "guiver_idx")
    private Guiver guiver;

    @ManyToOne
    @JoinColumn(name = "city_idx")
    private City city;

    @ManyToOne
    @JoinColumn(name = "car_idx")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "op_idx")
    private Operator operator;

    @ManyToOne
    @JoinColumn(name = "com_idx")
    private Company company;

    @Column(name = "res_total_cost")
    private Double totalCost;

    @Column(name="exc_set_idx")
    private Long setIdx;

    @OneToMany
    @JoinColumn(name = "exc_set_idx", referencedColumnName ="exc_set_idx" ,insertable = false,updatable = false)
    private Set<ExchangeRate> exchangeRateSet = new LinkedHashSet<>();

}
