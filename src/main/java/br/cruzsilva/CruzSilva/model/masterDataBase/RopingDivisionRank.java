package br.cruzsilva.CruzSilva.model.masterDataBase;


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

@Entity
@Table(name = "roping_division_rank")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RopingDivisionRank implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cdn_roping_division_rank")
    private Long cdnRopingDivisionRank;

    @Column(name = "rank_number")
    private Long rankNumber;

    @Column(name = "name")
    private String name;

    @Column(name = "value_rate_price")
    private BigDecimal valueRatePrice;

    @Column(name = "value_reward_price")
    private BigDecimal valueRewardPrice;

    @Column(name = "point")
    private Long point;

    @ManyToOne
    @JoinColumn(name = "cdn_roping_division", referencedColumnName = "cdn_roping_division")
    @Fetch(FetchMode.SELECT)
    private RopingDivision ropingDivision;

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

    public RopingDivisionRank(Long cdnRopingDivisionRank) {
        this.cdnRopingDivisionRank = cdnRopingDivisionRank;
    }
}