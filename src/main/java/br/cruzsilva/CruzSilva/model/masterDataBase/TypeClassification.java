package br.cruzsilva.CruzSilva.model.masterDataBase;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "type_classification")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TypeClassification implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cdn_type_classification")
    private Long cdnTypeClassification;

    @Column(name = "name")
    private String name;


    public TypeClassification(Long cdnTypeClassification) {
        this.cdnTypeClassification = cdnTypeClassification;
    }
}