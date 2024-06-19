package br.cruzsilva.CruzSilva.model.masterDataBase;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "gender_animal")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GenderAnimal implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cdn_gender_animal")
    private Long cdnGenderAnimal;

    @Column(name = "name")
    private String name;


    public GenderAnimal(Long cdnGenderAnimal) {
        this.cdnGenderAnimal = cdnGenderAnimal;
    }
}