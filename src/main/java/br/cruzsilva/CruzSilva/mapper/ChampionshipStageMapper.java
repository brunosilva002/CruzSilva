package br.cruzsilva.CruzSilva.mapper;

import br.cruzsilva.CruzSilva.dto.ChampionshipStageDTO;
import br.cruzsilva.CruzSilva.model.masterDataBase.ChampionshipStage;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface ChampionshipStageMapper  extends EntityMapper<ChampionshipStageDTO, ChampionshipStage>{
}
