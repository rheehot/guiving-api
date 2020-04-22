package com.guiving.domain.entity;

import com.guiving.domain.vo.MobilePhone;
import com.guiving.domain.vo.Name;
import com.guiving.domain.vo.Picture;
import com.guiving.domain.vo.enums.Gender;
import com.guiving.domain.vo.enums.JoinType;
import com.guiving.domain.vo.enums.Language;
import com.guiving.domain.vo.enums.status.OperatorStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@ToString
@NoArgsConstructor
@Getter
@Entity
@Table(name="TB_OPERATOR")
public class Operator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="op_idx")
    private Long id;

    @Column(name="op_email")
    private String email;

    @Column(name="op_password")
    private String password;

    @Column(name="op_uid")
    private String uid;

    @Temporal(TemporalType.DATE)
    @Column(name = "op_join_date")
    private Date joinDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "op_birth")
    private Date birthDate;

    @Column(name="op_gender")
    private Gender gender;

    @Column(name="op_status")
    private OperatorStatus status;

    @Column(name = "op_type")
    private JoinType joinType;

    @Column(name = "op_language")
    private Language language;

    @Embedded
    @AttributeOverride(name = "url",column = @Column(name = "op_img_url"))
    private Picture picture;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "firstName",column = @Column(name = "op_f_name")),
            @AttributeOverride(name = "lastName",column = @Column(name = "op_l_name"))
    })
    private Name name;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "phoneNumber",column = @Column(name = "op_phone_num")),
            @AttributeOverride(name = "deviceModel",column = @Column(name = "op_device_model")),
            @AttributeOverride(name = "deviceType",column = @Column(name = "op_device_type")),
            @AttributeOverride(name = "deviceOS",column = @Column(name = "op_device_os_version")),
            @AttributeOverride(name = "appVersion",column = @Column(name = "op_app_version")),
            @AttributeOverride(name = "deviceToken",column = @Column(name = "op_device_token"))
    })
    private MobilePhone mobilePhone;

    @ManyToOne
    @JoinColumn(name = "op_company_idx")
    private Company company;
}
