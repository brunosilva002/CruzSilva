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
@Table (name="estate")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Estate implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cdn_estate")
    private Long cdnEstate;

    @Column(name = "code")
    private String code;

    @Column (name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "cdn_country", referencedColumnName = "cdn_country")
    @Fetch(FetchMode.SELECT)
    private Country country;

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


    public Estate(Long cdnEstate) {
        this.cdnEstate = cdnEstate;
    }
}
