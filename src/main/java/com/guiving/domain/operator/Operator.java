package com.guiving.domain.operator;

import com.guiving.domain.company.Company;
import com.guiving.vo.DeviceInfo;
import com.guiving.vo.Name;
import com.guiving.vo.PhoneNumber;
import com.guiving.vo.Picture;
import com.guiving.vo.enums.*;
import com.guiving.vo.enums.status.OperatorStatus;
import com.guiving.web.dto.operator.OperatorRegisterRequestDto;
import com.guiving.web.dto.operator.OperatorUpdateRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDate;

@ToString
@NoArgsConstructor
@DynamicUpdate
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

    @Column(name="op_terms_agree_yn")
    private String termsAgree;

    @Column(name="op_position")
    private String position;

    @Column(name="op_department")
    private String department;

    @Column(name = "op_join_date")
    private LocalDate joinDate;

    @Column(name = "op_birth")
    private LocalDate birthDate;

    @Column(name="op_gender")
    private Gender gender;

    @Column(name="op_status")
    private OperatorStatus status;

    @Enumerated(EnumType.STRING)
    @Column(name="op_exc_symbol")
    private Currency currency;

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
    @AttributeOverride(name = "phoneNumber",column = @Column(name = "op_phone_num"))
    private PhoneNumber phoneNumber;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "deviceModel",column = @Column(name = "op_device_model")),
            @AttributeOverride(name = "deviceType",column = @Column(name = "op_device_type")),
            @AttributeOverride(name = "deviceOS",column = @Column(name = "op_device_os_version")),
            @AttributeOverride(name = "appVersion",column = @Column(name = "op_app_version")),
            @AttributeOverride(name = "deviceToken",column = @Column(name = "op_device_token"))
    })
    private DeviceInfo deviceInfo;

    @ManyToOne
    @JoinColumn(name = "op_company_idx")
    private Company company;

    @Builder
    public Operator(String email, String password, String uid,
                    LocalDate birthDate, Gender gender, JoinType joinType,
                    Language language, Picture picture, Name name, PhoneNumber phoneNumber) {
        this.email = email;
        this.password = password;
        this.termsAgree = "Y";
        this.currency = Currency.USD;
        this.uid = uid;
        this.joinDate = LocalDate.now();
        this.birthDate = birthDate;
        this.gender = gender;
        this.status = OperatorStatus.JOINED;
        this.joinType = joinType;
        this.language = language;
        this.picture = picture;
        this.deviceInfo = DeviceInfo.builder().deviceType(DeviceType.NONE).build();
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public void setCompany(Company company){
        this.company = company;
        company.addOperator(this);
    }

    public void updateInfo(OperatorUpdateRequestDto requestDto){
        if(requestDto.getName().isValid())
            this.name = requestDto.getName();

        if(ObjectUtils.isNotEmpty(requestDto.getBirthDate()))
            this.birthDate = requestDto.getBirthDate();

        if(requestDto.getPhoneNumber().isValid())
            this.phoneNumber = requestDto.getPhoneNumber();
    }

    public void registerInfo(OperatorRegisterRequestDto requestDto){
        this.status = OperatorStatus.STANDBY;

        if(StringUtils.isNotBlank(requestDto.getDepartment()))
            this.department = requestDto.getDepartment();
        if(StringUtils.isNotBlank(requestDto.getPosition()))
            this.position = requestDto.getPosition();
        if(ObjectUtils.isNotEmpty(requestDto.getJoinDate()))
            this.joinDate = requestDto.getJoinDate();
    }

    public void approval(){
        if(this.status.equals(OperatorStatus.JOINED))
            throw new IllegalArgumentException("Operator can not be allowed before registration");

        this.status = OperatorStatus.COMPLETED;
    }
}
