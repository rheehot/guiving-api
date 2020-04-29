package com.guiving.domain.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Embeddable;
import java.util.Base64;

@EqualsAndHashCode
@Data
@Embeddable
public class Picture {
    private String url;
}
