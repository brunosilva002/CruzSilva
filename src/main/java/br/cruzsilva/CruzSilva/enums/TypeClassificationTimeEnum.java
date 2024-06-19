package br.cruzsilva.CruzSilva.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TypeClassificationTimeEnum {
    BEST_TIME           (1L),
    AVARANGE_TIME       (2L),
    SUM_OF_TIME         (3L)
    ;
    private Long cod;
}
