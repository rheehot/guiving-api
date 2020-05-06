package com.guiving.domain.guiver;

import com.guiving.domain.company.Company;
import com.guiving.domain.city.City;
import com.guiving.domain.vehicle.Vehicle;
import com.guiving.vo.*;
import com.guiving.vo.enums.*;
import com.guiving.vo.enums.status.GuiverCompanyStatus;
import com.guiving.vo.enums.status.GuiverStatus;
import com.guiving.web.dto.guiver.GuiverLicenseDto;
import com.guiving.web.dto.guiver.GuiverPersonalInfoDto;
import com.guiving.web.dto.guiver.GuiverUpdateRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDate;

@ToString(exclude = {"company", "vehicle"})
@NoArgsConstructor
@Getter
@Entity
@DynamicUpdate
@Table(name = "TB_GUIVER")
public class Guiver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "guiver_idx")
    private Long id;

    @Column(name = "guiver_email")
    private String email;

    @Column(name = "guiver_password")
    private String password;

    @Column(name = "guiver_uid")
    private String uid;

    @Column(name = "guiver_join_date")
    private LocalDate joinDate;

    @Column(name = "guiver_birth")
    private LocalDate birthDate;

    @Column(name = "guiver_gender")
    private Gender gender;

    @Column(name = "guiver_status")
    private GuiverStatus status;

    @Column(name = "guiver_company_status")
    private GuiverCompanyStatus companyStatus;

    @Column(name = "guiver_type")
    private JoinType joinType;

    @Column(name = "guiver_flag")
    private GuiverType type;

    @Column(name = "guiver_language")
    private Language language;

    @Column(name = "guiver_terms_agree_yn")
    private String termsAgree = "Y";

    @Enumerated(EnumType.STRING)
    @Column(name = "guiver_exc_symbol")
    private Currency currency;

    @Embedded
    @AttributeOverride(name = "url", column = @Column(name = "guiver_img_url"))
    private Picture profile;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "firstName", column = @Column(name = "guiver_f_name")),
            @AttributeOverride(name = "lastName", column = @Column(name = "guiver_l_name"))
    })
    private Name name;

    @Embedded
    @AttributeOverride(name = "phoneNumber", column = @Column(name = "guiver_phone_num"))
    private PhoneNumber phoneNumber;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "deviceModel", column = @Column(name = "guiver_device_model")),
            @AttributeOverride(name = "deviceType", column = @Column(name = "guiver_device_type")),
            @AttributeOverride(name = "deviceOS", column = @Column(name = "guiver_device_os_version")),
            @AttributeOverride(name = "appVersion", column = @Column(name = "guiver_app_version")),
            @AttributeOverride(name = "deviceToken", column = @Column(name = "guiver_device_token"))
    })
    private DeviceInfo deviceInfo;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "state", column = @Column(name = "guiver_addr_state")),
            @AttributeOverride(name = "city", column = @Column(name = "guiver_addr_city")),
            @AttributeOverride(name = "street", column = @Column(name = "guiver_addr"))
    })
    private Address address;


    @ManyToOne
    @JoinTable(name = "TB_GUIVER_CITY"
            , joinColumns = @JoinColumn(name = "guiver_idx")
            , inverseJoinColumns = @JoinColumn(name = "city_idx"))
    private City city;

    @ManyToOne
    @JoinColumn(name = "guiver_company_idx")
    private Company company;

    @OneToOne(mappedBy = "guiver")
    private Vehicle vehicle;

    @Column(name = "guiver_fee_grade")
    private Long feeGrade;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "guiver_fee_grade", referencedColumnName = "guiver_fee_grade", insertable = false, updatable = false)
    private GuiverFee fee;

    @OneToOne(mappedBy = "guiver", cascade = CascadeType.ALL, orphanRemoval = true)
    private CriminalReport criminalReport;

    @OneToOne(mappedBy = "guiver", cascade = CascadeType.ALL, orphanRemoval = true)
    private ProofOfResidency proofOfResidency;

    @OneToOne(mappedBy = "guiver", cascade = CascadeType.ALL, orphanRemoval = true)
    private DriverLicense driverLicense;


    @Builder
    public Guiver(String email, String password, String uid, LocalDate birthDate, Gender gender,
                  JoinType joinType, GuiverType type, Language language, Picture profile, Name name,
                  PhoneNumber phoneNumber, Address address, City city) {
        this.email = email;
        this.password = password;
        this.uid = uid;
        this.joinDate = LocalDate.now();
        this.birthDate = birthDate;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.status = GuiverStatus.JOINED;
        this.companyStatus = GuiverCompanyStatus.STANDBY;
        this.joinType = joinType;
        this.type = type;
        this.language = language;
        this.profile = profile;
        this.name = name;
        this.deviceInfo = DeviceInfo.builder().deviceType(DeviceType.NONE).build();
        this.address = address;
        this.city = city;
        this.feeGrade = 0L;
    }

    public void setCity(City city) {
        this.city = city;
        this.currency = city.getCurrency();
    }

    public void setCompany(Company company){
        this.company = company;
        company.addGuiver(this);
    }

    private void setCriminalReport(CriminalReport criminalReport) {
        this.criminalReport = criminalReport;
        criminalReport.setGuiver(this);
    }

    private void setProofOfResidency(ProofOfResidency proofOfResidency){
        this.proofOfResidency = proofOfResidency;
        proofOfResidency.setGuiver(this);
    }

    public void setDriverLicense(GuiverLicenseDto requestDto) {
        DriverLicense driverLicense = DriverLicense.builder()
                .licenseNum(requestDto.getLicenseNum())
                .expiredDate(requestDto.getExpiredDate())
                .picture(requestDto.getLicensePic())
                .build();
        this.driverLicense = driverLicense;
        driverLicense.setGuiver(this);
    }
    public void setVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
    }

    public void updateInfo(GuiverUpdateRequestDto requestDto) {
        if (requestDto.getName().isValid())
            this.name = requestDto.getName();
        if (ObjectUtils.isNotEmpty(requestDto.getBirthDate()))
            this.birthDate = requestDto.getBirthDate();
        if (StringUtils.isNotEmpty(requestDto.getPhoneNumber()))
            this.phoneNumber.setPhoneNumber(requestDto.getPhoneNumber());
    }

    public void registerInfo(GuiverPersonalInfoDto requestDto){
        this.status = GuiverStatus.STANDBY;

        if(requestDto.getProfile().isValid())
            this.profile = requestDto.getProfile();
        if(requestDto.getAddress().isValid())
            this.address = requestDto.getAddress();

        ProofOfResidency proofOfResidency = ProofOfResidency.builder()
                .picture(requestDto.getIdCard()).build();
        setProofOfResidency(proofOfResidency);

        CriminalReport criminalReport = CriminalReport.builder()
                .picture(requestDto.getPoliceClearance()).build();
        setCriminalReport(criminalReport);
    }

    public void approval(){
        if(this.status.equals(GuiverStatus.JOINED))
            throw new IllegalArgumentException("Guiver can not be allowed before registration");

        this.status = GuiverStatus.COMPLETED;
    }

    public void updatePassword(String password) {
        if (StringUtils.isNotEmpty(password))
            this.password = password;
    }


}
