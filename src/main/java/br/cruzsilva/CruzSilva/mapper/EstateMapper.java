package br.cruzsilva.CruzSilva.mapper;

import br.cruzsilva.CruzSilva.dto.EstateDTO;
import br.cruzsilva.CruzSilva.model.masterDataBase.Estate;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface EstateMapper  extends EntityMapper<EstateDTO, Estate>{
}
