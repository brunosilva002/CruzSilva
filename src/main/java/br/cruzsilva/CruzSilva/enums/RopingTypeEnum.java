package br.cruzsilva.CruzSilva.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RopingTypeEnum {
    HEADER      (1L),
    HEELER      (2L)
    ;
    private Long cod;
}
