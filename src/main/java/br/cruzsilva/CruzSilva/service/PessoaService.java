package br.cruzsilva.CruzSilva.service;

import br.cruzsilva.CruzSilva.dto.PessoaDTO;
import br.cruzsilva.CruzSilva.dto.ResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Map;

import java.util.List;

@Component
public interface PessoaService {
    ResponseDTO<PessoaDTO> save(PessoaDTO pessoaDTO);

    ResponseDTO<PessoaDTO> obtain(Long cdnPessoa);

    ResponseDTO<Page<PessoaDTO>> pagination(Integer page, Integer pageSize, String sortBy, String direction, Long filter);

    ResponseDTO<List<PessoaDTO>> listAll();

    ResponseDTO<List<PessoaDTO>> listExample(PessoaDTO pessoaDTO);

    ResponseDTO delete(Long cdnPessoa);

    ResponseDTO<Page<PessoaDTO>> paginationFull(Integer page, Integer pageSize, String sortBy, String direction, Map<String, Object> filterMap);
}
