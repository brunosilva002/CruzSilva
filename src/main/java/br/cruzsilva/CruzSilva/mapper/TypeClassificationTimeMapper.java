package br.cruzsilva.CruzSilva.mapper;

import br.cruzsilva.CruzSilva.dto.TypeClassificationTimeDTO;
import br.cruzsilva.CruzSilva.model.masterDataBase.TypeClassificationTime;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface TypeClassificationTimeMapper  extends EntityMapper<TypeClassificationTimeDTO, TypeClassificationTime>{
}
