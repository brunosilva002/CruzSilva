package br.cruzsilva.CruzSilva.mapper;

import br.cruzsilva.CruzSilva.dto.TypeClassificationDTO;
import br.cruzsilva.CruzSilva.model.masterDataBase.TypeClassification;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface TypeClassificationMapper  extends EntityMapper<TypeClassificationDTO, TypeClassification>{
}
