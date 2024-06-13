package br.cruzsilva.CruzSilva.mapper;

import br.cruzsilva.CruzSilva.dto.AnimalsDTO;
import br.cruzsilva.CruzSilva.model.masterDataBase.Animals;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface AnimalsMapper  extends EntityMapper<AnimalsDTO, Animals>{
}
