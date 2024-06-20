package br.cruzsilva.CruzSilva.mapper;

import br.cruzsilva.CruzSilva.dto.BarrelTypeDTO;
import br.cruzsilva.CruzSilva.model.masterDataBase.BarrelType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface BarrelTypeMapper  extends EntityMapper<BarrelTypeDTO, BarrelType>{
}
