package com.guiving.domain.company;

import com.guiving.domain.city.City;
import com.guiving.domain.guiver.Guiver;
import com.guiving.domain.operator.Operator;
import com.guiving.domain.vehicle.Vehicle;
import com.guiving.domain.vo.Address;
import com.guiving.utils.CoreUtils;
import com.guiving.web.dto.company.CompanyUpdateDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@ToString(exclude = {"operatorList","guiverList","vehicleSet"})
@DynamicUpdate
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


    @Column(name="com_build_date")
    private LocalDate buildDate;

    @Column(name="com_biz_num")
    private String bizNum;

    @Column(name="com_auth_code")
    private String authCode;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "state",column = @Column(name = "com_addr_state")),
            @AttributeOverride(name = "city",column = @Column(name = "com_addr_city")),
            @AttributeOverride(name = "street",column = @Column(name = "com_addr"))
    })
    private Address address;

    @OneToOne(mappedBy = "company",cascade = CascadeType.ALL)
    private CompanyFee fee;


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

    @Builder
    public Company(String name, String ownerName, LocalDate buildDate, String bizNum, String authCode, Address address, City city) {
        this.name = name;
        this.ownerName = ownerName;
        this.buildDate = buildDate;
        this.bizNum = bizNum;
        this.authCode = authCode;
        this.address = address;
        this.city = city;
    }

    public int getOpCount(){
        return operatorList.size();
    }
    public int getGuiverCount(){
        return guiverList.size();
    }


    public void generateAuthCode(){
        if(ObjectUtils.isEmpty(bizNum))
            throw new IllegalArgumentException("Business number can not be NULL");
        this.authCode = CoreUtils.getRandomStr()+this.id +bizNum.substring(0,2);
    }

    public void setCity(City city){
        this.city = city;
    }

    public void setCompanyFee(CompanyFee fee){
        this.fee = fee;
        fee.setCompany(this);
    }

    public void addOperator(Operator operator){
        this.operatorList.add(operator);
    }

    public void updateInfo(CompanyUpdateDto requestDto){
        this.name = requestDto.getName();
        this.ownerName = requestDto.getOwnerName();
        if(ObjectUtils.isNotEmpty(requestDto.getBuilDate()))
            this.buildDate = requestDto.getBuilDate();
        if(requestDto.getAddress().isValidated())
            this.address = requestDto.getAddress();
    }
}
