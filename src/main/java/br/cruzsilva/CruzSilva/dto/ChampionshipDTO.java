package br.cruzsilva.CruzSilva.dto;

import br.cruzsilva.CruzSilva.model.masterDataBase.ChampionshipStage;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChampionshipDTO implements Serializable {
    private Long cdnChampionship;
    private String name;
    private List<ChampionshipStageDTO> championshipStages = new ArrayList<>();
}
