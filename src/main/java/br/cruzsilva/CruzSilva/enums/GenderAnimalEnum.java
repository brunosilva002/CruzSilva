package br.cruzsilva.CruzSilva.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GenderAnimalEnum {
    MALE    (1L),
    FEMALE  (2L)
    ;
    private Long cod;
}
