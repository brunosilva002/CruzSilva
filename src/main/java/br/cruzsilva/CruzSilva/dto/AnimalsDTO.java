package br.cruzsilva.CruzSilva.dto;

import br.cruzsilva.CruzSilva.enums.GenderAnimals;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AnimalsDTO implements Serializable {
    private Long cdnAnimals;
    private String name;
    private String register;
    private LocalDate birthday;
    private GenderAnimals gender;
    private String animalBreed;
    private String owner;
    private String ownerCpf;
    private AddressDTO address;
    private LocalDateTime creationDate;
    private String creationUser;
    private LocalDateTime updateDate;
    private String updateUser;
}
