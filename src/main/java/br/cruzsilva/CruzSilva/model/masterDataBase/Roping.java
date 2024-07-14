package br.cruzsilva.CruzSilva.model.masterDataBase;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "roping")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Roping implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cdn_roping")
    private Long cdnRoping;

    @Column(name = "name")
    private String name;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "show_inscription")
    private Boolean showInscription;

    @Column(name = "url")
    private String url;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "cdn_address", referencedColumnName = "cdn_address")
    @Fetch(FetchMode.SELECT)
    private Address address;

    @ManyToOne
    @JoinColumn(name = "cdn_roping_status", referencedColumnName = "cdn_roping_status")
    @Fetch(FetchMode.SELECT)
    private RopingStatus ropingStatus;

    @ManyToOne
    @JoinColumn(name = "cdn_roping_modality", referencedColumnName = "cdn_roping_modality")
    @Fetch(FetchMode.SELECT)
    private RopingModality ropingModality;

    @ManyToOne
    @JoinColumn(name = "cdn_track", referencedColumnName = "cdn_track")
    @Fetch(FetchMode.SELECT)
    private Track track;

    @ManyToOne
    @JoinColumn(name = "cdn_championship_stage", referencedColumnName = "cdn_championship_stage")
    @Fetch(FetchMode.SELECT)
    private ChampionshipStage championshipStage;

    @OneToMany(cascade = {CascadeType.ALL}, orphanRemoval = true)
    @JoinColumn(name = "cdn_roping", referencedColumnName = "cdn_roping")
    private List<RopingPaymentType> ropingPaymentTypes = new ArrayList<>();


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

    public Roping(Long cdnRoping) {
        this.cdnRoping = cdnRoping;
    }
}