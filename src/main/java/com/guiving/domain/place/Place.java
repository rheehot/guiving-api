package com.guiving.domain.place;

import com.guiving.vo.enums.status.TripStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@ToString
@NoArgsConstructor
@Getter
@Entity
@Table(name = "TB_PLACE")
public class Place implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "place_idx")
    private Long id;

    @Column(name="place_name")
    private String name;

    @Column(name="place_name_sub")
    private String subName;

    @Column(name="place_addr")
    private String address;

    @Column(name="place_latitude")
    private Double latitude;

    @Column(name="place_longitude")
    private Double longitude;


}
