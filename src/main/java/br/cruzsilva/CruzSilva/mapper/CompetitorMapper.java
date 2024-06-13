package br.cruzsilva.CruzSilva.mapper;

import br.cruzsilva.CruzSilva.dto.CompetitorDTO;
import br.cruzsilva.CruzSilva.model.masterDataBase.Competitor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface CompetitorMapper  extends EntityMapper<CompetitorDTO, Competitor>{
}
