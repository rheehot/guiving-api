package com.guiving.domain.guiver;

import com.guiving.domain.vo.Picture;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@ToString(exclude = "guiver")
@NoArgsConstructor
@Getter
@Entity
@Table(name="TB_RESIDENCY_PROOF_FILE")
public class ProofOfResidency implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="rpf_idx")
    private Long id;

    @OneToOne
    @JoinColumn(name = "rpf_guiver_idx")
    private Guiver guiver;

    @Embedded
    @AttributeOverride(name = "url",column = @Column(name = "img_file_url"))
    private Picture picture;

    public void setGuiver(Guiver guiver){
        this.guiver = guiver;
    }
}
