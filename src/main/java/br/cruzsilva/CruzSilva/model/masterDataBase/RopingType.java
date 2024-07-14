package br.cruzsilva.CruzSilva.model.masterDataBase;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "roping_type")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RopingType implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cdn_roping_type")
    private Long cdnRopingType;

    @Column(name = "name")
    private String name;


    public RopingType(Long cdnRopingType) {
        this.cdnRopingType = cdnRopingType;
    }
}