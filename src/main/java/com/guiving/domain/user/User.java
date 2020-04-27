package com.guiving.domain.user;

import com.guiving.domain.vo.MobilePhone;
import com.guiving.domain.vo.Name;
import com.guiving.domain.vo.Picture;
import com.guiving.domain.vo.enums.JoinType;
import com.guiving.domain.vo.enums.Language;
import com.guiving.web.dto.user.UserUpdateRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.commons.lang3.ObjectUtils;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@ToString(exclude = "cardSet")
@NoArgsConstructor
@Getter
@DynamicUpdate
@Entity
@Table(name = "TB_USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_idx")
    private Long id;

    @Column(name = "user_email")
    private String email;

    @Column(name = "user_pwd")
    private String password;

    @Column(name = "user_uid")
    private String uid;

    @Column(name = "user_type")
    private JoinType joinType;

    @Column(name = "user_language")
    private Language language;

    @Column(name = "user_status")
    private Long status = 1L;

    @Column(name = "user_terms_agree_yn")
    private String termsAgree = "Y";

    @Column(name = "user_opt_terms_agree_yn")
    private String optTermsAgree = "Y";

    @Column(name = "user_nation")
    private String nation;

    @Embedded
    @AttributeOverride(name = "url", column = @Column(name = "user_image_url"))
    private Picture picture;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "firstName", column = @Column(name = "user_f_name")),
            @AttributeOverride(name = "lastName", column = @Column(name = "user_l_name"))
    })
    private Name name;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "phoneNumber", column = @Column(name = "user_phone_num")),
            @AttributeOverride(name = "deviceModel", column = @Column(name = "user_device_model")),
            @AttributeOverride(name = "deviceType", column = @Column(name = "user_device_type")),
            @AttributeOverride(name = "deviceOS", column = @Column(name = "user_device_os_version")),
            @AttributeOverride(name = "appVersion", column = @Column(name = "user_app_version")),
            @AttributeOverride(name = "deviceToken", column = @Column(name = "user_device_token"))
    })
    private MobilePhone mobilePhone;

    @OneToMany(mappedBy = "user")
    private Set<Card> cardSet = new LinkedHashSet<>();

    @Builder
    public User(Long id, String email, String password, String uid, String nation,
                JoinType joinType, Language language, Picture picture, Name name, MobilePhone mobilePhone) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.uid = uid;
        this.joinType = joinType;
        this.language = language;
        this.picture = picture;
        this.name = name;
        this.mobilePhone = mobilePhone;
        this.nation = nation;
    }

    public void updateInfo(UserUpdateRequestDto requestDto){
        if(ObjectUtils.isEmpty(requestDto.getName()))
            throw new IllegalArgumentException("요청 파라미터가 NULL입니다.");
        this.name = requestDto.getName();
        this.mobilePhone.setPhoneNumber(requestDto.getPhoneNumber());
        this.language = Language.valueOf(requestDto.getLanguage());
        this.nation = requestDto.getNation();
    }

    public void updatePassword(String password){
        this.password = password;
    }
}
