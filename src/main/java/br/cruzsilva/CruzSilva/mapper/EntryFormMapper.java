package br.cruzsilva.CruzSilva.mapper;

import br.cruzsilva.CruzSilva.dto.EntryFormDTO;
import br.cruzsilva.CruzSilva.model.masterDataBase.EntryForm;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface EntryFormMapper  extends EntityMapper<EntryFormDTO, EntryForm>{
}
