package br.cruzsilva.CruzSilva.mapper;

import br.cruzsilva.CruzSilva.dto.RopingDivisionRankDTO;
import br.cruzsilva.CruzSilva.model.masterDataBase.RopingDivisionRank;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface RopingDivisionRankMapper  extends EntityMapper<RopingDivisionRankDTO, RopingDivisionRank>{
}
