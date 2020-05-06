package com.guiving.vo;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.Embeddable;

@NoArgsConstructor
@EqualsAndHashCode
@Data
@Embeddable
public class PhoneNumber {
    private String phoneNumber;

    @Builder
    public PhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isValid(){
        return StringUtils.isNotBlank(phoneNumber);
    }
}
