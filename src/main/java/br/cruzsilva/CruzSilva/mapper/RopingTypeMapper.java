package br.cruzsilva.CruzSilva.mapper;

import br.cruzsilva.CruzSilva.dto.RopingTypeDTO;
import br.cruzsilva.CruzSilva.model.masterDataBase.RopingType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface RopingTypeMapper  extends EntityMapper<RopingTypeDTO, RopingType>{
}
