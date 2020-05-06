package com.guiving.domain.reservation;

import com.guiving.domain.city.City;
import com.guiving.vo.enums.CarType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@ToString(exclude = "city")
@NoArgsConstructor
@Getter
@Entity
@Table(name="TB_CAR")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="car_idx")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "city_idx")
    private City city;

    @Enumerated(EnumType.STRING)
    @Column(name="car_title")
    private CarType type;

    @Column(name="car_desc")
    private String desc;



}
