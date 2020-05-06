package com.guiving.domain.guiver;

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
@Table(name="TB_GUIVER_FEE")
public class GuiverFee implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="guiver_fee_idx")
    private Long id;

    @Column(name = "guiver_fee_grade")
    private Long feeGrade;

    @Column(name = "guiver_fee_gd")
    private Double guivingDefault;
    @Column(name = "guiver_fee_god")
    private Double guivingOverDistance;
    @Column(name = "guiver_fee_got")
    private Double guivingOverTime;

    @Column(name = "guiver_fee_ad")
    private Double airpickgDefault;

    @Column(name = "guiver_fee_aod")
    private Double airpickOverDistance;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "guiver_fee_s_time")
    private Date startTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "guiver_fee_e_time")
    private Date endTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "guiver_fee_reg_time")
    private Date regTime;

}
