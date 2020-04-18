package com.guiving.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@ToString(exclude = "cityList")
@NoArgsConstructor
@Getter
@Entity
@Table(name="TB_COUNTRY")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="country_idx")
    private Long id;

    @Column(name="country_nm")
    private String name;

    @Column(name="country_code")
    private String code;

    @OneToMany(mappedBy="country", fetch = FetchType.LAZY)
    private List<City> cityList = new ArrayList<City>();
}
