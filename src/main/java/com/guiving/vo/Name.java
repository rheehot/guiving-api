package com.guiving.vo;

import lombok.*;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.Embeddable;

@EqualsAndHashCode
@NoArgsConstructor
@Embeddable
@Data
public class Name {
    private String firstName;
    private String lastName;

    @Builder
    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFullName(){
        return firstName+" " + lastName;
    }

    public boolean isValid(){
        return StringUtils.isNoneBlank(firstName,lastName);
    }
}
