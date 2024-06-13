package br.cruzsilva.CruzSilva.mapper;

import br.cruzsilva.CruzSilva.dto.CountryDTO;
import br.cruzsilva.CruzSilva.model.masterDataBase.Country;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface CountryMapper  extends EntityMapper<CountryDTO, Country>{
}
