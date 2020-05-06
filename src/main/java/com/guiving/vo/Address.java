package com.guiving.vo;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.Embeddable;

@NoArgsConstructor
@Data
@EqualsAndHashCode
@Embeddable
public class Address {
    private String state;
    private String city;
    private String street;

    @Builder
    public Address(String state, String city, String street) {
        this.state = state;
        this.city = city;
        this.street = street;
    }

    public boolean isValid(){
        return StringUtils.isNoneBlank(state,city,state);
    }
}
