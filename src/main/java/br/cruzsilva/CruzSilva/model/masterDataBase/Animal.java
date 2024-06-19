package br.cruzsilva.CruzSilva.model.masterDataBase;

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
@Table(name = "animal")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Animal implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cdn_animal")
    private Long cdnAnimal;

    @Column(name = "name")
    private String name;

    @Column(name = "register")
    private String register;

    @Column(name = "birthday")
    private LocalDate birthday;

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

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "cdn_gender_animal", referencedColumnName = "cdn_gender_animal")
    @Fetch(FetchMode.SELECT)
    private GenderAnimal genderAnimal;

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

    public Animal(Long cdnAnimal) {
        this.cdnAnimal = cdnAnimal;
    }
}