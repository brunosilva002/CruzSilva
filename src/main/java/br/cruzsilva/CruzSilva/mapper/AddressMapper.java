package br.cruzsilva.CruzSilva.mapper;

import br.cruzsilva.CruzSilva.dto.AddressDTO;
import br.cruzsilva.CruzSilva.model.masterDataBase.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface AddressMapper  extends EntityMapper<AddressDTO, Address>{
}
