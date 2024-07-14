package br.cruzsilva.CruzSilva.model.masterDataBase;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "roping_modality_type")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RopingModalityType implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cdn_roping_modality_type")
    private Long cdnRopingModalityType;

    @Column(name = "name")
    private String name;




    public RopingModalityType(Long cdnRopingModalityType) {
        this.cdnRopingModalityType = cdnRopingModalityType;
    }
}