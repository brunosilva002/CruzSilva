package br.cruzsilva.CruzSilva.service;

import br.cruzsilva.CruzSilva.dto.DivisionDTO;
import br.cruzsilva.CruzSilva.dto.ResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Map;

import java.util.List;

@Component
public interface DivisionService {
    ResponseDTO<DivisionDTO> save(DivisionDTO divisionDTO);

    ResponseDTO<DivisionDTO> obtain(Long cdnDivision);

    ResponseDTO<Page<DivisionDTO>> pagination(Integer page, Integer pageSize, String sortBy, String direction, Long filter);

    ResponseDTO<List<DivisionDTO>> listAll();

    ResponseDTO<List<DivisionDTO>> listExample(DivisionDTO divisionDTO);

    ResponseDTO delete(Long cdnDivision);

    ResponseDTO<Page<DivisionDTO>> paginationFull(Integer page, Integer pageSize, String sortBy, String direction, Map<String, Object> filterMap);

    ResponseDTO<List<DivisionDTO>> saveList(List<DivisionDTO> divisionDTO);
}
