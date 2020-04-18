package com.guiving.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
;

@ToString
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

    @Column(name="com_build_date")
    private String comBuildDate;

    @Column(name="com_biz_num")
    private String comBizNum;

    @Column(name="com_addr")
    private String comAddr;

    @Column(name="com_biz_license_url")
    private String comBizLicenseUrl;

    @Column(name="com_auth_code")
    private String comAuthCode;

    @Column(name="com_addr_city")
    private String comAddrCity;

    @Column(name="com_addr_state")
    private String comAddrState;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "TB_COM_CITY"
            , joinColumns = @JoinColumn(name="com_idx")
            ,inverseJoinColumns = @JoinColumn(name = "city_idx"))
    private City city;

}
