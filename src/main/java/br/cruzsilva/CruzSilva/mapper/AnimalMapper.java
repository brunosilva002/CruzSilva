package br.cruzsilva.CruzSilva.mapper;

import br.cruzsilva.CruzSilva.dto.AnimalDTO;
import br.cruzsilva.CruzSilva.model.masterDataBase.Animal;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface AnimalMapper extends EntityMapper<AnimalDTO, Animal>{
}
