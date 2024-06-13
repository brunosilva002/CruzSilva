package br.cruzsilva.CruzSilva.model.masterDataBase;


import br.cruzsilva.CruzSilva.enums.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "roping_division")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RopingDivision implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cdn_roping_division")
    private Long cdnRopingDivision;

    @Column(name = "division")
    private Divison divison;

    @Column(name = "reward_kind")
    private RewardKind rewardKind;

    @Column(name = "value_rate")
    private BigDecimal valueRate;

    @Column(name = "value_price")
    private BigDecimal valuePrice;

    @Column(name = "display_order")
    private Long displayOrder;

    @Column(name = "is_official_division")
    private Boolean isOfficialDivision;

    @Column(name = "is_for_union")
    private Boolean isForUnion;

    @Column(name = "is_show_entries")
    private Boolean isShowEntries;

    @Column(name = "is_send_notification")
    private Boolean isSendNotification;

    @Column(name = "max_date_web")
    private LocalDateTime maxDateWeb;

    @Column(name = "max_date_app")
    private LocalDateTime maxDateApp;

    @Column(name = "pace_value_1")
    private BigDecimal paceValue1;

    @Column(name = "pace_value_2")
    private BigDecimal paceValue2;

    @Column(name = "pace_value_3")
    private BigDecimal paceValue3;

    @Column(name = "pace_value_4")
    private BigDecimal paceValue4;

    @Column(name = "barrel_type")
    private BarrelType barrelType;

    @Column(name = "type_classification")
    private TypeClassification typeClassification;

    @Column(name = "type_classification_time")
    private TypeClassificationTime typeClassificationTime;

    @Column(name = "min_age")
    private Long minAge;

    @Column(name = "max_age")
    private Long maxAge;

    @Column(name = "is_generate_pace_next_classification")
    private Boolean isGeneratePaceNextClassification;

    @Column(name = "is_rodeo")
    private Boolean isRodeo;

    @Column(name = "is_allow_change_animal_final")
    private Boolean isAllowChangeAnimalFinal;

    @Column(name = "is_final_rodeo_draw")
    private Boolean isFinalRodeoDraw;

    @ManyToOne
    @JoinColumn(name = "cdn_roping", referencedColumnName = "cdn_roping")
    @Fetch(FetchMode.SELECT)
    private Roping roping;

    @OneToMany(cascade = {CascadeType.ALL}, orphanRemoval = true)
    @JoinColumn(name = "cdn_roping_division", referencedColumnName = "cdn_roping_division")
    @OrderBy("rank_number")
    private List<RopingDivisionRank> ropingDivisionRanks = new ArrayList<>();

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @Column(name = "creation_user")
    private String creationUser;

    @Column(name = "update_date")
    private LocalDateTime updateDate;

    @Column(name = "update_user")
    private String updateUser;

    @PrePersist
    protected void onCreate() {
        this.creationDate = LocalDateTime.now();
        this.updateDate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updateDate = LocalDateTime.now();
    }

    public RopingDivision(Long cdnRopingDivision) {
        this.cdnRopingDivision = cdnRopingDivision;
    }
}