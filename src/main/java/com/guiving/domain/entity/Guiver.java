package com.guiving.domain.entity;

import com.guiving.domain.vo.Address;
import com.guiving.domain.vo.MobilePhone;
import com.guiving.domain.vo.Name;
import com.guiving.domain.vo.Picture;
import com.guiving.domain.vo.enums.Gender;
import com.guiving.domain.vo.enums.GuiverType;
import com.guiving.domain.vo.enums.JoinType;
import com.guiving.domain.vo.enums.Language;
import com.guiving.domain.vo.enums.status.GuiverStatus;
import com.guiving.utils.enums.converter.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@ToString(exclude = "company")
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

    @Temporal(TemporalType.DATE)
    @Column(name = "guiver_join_date")
    private Date joinDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "guiver_birth")
    private Date birthDate;

    @Column(name="guiver_gender")
    private Gender gender;

    @Column(name="guiver_status")
    private GuiverStatus status;

    @Column(name="guiver_type")
    private JoinType joinType;

    @Column(name="guiver_flag")
    private GuiverType type;

    @Column(name = "guiver_language")
    private Language language;

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


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "TB_GUIVER_CITY"
            , joinColumns = @JoinColumn(name="guiver_idx")
            ,inverseJoinColumns = @JoinColumn(name = "city_idx"))
    private City city;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "guiver_company_idx")
    private Company company;
}
