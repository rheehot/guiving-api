package com.guiving.domain.guiver;

import com.guiving.domain.vo.Picture;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@ToString(exclude = "guiver")
@NoArgsConstructor
@Getter
@Entity
@Table(name="TB_CRIMINAL_REPORT_FILE")
public class CriminalReport implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="crf_idx")
    private Long id;

    @OneToOne
    @JoinColumn(name = "crf_guiver_idx")
    private Guiver guiver;

    @Embedded
    @AttributeOverride(name = "url",column = @Column(name = "img_file_url"))
    private Picture picture;

    public void setGuiver(Guiver guiver){
        this.guiver = guiver;
    }
}
