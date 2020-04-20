package com.guiving.domain.vo;

import lombok.Data;

import javax.persistence.Embeddable;
import java.util.Base64;

@Data
@Embeddable
public class Picture {
    private String url;
    private Base64 base64str;
}
