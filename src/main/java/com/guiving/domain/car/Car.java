package com.guiving.domain.car;

import com.guiving.domain.city.City;
import com.guiving.vo.enums.CarGrade;
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

    @Column(name="car_model_grade")
    private CarGrade grade;

    @Column(name="car_desc")
    private String desc;



}
