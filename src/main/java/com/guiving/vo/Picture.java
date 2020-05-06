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
public class Picture {
    private String url;

    @Builder
    public Picture(String url) {
        this.url = url;
    }

    public boolean isValid(){
        return StringUtils.isNotBlank(url);
    }
}
