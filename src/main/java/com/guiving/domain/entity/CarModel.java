package com.guiving.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@ToString
@NoArgsConstructor
@Getter
@Entity
@Table(name = "TB_CAR_MODEL")
public class CarModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cm_idx")
    private Long id;

    @Column(name = "cm_make")
    private String brand;

    @Column(name = "cm_model")
    private String model;

    @Column(name = "cm_seater")
    private String seats;


}
