package br.cruzsilva.CruzSilva.mapper;

import br.cruzsilva.CruzSilva.dto.GenderDTO;
import br.cruzsilva.CruzSilva.model.masterDataBase.Gender;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface GenderMapper  extends EntityMapper<GenderDTO, Gender>{
}
