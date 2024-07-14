package br.cruzsilva.CruzSilva.mapper;

import br.cruzsilva.CruzSilva.dto.RopingModalityDTO;
import br.cruzsilva.CruzSilva.model.masterDataBase.RopingModality;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface RopingModalityMapper  extends EntityMapper<RopingModalityDTO, RopingModality>{
}
