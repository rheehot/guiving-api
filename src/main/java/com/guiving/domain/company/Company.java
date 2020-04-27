package com.guiving.domain.company;

import com.guiving.domain.city.City;
import com.guiving.domain.guiver.Guiver;
import com.guiving.domain.operator.Operator;
import com.guiving.domain.vehicle.Vehicle;
import com.guiving.domain.vo.Address;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.*;

@ToString(exclude = {"operatorList","guiverList","vehicleSet"})
@NoArgsConstructor
@Getter
@Entity
@Table(name="TB_COMPANY")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="com_idx")
    private Long id;

    @Column(name="com_name")
    private String name;

    @Column(name="com_owner_name")
    private String ownerName;

    @Temporal(TemporalType.DATE)
    @Column(name="com_build_date")
    private Date buildDate;

    @Column(name="com_biz_num")
    private String bizNum;

    @Column(name="com_auth_code")
    private String comAuthCode;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "state",column = @Column(name = "com_addr_state")),
            @AttributeOverride(name = "city",column = @Column(name = "com_addr_city")),
            @AttributeOverride(name = "street",column = @Column(name = "com_addr"))
    })
    private Address address;


    @ManyToOne
    @JoinTable(name = "TB_COM_CITY"
            , joinColumns = @JoinColumn(name="com_idx")
            ,inverseJoinColumns = @JoinColumn(name = "city_idx"))
    private City city;

    @OneToMany(mappedBy = "company")
    private List<Operator> operatorList = new ArrayList<>();

    @OneToMany(mappedBy = "company")
    private List<Guiver> guiverList = new ArrayList<>();

    @OneToMany(mappedBy = "company")
    private Set<Vehicle> vehicleSet = new LinkedHashSet<>();

    public int getOpCount(){
        return operatorList.size();
    }
    public int getGuiverCount(){
        return guiverList.size();
    }



}
