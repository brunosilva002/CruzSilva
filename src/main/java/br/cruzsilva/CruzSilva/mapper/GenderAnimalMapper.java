package br.cruzsilva.CruzSilva.mapper;

import br.cruzsilva.CruzSilva.dto.GenderAnimalDTO;
import br.cruzsilva.CruzSilva.model.masterDataBase.GenderAnimal;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface GenderAnimalMapper  extends EntityMapper<GenderAnimalDTO, GenderAnimal>{
}
