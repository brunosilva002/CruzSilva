package br.cruzsilva.CruzSilva.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Gender {
    MALE        (1L),
    FEMALE      (2L),
    UNDEFINED   (3L),
    ;
    private Long cod;
}
