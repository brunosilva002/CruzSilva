package br.cruzsilva.CruzSilva.mapper;

import br.cruzsilva.CruzSilva.dto.RopingProductDTO;
import br.cruzsilva.CruzSilva.model.masterDataBase.RopingProduct;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface RopingProductMapper  extends EntityMapper<RopingProductDTO, RopingProduct>{
}
