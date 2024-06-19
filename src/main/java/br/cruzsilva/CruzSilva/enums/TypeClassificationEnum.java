package br.cruzsilva.CruzSilva.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TypeClassificationEnum {
    CLASSIFICATION1     (1L),
    CLASSIFICATION2     (2L),
    CLASSIFICATION3     (3L),
    CLASSIFICATION4     (4L),
    SEMIFINAL           (5L),
    FINAL               (6L),
    ;
    private Long cod;
}
