package com.guiving.domain.user;

import com.guiving.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@ToString(exclude = "user")
@NoArgsConstructor
@Getter
@Entity
@Table(name="TB_CARD_INFO")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="card_idx")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "card_user_idx")
    private User user;

    @Column(name="card_pub_company")
    private String pubCompany;

    @Column(name="card_num")
    private String cardNum;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="card_reg_time")
    private Date regTime;

    @Column(name="card_billkey")
    private String billKey;

    @Column(name="card_is_default")
    private Boolean isDefault;

    @Column(name="card_domestic_flag")
    private String domesticFlag;

}
