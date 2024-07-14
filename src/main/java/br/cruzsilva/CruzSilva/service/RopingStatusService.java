package br.cruzsilva.CruzSilva.service;

import br.cruzsilva.CruzSilva.dto.RopingStatusDTO;
import br.cruzsilva.CruzSilva.dto.ResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Map;

import java.util.List;

@Component
public interface RopingStatusService {
    ResponseDTO<RopingStatusDTO> save(RopingStatusDTO ropingstatusDTO);

    ResponseDTO<RopingStatusDTO> obtain(Long cdnRopingStatus);

    ResponseDTO<Page<RopingStatusDTO>> pagination(Integer page, Integer pageSize, String sortBy, String direction, Long filter);

    ResponseDTO<List<RopingStatusDTO>> listAll();

    ResponseDTO<List<RopingStatusDTO>> listExample(RopingStatusDTO ropingstatusDTO);

    ResponseDTO delete(Long cdnRopingStatus);

    ResponseDTO<Page<RopingStatusDTO>> paginationFull(Integer page, Integer pageSize, String sortBy, String direction, Map<String, Object> filterMap);
}
