package com.guiving.domain.vo;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Address {
    private String state;
    private String city;
    private String street;
}
