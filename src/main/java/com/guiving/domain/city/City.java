package com.guiving.domain.city;

import com.guiving.domain.company.Company;
import com.guiving.vo.enums.CityCode;
import com.guiving.vo.enums.Currency;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@ToString(exclude = "companies")
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

    @Enumerated(EnumType.STRING)
    @Column(name="city_currency")
    private Currency currency;



    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY)
    private List<Company> companies = new ArrayList<>();
}
