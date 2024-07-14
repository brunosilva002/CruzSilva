package br.cruzsilva.CruzSilva.model.masterDataBase;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "division")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Division implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cdn_division")
    private Long cdnDivision;

    @Column(name = "name")
    private String name;

    @Column(name = "gender")
    private String gender;

    @Column(name = "pro_am_cabeca")
    private Boolean proAmCabeca;

    @Column(name = "pro_am_pe")
    private Boolean proAmPe;

    @Column(name = "incentive")
    private Boolean incentive;

    @Column(name = "test_horse")
    private Boolean testHorse;

    @Column(name = "consider_ranking")
    private Boolean considerRanking;

    public Division(Long cdnDivision) {
        this.cdnDivision = cdnDivision;
    }
}