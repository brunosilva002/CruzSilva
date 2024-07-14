package br.cruzsilva.CruzSilva.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TrackStatusEnum {
    RELEASED        (1L),
    LOCKED          (2L)
    ;
    private Long cod;
}
