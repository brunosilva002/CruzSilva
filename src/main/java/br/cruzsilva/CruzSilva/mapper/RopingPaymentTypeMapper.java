package br.cruzsilva.CruzSilva.mapper;

import br.cruzsilva.CruzSilva.dto.RopingPaymentTypeDTO;
import br.cruzsilva.CruzSilva.model.masterDataBase.RopingPaymentType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface RopingPaymentTypeMapper  extends EntityMapper<RopingPaymentTypeDTO, RopingPaymentType>{
}
