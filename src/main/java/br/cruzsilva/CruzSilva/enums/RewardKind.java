package br.cruzsilva.CruzSilva.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RewardKind {
    FIXED_VALUE     (1L),
    SUBSCRIPTION    (2L)
    ;
    private Long cod;
}
