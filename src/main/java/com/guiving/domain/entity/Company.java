package com.guiving.domain.entity;

import com.guiving.domain.vo.Address;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ToString(exclude = "operatorList")
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
    private String comName;

    @Column(name="com_owner_name")
    private String comOwnerName;

    @Temporal(TemporalType.DATE)
    @Column(name="com_build_date")
    private Date comBuildDate;

    @Column(name="com_biz_num")
    private String comBizNum;

    @Column(name="com_biz_license_url")
    private String comBizLicenseUrl;

    @Column(name="com_auth_code")
    private String comAuthCode;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "state",column = @Column(name = "com_addr_state")),
            @AttributeOverride(name = "city",column = @Column(name = "com_addr_city")),
            @AttributeOverride(name = "street",column = @Column(name = "com_addr"))
    })
    private Address address;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "TB_COM_CITY"
            , joinColumns = @JoinColumn(name="com_idx")
            ,inverseJoinColumns = @JoinColumn(name = "city_idx"))
    private City city;

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private List<Operator> operatorList = new ArrayList<>();

    public int getOpCount(){
        return operatorList.size();
    }
}
