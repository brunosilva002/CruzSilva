package br.cruzsilva.CruzSilva.mapper;

import br.cruzsilva.CruzSilva.dto.EventTestDTO;
import br.cruzsilva.CruzSilva.model.masterDataBase.EventTest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface EventTestMapper  extends EntityMapper<EventTestDTO, EventTest>{
}
