package com.guiving.domain.vehicle;

import com.guiving.domain.company.Company;
import com.guiving.domain.guiver.Guiver;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@ToString(exclude = {"company","guiver"})
@NoArgsConstructor
@Getter
@Entity
@Table(name="TB_VEHICLE")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="vehicle_idx")
    private Long id;

    @Column(name = "vehicle_number")
    private String number;

    @Column(name = "vehicle_year")
    private String year;

    @Column(name = "vehicle_color")
    private String color;

    @ManyToOne
    @JoinColumn(name = "vehicle_car_model_idx")
    private CarModel carModel;

    @OneToOne
    @JoinColumn(name = "vehicle_guiver_idx")
    private Guiver guiver;

    @ManyToOne
    @JoinColumn(name = "vehicle_com_idx")
    private Company company;

}
