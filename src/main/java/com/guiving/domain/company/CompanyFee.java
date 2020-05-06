package com.guiving.domain.company;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@ToString(exclude = "company")
@Getter
@Entity
@Table(name="TB_COM_FEE")
public class CompanyFee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="com_fee_idx")
    private Long id;

    @Column(name="com_fee_gd")
    private Double guivingDefault;

    @Column(name="com_fee_god")
    private Double guivingOverDistance;
    @Column(name="com_fee_got")
    private Double guivingOverTime;

    @Column(name="com_fee_ad")
    private Double airpickgDefault;

    @Column(name="com_fee_aod")
    private Double airpickOverDistance;

    @Column(name ="com_fee_s_time")
    private LocalDateTime startTime;


    @Column(name ="com_fee_E_time")
    private LocalDateTime endTime;


    @Column(name ="com_fee_reg_time")
    private LocalDateTime regTime;

    @OneToOne
    @JoinColumn(name = "com_idx")
    private Company company;

    public CompanyFee() {
        this.guivingDefault = 0.15;
        this.guivingOverDistance = 0.15;
        this.guivingOverTime = 0.1;
        this.airpickgDefault = 0.1;
        this.airpickOverDistance = 0.1;
        this.startTime = LocalDateTime.now();
        this.endTime = LocalDateTime.now().plusYears(10L);
        this.regTime = LocalDateTime.now();
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
