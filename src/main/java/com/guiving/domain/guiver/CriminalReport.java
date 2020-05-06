package com.guiving.domain.guiver;

import com.guiving.vo.Picture;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

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

    @Builder
    public CriminalReport(Long id, Guiver guiver, Picture picture) {
        this.id = id;
        this.guiver = guiver;
        this.picture = picture;
    }

    public void setGuiver(Guiver guiver){
        this.guiver = guiver;
    }
}
