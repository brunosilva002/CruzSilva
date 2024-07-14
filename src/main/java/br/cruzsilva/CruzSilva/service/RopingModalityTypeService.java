package br.cruzsilva.CruzSilva.service;

import br.cruzsilva.CruzSilva.dto.RopingModalityTypeDTO;
import br.cruzsilva.CruzSilva.dto.ResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Map;

import java.util.List;

@Component
public interface RopingModalityTypeService {
    ResponseDTO<RopingModalityTypeDTO> save(RopingModalityTypeDTO ropingmodalitytypeDTO);

    ResponseDTO<RopingModalityTypeDTO> obtain(Long cdnRopingModalityType);

    ResponseDTO<Page<RopingModalityTypeDTO>> pagination(Integer page, Integer pageSize, String sortBy, String direction, Long filter);

    ResponseDTO<List<RopingModalityTypeDTO>> listAll();

    ResponseDTO<List<RopingModalityTypeDTO>> listExample(RopingModalityTypeDTO ropingmodalitytypeDTO);

    ResponseDTO delete(Long cdnRopingModalityType);

    ResponseDTO<Page<RopingModalityTypeDTO>> paginationFull(Integer page, Integer pageSize, String sortBy, String direction, Map<String, Object> filterMap);
}
