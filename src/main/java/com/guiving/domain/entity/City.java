package com.guiving.domain.entity;

import com.guiving.domain.vo.enums.CityCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@ToString(exclude = "companyList")
@NoArgsConstructor
@Getter
@Entity
@Table(name="TB_CITY")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="city_idx")
    private Long id;



    @Enumerated(EnumType.STRING)
    @Column(name="city_code")
    private CityCode code;

    /*
    @Column(name="city_nm")
    private String name;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "country_idx")
    private Country country;
     */

    @Column(name="city_currency")
    private String currency;



    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY)
    private List<Company> companyList = new ArrayList<>();
}
