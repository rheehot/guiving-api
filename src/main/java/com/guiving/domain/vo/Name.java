package com.guiving.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class Name {
    private String firstName;
    private String lastName;

    public String getFullName(){
        return firstName+" " + lastName;
    }
}
