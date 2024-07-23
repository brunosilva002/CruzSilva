package br.cruzsilva.CruzSilva.mapper;

import br.cruzsilva.CruzSilva.dto.EventDTO;
import br.cruzsilva.CruzSilva.model.masterDataBase.Event;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface EventMapper  extends EntityMapper<EventDTO, Event>{
}
