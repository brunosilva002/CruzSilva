package br.cruzsilva.CruzSilva.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BarrelTypeEnum {
    NORMAL    (1L),
    RODEO  (2L)
    ;
    private Long cod;
}
