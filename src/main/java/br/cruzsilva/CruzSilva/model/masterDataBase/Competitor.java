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
@Table(name = "competitor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Competitor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cdn_competitor")
    private Long cdnCompetitor;

    @Column(name = "name")
    private String name;

    @Column(name = "nick_name")
    private String nickName;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "handcap_header")
    private String handcapHeader;

    @Column(name = "handcap_heeler")
    private String handcapHeeler;

    @Column(name = "email")
    private String email;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "cdn_address", referencedColumnName = "cdn_address")
    @Fetch(FetchMode.SELECT)
    private Address address;

    @ManyToOne
    @JoinColumn(name = "cdn_gender", referencedColumnName = "cdn_gender")
    @Fetch(FetchMode.SELECT)
    private Gender gender;

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

    public Competitor(Long cdnCompetitor) {
        this.cdnCompetitor = cdnCompetitor;
    }
}