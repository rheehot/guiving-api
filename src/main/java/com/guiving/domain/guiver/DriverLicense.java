package com.guiving.domain.guiver;

import com.guiving.domain.vo.Picture;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@ToString(exclude = "guiver")
@NoArgsConstructor
@Getter
@Entity
@Table(name="TB_DRIVER_LICENSE")
public class DriverLicense implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="dl_idx")
    private Long id;

    @OneToOne
    @JoinColumn(name = "dl_guiver_idx")
    private Guiver guiver;

    @Column(name = "dl_num")
    private String licenseNum;

    @Column(name = "dl_expire_date")
    private LocalDate expiredDate;

    @Embedded
    @AttributeOverride(name = "url",column = @Column(name = "dl_img_url"))
    Picture picture;

    public void setGuiver(Guiver guiver){
        this.guiver = guiver;
    }
}
