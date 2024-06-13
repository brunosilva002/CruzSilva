package br.cruzsilva.CruzSilva.mapper;

import br.cruzsilva.CruzSilva.dto.JudgeDTO;
import br.cruzsilva.CruzSilva.model.masterDataBase.Judge;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface JudgeMapper  extends EntityMapper<JudgeDTO, Judge>{
}
