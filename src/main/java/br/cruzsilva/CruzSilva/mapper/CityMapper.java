package br.cruzsilva.CruzSilva.mapper;

import br.cruzsilva.CruzSilva.dto.CityDTO;
import br.cruzsilva.CruzSilva.model.masterDataBase.City;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface CityMapper  extends EntityMapper<CityDTO, City>{
}
