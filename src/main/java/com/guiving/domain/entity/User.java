package com.guiving.domain.entity;

import com.guiving.domain.vo.MobilePhone;
import com.guiving.domain.vo.Name;
import com.guiving.domain.vo.Picture;
import com.guiving.domain.vo.enums.JoinType;
import com.guiving.domain.vo.enums.Language;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@ToString
@NoArgsConstructor
@Getter
@Entity
@Table(name="TB_USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_idx")
    private Long id;

    @Column(name="user_email")
    private String email;

    @Column(name="user_pwd")
    private String password;

    @Column(name="user_uid")
    private String uid;

    @Column(name="user_type")
    private JoinType joinType;

    @Column(name = "user_language")
    private Language language;

    @Embedded
    @AttributeOverride(name = "url",column = @Column(name = "user_image_url"))
    private Picture picture;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "firstName",column = @Column(name = "user_f_name")),
            @AttributeOverride(name = "lastName",column = @Column(name = "user_l_name"))
    })
    private Name name;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "phoneNumber",column = @Column(name = "user_phone_num")),
            @AttributeOverride(name = "deviceModel",column = @Column(name = "user_device_model")),
            @AttributeOverride(name = "deviceType",column = @Column(name = "user_device_type")),
            @AttributeOverride(name = "deviceOS",column = @Column(name = "user_device_os_version")),
            @AttributeOverride(name = "appVersion",column = @Column(name = "user_app_version")),
            @AttributeOverride(name = "deviceToken",column = @Column(name = "user_device_token"))
    })
    private MobilePhone mobilePhone;
}
