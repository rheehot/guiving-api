package com.guiving.domain.vehicle;

import com.guiving.domain.carmodel.CarModel;
import com.guiving.domain.company.Company;
import com.guiving.domain.guiver.Guiver;
import com.guiving.vo.enums.status.VehicleStatus;
import com.guiving.web.dto.vehicle.VehicleUpdateReqeustDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    @Column(name = "vehicle_reged_time")
    private LocalDateTime regTime;


    @Column(name = "vehicle_status")
    private VehicleStatus status;

    @ManyToOne
    @JoinColumn(name = "vehicle_car_model_idx")
    private CarModel carModel;

    @OneToOne
    @JoinColumn(name = "vehicle_guiver_idx")
    private Guiver guiver;

    @ManyToOne
    @JoinColumn(name = "vehicle_com_idx")
    private Company company;

    @Builder
    public Vehicle(String number, String year, String color) {
        this.number = number;
        this.year = year;
        this.color = color;
        this.status = VehicleStatus.AVAILABLE;
        this.regTime = LocalDateTime.now();
    }

    public void setCompany(Company company) {
        this.company = company;
        company.addVehicle(this);
    }

    public void unsetGuiver(){
        this.guiver =null;
    }

    public void setGuiver(Guiver guiver) {
        if(ObjectUtils.isNotEmpty(guiver.getVehicle())){
            guiver.getVehicle().unsetGuiver();
        }
        this.guiver = guiver;
        guiver.setVehicle(this);
    }

    public void setCarModel(CarModel carModel){
        this.carModel = carModel;
    }

    public void updateInfo(VehicleUpdateReqeustDto reqeustDto){
        if(StringUtils.isNotBlank(reqeustDto.getColor()))
            this.color = reqeustDto.getColor();
        if(StringUtils.isNotBlank(reqeustDto.getYear()))
            this.year = reqeustDto.getYear();
        if(StringUtils.isNotBlank(reqeustDto.getNumber()))
            this.number = reqeustDto.getNumber();

    }

}
