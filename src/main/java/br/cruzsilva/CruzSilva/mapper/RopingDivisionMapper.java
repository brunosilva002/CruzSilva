package br.cruzsilva.CruzSilva.mapper;

import br.cruzsilva.CruzSilva.dto.RopingDivisionDTO;
import br.cruzsilva.CruzSilva.model.masterDataBase.RopingDivision;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface RopingDivisionMapper  extends EntityMapper<RopingDivisionDTO, RopingDivision>{
}
