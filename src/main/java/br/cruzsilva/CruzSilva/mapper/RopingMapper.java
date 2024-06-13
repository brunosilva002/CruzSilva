package br.cruzsilva.CruzSilva.mapper;

import br.cruzsilva.CruzSilva.dto.RopingDTO;
import br.cruzsilva.CruzSilva.model.masterDataBase.Roping;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface RopingMapper  extends EntityMapper<RopingDTO, Roping>{
}
