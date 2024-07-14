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
@Table(name = "entry_form")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EntryForm implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cdn_entry_form")
    private Long cdnEntryForm;

    @Column(name = "note")
    private String note;

    @ManyToOne
    @JoinColumn(name = "cdn_roping", referencedColumnName = "cdn_roping")
    @Fetch(FetchMode.SELECT)
    private Roping roping;

    @ManyToOne
    @JoinColumn(name = "cdn_roping_division", referencedColumnName = "cdn_roping_division")
    @Fetch(FetchMode.SELECT)
    private RopingDivision ropingDivision;

    @ManyToOne
    @JoinColumn(name = "cdn_roping_type", referencedColumnName = "cdn_roping_type")
    @Fetch(FetchMode.SELECT)
    private RopingType cdnRopingType;

    @ManyToOne
    @JoinColumn(name = "cdn_competitor", referencedColumnName = "cdn_competitor")
    @Fetch(FetchMode.SELECT)
    private Competitor competitor;

    @ManyToOne
    @JoinColumn(name = "cdn_animal", referencedColumnName = "cdn_animal")
    @Fetch(FetchMode.SELECT)
    private Animal animal;


    @OneToMany(cascade = {CascadeType.ALL}, orphanRemoval = true)
    @JoinColumn(name = "cdn_entry_form", referencedColumnName = "cdn_entry_form")
    @OrderBy("payment_date")
    private List<Payment> payments = new ArrayList<>();



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

    public EntryForm(Long cdnEntryForm) {
        this.cdnEntryForm = cdnEntryForm;
    }
}