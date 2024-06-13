package br.cruzsilva.CruzSilva.service;

import br.cruzsilva.CruzSilva.dto.RopingDivisionDTO;
import br.cruzsilva.CruzSilva.dto.ResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Map;

import java.util.List;

@Component
public interface RopingDivisionService {
    ResponseDTO<RopingDivisionDTO> save(RopingDivisionDTO ropingdivisionDTO);

    ResponseDTO<RopingDivisionDTO> obtain(Long cdnRopingDivision);

    ResponseDTO<Page<RopingDivisionDTO>> pagination(Integer page, Integer pageSize, String sortBy, String direction, Long filter);

    ResponseDTO<List<RopingDivisionDTO>> listAll();

    ResponseDTO<List<RopingDivisionDTO>> listExample(RopingDivisionDTO ropingdivisionDTO);

    ResponseDTO delete(Long cdnRopingDivision);

    ResponseDTO<Page<RopingDivisionDTO>> paginationFull(Integer page, Integer pageSize, String sortBy, String direction, Map<String, Object> filterMap);
}
