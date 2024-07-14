package br.cruzsilva.CruzSilva.mapper;

import br.cruzsilva.CruzSilva.dto.PaymentDTO;
import br.cruzsilva.CruzSilva.model.masterDataBase.Payment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface PaymentMapper  extends EntityMapper<PaymentDTO, Payment>{
}
