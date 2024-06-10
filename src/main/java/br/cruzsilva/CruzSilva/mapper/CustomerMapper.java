package br.cruzsilva.CruzSilva.mapper;

import br.cruzsilva.CruzSilva.dto.CustomerDTO;
import br.cruzsilva.CruzSilva.model.masterDataBase.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface CustomerMapper  extends EntityMapper<CustomerDTO, Customer>{
}
