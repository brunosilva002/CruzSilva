package br.cruzsilva.CruzSilva.service;

import br.cruzsilva.CruzSilva.dto.CountryDTO;
import br.cruzsilva.CruzSilva.dto.ResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Map;

import java.util.List;

@Component
public interface CountryService {
    ResponseDTO<CountryDTO> save(CountryDTO countryDTO);

    ResponseDTO<CountryDTO> obtain(Long cdnCountry);

    ResponseDTO<Page<CountryDTO>> pagination(Integer page, Integer pageSize, String sortBy, String direction, Long filter);

    ResponseDTO<List<CountryDTO>> listAll();

    ResponseDTO<List<CountryDTO>> listExample(CountryDTO countryDTO);

    ResponseDTO delete(Long cdnCountry);

    ResponseDTO<Page<CountryDTO>> paginationFull(Integer page, Integer pageSize, String sortBy, String direction, Map<String, Object> filterMap);
}
