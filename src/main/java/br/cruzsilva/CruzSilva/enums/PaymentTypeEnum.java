package br.cruzsilva.CruzSilva.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaymentTypeEnum {
    MONEY        (1L),
    PIX          (2L),
    DEBIT_CARD   (3L),
    CREDIT_CARD  (4L),
    CHECK        (5L),
    TRANSFER     (6L),
    COURTESY     (7L),
    EXCHANGE     (8L),
    ;
    private Long cod;
}
