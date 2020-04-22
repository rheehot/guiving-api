package com.guiving.domain.idclass;

import com.guiving.domain.entity.City;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class CarId implements Serializable {

    private static final long serialVersionUID = 1L;

    @EqualsAndHashCode.Include
    private Long grade;

    @EqualsAndHashCode.Include
    private Long city;

    public CarId(Long grade, Long city) {
        this.grade = grade;
        this.city = city;
    }
}
