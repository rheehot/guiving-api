package com.guiving.domain.entity;

import com.guiving.domain.vo.Address;
import com.guiving.domain.vo.Name;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@ToString(exclude = "company")
@NoArgsConstructor
@Getter
@Entity
@Table(name="TB_OPERATOR")
public class Operator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="op_idx")
    private Long id;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "firstName",column = @Column(name = "op_f_name")),
            @AttributeOverride(name = "lastName",column = @Column(name = "op_l_name"))
    })
    private Name name;


    @Column(name="op_email")
    private String email;

    @Column(name="op_phone_num")
    private String phoneNum;

    @Column(name="op_password")
    private String password;

    @Column(name="op_uid")
    private String uid;

    @ManyToOne
    @JoinColumn(name = "op_company_idx")
    private Company company;
}
