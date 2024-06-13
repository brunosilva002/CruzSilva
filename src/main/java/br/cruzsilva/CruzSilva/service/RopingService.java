package br.cruzsilva.CruzSilva.service;

import br.cruzsilva.CruzSilva.dto.RopingDTO;
import br.cruzsilva.CruzSilva.dto.ResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Map;

import java.util.List;

@Component
public interface RopingService {
    ResponseDTO<RopingDTO> save(RopingDTO ropingDTO);

    ResponseDTO<RopingDTO> obtain(Long cdnRoping);

    ResponseDTO<Page<RopingDTO>> pagination(Integer page, Integer pageSize, String sortBy, String direction, Long filter);

    ResponseDTO<List<RopingDTO>> listAll();

    ResponseDTO<List<RopingDTO>> listExample(RopingDTO ropingDTO);

    ResponseDTO delete(Long cdnRoping);

    ResponseDTO<Page<RopingDTO>> paginationFull(Integer page, Integer pageSize, String sortBy, String direction, Map<String, Object> filterMap);
}
