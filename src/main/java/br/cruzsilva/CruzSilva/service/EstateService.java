package br.cruzsilva.CruzSilva.service;

import br.cruzsilva.CruzSilva.dto.EstateDTO;
import br.cruzsilva.CruzSilva.dto.ResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Map;

import java.util.List;

@Component
public interface EstateService {
    ResponseDTO<EstateDTO> save(EstateDTO estateDTO);

    ResponseDTO<EstateDTO> obtain(Long cdnEstate);

    ResponseDTO<Page<EstateDTO>> pagination(Integer page, Integer pageSize, String sortBy, String direction, Long filter);

    ResponseDTO<List<EstateDTO>> listAll();

    ResponseDTO<List<EstateDTO>> listExample(EstateDTO estateDTO);

    ResponseDTO delete(Long cdnEstate);

    ResponseDTO<Page<EstateDTO>> paginationFull(Integer page, Integer pageSize, String sortBy, String direction, Map<String, Object> filterMap);
}
