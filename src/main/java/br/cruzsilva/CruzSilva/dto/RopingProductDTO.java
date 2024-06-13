package br.cruzsilva.CruzSilva.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class RopingProductDTO implements Serializable {
    private Long cdnRopingDivisionProduct;
    private String name;
    private BigDecimal stockQty;
    private BigDecimal stockQtyAvailable;
    private BigDecimal stockCost;
    private LocalDateTime salesReleasedUntil;
    private RopingDTO roping;
    private LocalDateTime creationDate;
    private String creationUser;
    private LocalDateTime updateDate;
    private String updateUser;

}
