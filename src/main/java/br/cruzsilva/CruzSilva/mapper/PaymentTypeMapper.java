package br.cruzsilva.CruzSilva.mapper;

import br.cruzsilva.CruzSilva.dto.PaymentTypeDTO;
import br.cruzsilva.CruzSilva.model.masterDataBase.PaymentType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface PaymentTypeMapper  extends EntityMapper<PaymentTypeDTO, PaymentType>{
}
