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
public class RopingDivisionRankDTO implements Serializable {
    private Long cdnRopingDivisionRank;
    private Long rankNumber;
    private BigDecimal valueRatePrice;
    private BigDecimal valueRewardPrice;
    private Long point;
    private String name;
    private RopingDivisionDTO ropingDivision;
    private LocalDateTime creationDate;
    private String creationUser;
    private LocalDateTime updateDate;
    private String updateUser;
}
