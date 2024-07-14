package br.cruzsilva.CruzSilva.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RopingStatusEnum {
    CLOSED      (1L),
    OPEN        (2L),
    RUNNING     (3L),
    ;
    private Long cod;
}
