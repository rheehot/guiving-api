package com.guiving.domain.reservation;

import com.guiving.domain.car.Car;
import com.guiving.domain.company.Company;
import com.guiving.domain.city.City;
import com.guiving.domain.exchangerate.ExchangeRate;
import com.guiving.domain.guiver.Guiver;
import com.guiving.domain.operator.Operator;
import com.guiving.domain.user.User;
import com.guiving.domain.vehicle.Vehicle;
import com.guiving.vo.enums.GuiverType;
import com.guiving.vo.enums.status.ReservationStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
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

    @ManyToOne
    @JoinColumn(name = "vehicle_idx")
    private Vehicle vehicle;

    @Column(name = "res_update_time")
    private LocalDateTime regTime;

    @Column(name = "res_total_cost")
    private Double totalCost;

    @Column(name="res_status")
    private ReservationStatus status;

    @Column(name="exc_set_idx")
    private Long setIdx;

    @OneToMany
    @JoinColumn(name = "exc_set_idx", referencedColumnName ="exc_set_idx" ,insertable = false,updatable = false)
    private Set<ExchangeRate> exchangeRateSet = new LinkedHashSet<>();

    @OneToMany
    @JoinColumn(name = "res_idx")
    private Set<Guiving> guivingSet = new LinkedHashSet<>();

    @Builder
    public Reservation(User user, City city, Car car,
                       Double totalCost, Long setIdx, Set<ExchangeRate> exchangeRateSet) {
        this.user = user;
        this.city = city;
        this.car = car;
        this.regTime = LocalDateTime.now();
        this.totalCost = totalCost;
        this.status = ReservationStatus.WANTED;
        this.setIdx = setIdx;
        this.exchangeRateSet = exchangeRateSet;
    }

    /*
    public void setGuiver(Guiver guiver){
        this.guiver = guiver;
    }
    public void setCompany(Company company){
        this.company = company;
    }
    public void setOperator(Operator operator){
        this.operator = operator;
    }
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    */

    public void matchGuiver(Guiver guiver){
        boolean isFreeLancer = guiver.getType().equals(GuiverType.FREELANCER);

        this.status = isFreeLancer?ReservationStatus.MATCHED:ReservationStatus.DRIVER_MATCHED;
        this.guiver = guiver;

        if(isFreeLancer)
            this.vehicle = guiver.getVehicle();
    }
    public void matchOperator(Operator operator){
        this.company = operator.getCompany();
        this.operator = operator;
        this.status = ReservationStatus.COMPANY_MATCHED;
    }
    public void matchVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
        this.status = ReservationStatus.VEHICLE_MATCHED;
    }
    public void cancel(){
        this.status = ReservationStatus.CANCELED;
    }

}
