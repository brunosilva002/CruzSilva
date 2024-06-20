package br.cruzsilva.CruzSilva.mapper;

import br.cruzsilva.CruzSilva.dto.DivisionDTO;
import br.cruzsilva.CruzSilva.model.masterDataBase.Division;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface DivisionMapper  extends EntityMapper<DivisionDTO, Division>{
}
