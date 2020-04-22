package com.guiving.domain.entity;

import com.guiving.domain.idclass.CarId;
import com.guiving.domain.vo.enums.CarType;
import com.guiving.domain.vo.enums.GuiverType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
