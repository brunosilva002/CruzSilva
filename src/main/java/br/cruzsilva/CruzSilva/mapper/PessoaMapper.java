package br.cruzsilva.CruzSilva.mapper;

import br.cruzsilva.CruzSilva.dto.PessoaDTO;
import br.cruzsilva.CruzSilva.model.masterDataBase.Pessoa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface PessoaMapper  extends EntityMapper<PessoaDTO, Pessoa>{
}
