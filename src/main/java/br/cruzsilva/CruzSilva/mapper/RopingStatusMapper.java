package br.cruzsilva.CruzSilva.mapper;

import br.cruzsilva.CruzSilva.dto.RopingStatusDTO;
import br.cruzsilva.CruzSilva.model.masterDataBase.RopingStatus;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface RopingStatusMapper  extends EntityMapper<RopingStatusDTO, RopingStatus>{
}
