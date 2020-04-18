package com.guiving.domain.entity;

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

    @Column(name="city_nm")
    private String name;
    @Column(name="city_code")
    private String code;
    @Column(name="city_currency")
    private String currency;

    @ManyToOne
    @JoinColumn(name = "country_idx")
    private Country country;

    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY)
    private List<Company> companyList = new ArrayList<>();
}
