package br.cruzsilva.CruzSilva.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BarrelType {
    NORMAL    (1L),
    RODEO  (2L)
    ;
    private Long cod;
}
