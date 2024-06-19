package br.cruzsilva.CruzSilva.model.masterDataBase;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "barrel_type")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BarrelType implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cdn_barrel_type")
    private Long cdnBarrelType;

    @Column(name = "name")
    private String name;


    public BarrelType(Long cdnBarrelType) {
        this.cdnBarrelType = cdnBarrelType;
    }
}