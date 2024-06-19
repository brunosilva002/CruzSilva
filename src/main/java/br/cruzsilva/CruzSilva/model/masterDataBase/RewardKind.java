package br.cruzsilva.CruzSilva.model.masterDataBase;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "reward_kind")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RewardKind implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cdn_reward_kind")
    private Long cdnRewardKind;

    @Column(name = "name")
    private String name;


    public RewardKind(Long cdnRewardKind) {
        this.cdnRewardKind = cdnRewardKind;
    }
}