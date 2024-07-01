package br.cruzsilva.CruzSilva.dto;

import br.cruzsilva.CruzSilva.enums.*;
import br.cruzsilva.CruzSilva.model.masterDataBase.Roping;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class RopingDivisionDTO implements Serializable {
    private Long cdnRopingDivision;
    private DivisionDTO division;
    private RewardKindDTO rewardKind;
    private BigDecimal valueRate;
    private BigDecimal valuePrice;
    private Long displayOrder;
    private Boolean isOfficialDivision;
    private Boolean isForUnion;
    private Boolean isShowEntries;
    private Boolean isSendNotification;
    private LocalDateTime maxDateWeb;
    private LocalDateTime maxDateApp;
    private BigDecimal paceValue1;
    private BigDecimal paceValue2;
    private BigDecimal paceValue3;
    private BigDecimal paceValue4;
    private BarrelTypeDTO barrelType;
    private TypeClassificationDTO typeClassification;
    private TypeClassificationTimeDTO typeClassificationTime;
    private Long minAge;
    private Long maxAge;
    private Boolean isGeneratePaceNextClassification;
    private Boolean isRodeo;
    private Boolean isAllowChangeAnimalFinal;
    private Boolean isFinalRodeoDraw;
    private RopingDTO roping;
    private List<RopingDivisionRankDTO> ropingDivisionRanks = new ArrayList<>();
    private LocalDateTime creationDate;
    private String creationUser;
    private LocalDateTime updateDate;
    private String updateUser;
}
