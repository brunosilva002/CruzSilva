package br.cruzsilva.CruzSilva.service;

import br.cruzsilva.CruzSilva.dto.RopingTypeDTO;
import br.cruzsilva.CruzSilva.dto.ResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Map;

import java.util.List;

@Component
public interface RopingTypeService {
    ResponseDTO<RopingTypeDTO> save(RopingTypeDTO ropingtypeDTO);

    ResponseDTO<RopingTypeDTO> obtain(Long cdnRopingType);

    ResponseDTO<Page<RopingTypeDTO>> pagination(Integer page, Integer pageSize, String sortBy, String direction, Long filter);

    ResponseDTO<List<RopingTypeDTO>> listAll();

    ResponseDTO<List<RopingTypeDTO>> listExample(RopingTypeDTO ropingtypeDTO);

    ResponseDTO delete(Long cdnRopingType);

    ResponseDTO<Page<RopingTypeDTO>> paginationFull(Integer page, Integer pageSize, String sortBy, String direction, Map<String, Object> filterMap);
}
