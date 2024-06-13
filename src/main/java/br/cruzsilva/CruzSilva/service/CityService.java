package br.cruzsilva.CruzSilva.service;

import br.cruzsilva.CruzSilva.dto.CityDTO;
import br.cruzsilva.CruzSilva.dto.ResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Map;

import java.util.List;

@Component
public interface CityService {
    ResponseDTO<CityDTO> save(CityDTO cityDTO);

    ResponseDTO<CityDTO> obtain(Long cdnCity);

    ResponseDTO<Page<CityDTO>> pagination(Integer page, Integer pageSize, String sortBy, String direction, Long filter);

    ResponseDTO<List<CityDTO>> listAll();

    ResponseDTO<List<CityDTO>> listExample(CityDTO cityDTO);

    ResponseDTO delete(Long cdnCity);

    ResponseDTO<Page<CityDTO>> paginationFull(Integer page, Integer pageSize, String sortBy, String direction, Map<String, Object> filterMap);
}
