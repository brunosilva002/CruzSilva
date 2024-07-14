package br.cruzsilva.CruzSilva.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RopingModalityEnum {
    BARREL_RACING       (1L),
    ROPING              (2L),
    ROPING_TEAM         (3L),
    ;
    private Long cod;
}
