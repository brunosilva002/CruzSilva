package br.cruzsilva.CruzSilva.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
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
public class ChampionshipStageDTO implements Serializable {
    private Long cdnChampionshipStage;
    private String name;
    private Long numberStage;
    private LocalDate startDate;
    private LocalDate endDate;
    private ChampionshipDTO championship;
    private LocalDateTime creationDate;
    private String creationUser;
    private LocalDateTime updateDate;
    private String updateUser;
}
