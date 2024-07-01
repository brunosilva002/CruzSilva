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


@Entity
@Table (name="pessoa")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cdn_pessoa")
    private Long cdnCity;

    @Column (name = "name")
    private String name;

    @Column (name = "code")
    private String code;

    @ManyToOne
    @JoinColumn(name = "cdn_estate", referencedColumnName = "cdn_estate")
    @Fetch(FetchMode.SELECT)
    private Estate estate;

    @Column (name = "date_created")
    private LocalDateTime dateCreated;

    @Column (name = "date_updated")
    private LocalDateTime dateUpdated;

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

    public Pessoa(Long cdnCity) {
        this.cdnCity = cdnCity;
    }


}
