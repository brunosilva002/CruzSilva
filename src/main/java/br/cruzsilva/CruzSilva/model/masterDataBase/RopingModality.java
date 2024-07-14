package br.cruzsilva.CruzSilva.model.masterDataBase;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.io.Serializable;

@Entity
@Table(name = "roping_modality")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RopingModality implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cdn_roping_modality")
    private Long cdnRopingModality;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "cdn_roping_modality_type", referencedColumnName = "cdn_roping_modality_type")
    @Fetch(FetchMode.SELECT)
    private RopingModalityType ropingModalityType;


    public RopingModality(Long cdnRopingModality) {
        this.cdnRopingModality = cdnRopingModality;
    }
}