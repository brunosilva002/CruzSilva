package br.cruzsilva.CruzSilva.model.masterDataBase;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "roping_status")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RopingStatus implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cdn_roping_status")
    private Long cdnRopingStatus;

    @Column(name = "name")
    private String name;


    public RopingStatus(Long cdnRopingStatus) {
        this.cdnRopingStatus = cdnRopingStatus;
    }
}