package br.cruzsilva.CruzSilva.model.masterDataBase;


import br.cruzsilva.CruzSilva.enums.GenderAnimals;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "animals")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Animals implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cdn_animals")
    private Long cdnAnimals;

    @Column(name = "name")
    private String name;

    @Column(name = "register")
    private String register;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "gender")
    private GenderAnimals gender;

    @Column(name = "animal_breed")
    private String animalBreed;

    @Column(name = "owner")
    private String owner;

    @Column(name = "owner_cpf")
    private String ownerCpf;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "cdn_address", referencedColumnName = "cdn_address")
    @Fetch(FetchMode.SELECT)
    private Address address;

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

    public Animals(Long cdnAnimals) {
        this.cdnAnimals = cdnAnimals;
    }
}