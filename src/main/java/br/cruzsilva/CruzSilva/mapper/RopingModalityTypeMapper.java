package br.cruzsilva.CruzSilva.mapper;

import br.cruzsilva.CruzSilva.dto.RopingModalityTypeDTO;
import br.cruzsilva.CruzSilva.model.masterDataBase.RopingModalityType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface RopingModalityTypeMapper  extends EntityMapper<RopingModalityTypeDTO, RopingModalityType>{
}
