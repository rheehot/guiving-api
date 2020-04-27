package com.guiving.domain.guiver;

import com.guiving.domain.company.Company;
import com.guiving.domain.city.City;
import com.guiving.domain.vehicle.Vehicle;
import com.guiving.domain.vo.Address;
import com.guiving.domain.vo.MobilePhone;
import com.guiving.domain.vo.Name;
import com.guiving.domain.vo.Picture;
import com.guiving.domain.vo.enums.*;
import com.guiving.domain.vo.enums.status.GuiverCompanyStatus;
import com.guiving.domain.vo.enums.status.GuiverStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@ToString(exclude = {"company","vehicle"})
@NoArgsConstructor
@Getter
@Entity
@Table(name="TB_GUIVER")
public class Guiver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="guiver_idx")
    private Long id;

    @Column(name="guiver_email")
    private String email;

    @Column(name="guiver_password")
    private String password;

    @Column(name="guiver_uid")
    private String uid;

    @Column(name = "guiver_join_date")
    private LocalDate joinDate;

    @Column(name = "guiver_birth")
    private LocalDate birthDate;

    @Column(name="guiver_gender")
    private Gender gender;

    @Column(name="guiver_status")
    private GuiverStatus status;

    @Column(name="guiver_company_status")
    private GuiverCompanyStatus companyStatus;

    @Column(name="guiver_type")
    private JoinType joinType;

    @Column(name="guiver_flag")
    private GuiverType type;

    @Column(name = "guiver_language")
    private Language language;

    @Column(name = "guiver_terms_agree_yn")
    private String termsAgree = "Y";

    @Enumerated(EnumType.STRING)
    @Column(name = "guiver_exc_symbol")
    private Currency currency;

    @Embedded
    @AttributeOverride(name = "url",column = @Column(name = "guiver_img_url"))
    private Picture picture;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "firstName",column = @Column(name = "guiver_f_name")),
            @AttributeOverride(name = "lastName",column = @Column(name = "guiver_l_name"))
    })
    private Name name;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "phoneNumber",column = @Column(name = "guiver_phone_num")),
            @AttributeOverride(name = "deviceModel",column = @Column(name = "guiver_device_model")),
            @AttributeOverride(name = "deviceType",column = @Column(name = "guiver_device_type")),
            @AttributeOverride(name = "deviceOS",column = @Column(name = "guiver_device_os_version")),
            @AttributeOverride(name = "appVersion",column = @Column(name = "guiver_app_version")),
            @AttributeOverride(name = "deviceToken",column = @Column(name = "guiver_device_token"))
    })
    private MobilePhone mobilePhone;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "state",column = @Column(name = "guiver_addr_state")),
            @AttributeOverride(name = "city",column = @Column(name = "guiver_addr_city")),
            @AttributeOverride(name = "street",column = @Column(name = "guiver_addr"))
    })
    private Address address;


    @ManyToOne
    @JoinTable(name = "TB_GUIVER_CITY"
            , joinColumns = @JoinColumn(name="guiver_idx")
            ,inverseJoinColumns = @JoinColumn(name = "city_idx"))
    private City city;

    @ManyToOne
    @JoinColumn(name = "guiver_company_idx")
    private Company company;

    @OneToOne(mappedBy = "guiver")
    private Vehicle vehicle;

    @Column(name = "guiver_fee_grade")
    private Long feeGrade;

    @ManyToOne
    @JoinColumn(name = "guiver_fee_grade",referencedColumnName = "guiver_fee_grade",insertable = false,updatable = false)
    private GuiverFee fee;



    @Builder
    public Guiver(Long id, String email, String password, String uid, LocalDate joinDate,
                  LocalDate birthDate, Gender gender,
                  JoinType joinType, GuiverType type, Language language, Picture picture, Name name,
                  MobilePhone mobilePhone, Address address, City city, Company company, Vehicle vehicle, GuiverFee fee) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.uid = uid;
        this.joinDate = LocalDate.now();
        this.birthDate = birthDate;
        this.gender = gender;
        this.status = GuiverStatus.JOINED;
        this.companyStatus = GuiverCompanyStatus.STANDBY;
        this.joinType = joinType;
        this.type = type;
        this.language = language;
        this.picture = picture;
        this.name = name;
        this.mobilePhone = mobilePhone;
        this.address = address;
        this.city = city;
        this.company = company;
        this.vehicle = vehicle;
        this.feeGrade = 0L;
        this.fee = fee;
    }

    public void setCity(City city){
        this.city = city;
        this.currency = city.getCurrency();
    }
}
