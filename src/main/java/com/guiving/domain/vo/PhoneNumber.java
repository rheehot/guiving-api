package com.guiving.domain.vo;


import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class PhoneNumber {

    private String areaCode;
    private String localNumber;

    public String getPhoneNumber(){
        return areaCode+"-"+localNumber;
    }

}