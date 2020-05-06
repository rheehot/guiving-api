package com.guiving.domain.reservation;

import com.guiving.vo.enums.Currency;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@ToString
@NoArgsConstructor
@Getter
@Entity
@Table(name="TB_EXCHANGE_RATE")
public class ExchangeRate implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="exc_idx")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "exc_base")
    private Currency base;

    @Enumerated(EnumType.STRING)
    @Column(name="exc_symbol")
    private Currency symbol;

    @Column(name="exc_rate")
    private Double rate;

    @Temporal(TemporalType.DATE)
    @Column(name="exc_date")
    private Date date;

}
