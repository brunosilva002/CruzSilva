package br.cruzsilva.CruzSilva.mapper;

import br.cruzsilva.CruzSilva.dto.ChampionshipDTO;
import br.cruzsilva.CruzSilva.model.masterDataBase.Championship;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface ChampionshipMapper  extends EntityMapper<ChampionshipDTO, Championship>{
}
