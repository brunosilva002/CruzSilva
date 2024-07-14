package br.cruzsilva.CruzSilva.service;

import br.cruzsilva.CruzSilva.dto.RopingModalityDTO;
import br.cruzsilva.CruzSilva.dto.ResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Map;

import java.util.List;

@Component
public interface RopingModalityService {
    ResponseDTO<RopingModalityDTO> save(RopingModalityDTO ropingmodalityDTO);

    ResponseDTO<RopingModalityDTO> obtain(Long cdnRopingModality);

    ResponseDTO<Page<RopingModalityDTO>> pagination(Integer page, Integer pageSize, String sortBy, String direction, Long filter);

    ResponseDTO<List<RopingModalityDTO>> listAll();

    ResponseDTO<List<RopingModalityDTO>> listExample(RopingModalityDTO ropingmodalityDTO);

    ResponseDTO delete(Long cdnRopingModality);

    ResponseDTO<Page<RopingModalityDTO>> paginationFull(Integer page, Integer pageSize, String sortBy, String direction, Map<String, Object> filterMap);
}
