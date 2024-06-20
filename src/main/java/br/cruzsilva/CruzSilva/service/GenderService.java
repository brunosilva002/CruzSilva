package br.cruzsilva.CruzSilva.service;

import br.cruzsilva.CruzSilva.dto.GenderDTO;
import br.cruzsilva.CruzSilva.dto.ResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Map;

import java.util.List;

@Component
public interface GenderService {
    ResponseDTO<GenderDTO> save(GenderDTO genderDTO);

    ResponseDTO<GenderDTO> obtain(Long cdnGender);

    ResponseDTO<Page<GenderDTO>> pagination(Integer page, Integer pageSize, String sortBy, String direction, Long filter);

    ResponseDTO<List<GenderDTO>> listAll();

    ResponseDTO<List<GenderDTO>> listExample(GenderDTO genderDTO);

    ResponseDTO delete(Long cdnGender);

    ResponseDTO<Page<GenderDTO>> paginationFull(Integer page, Integer pageSize, String sortBy, String direction, Map<String, Object> filterMap);
}
