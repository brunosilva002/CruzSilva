package br.cruzsilva.CruzSilva.service;

import br.cruzsilva.CruzSilva.dto.RopingDivisionRankDTO;
import br.cruzsilva.CruzSilva.dto.ResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Map;

import java.util.List;

@Component
public interface RopingDivisionRankService {
    ResponseDTO<RopingDivisionRankDTO> save(RopingDivisionRankDTO ropingdivisionrankDTO);

    ResponseDTO<RopingDivisionRankDTO> obtain(Long cdnRopingDivisionRank);

    ResponseDTO<Page<RopingDivisionRankDTO>> pagination(Integer page, Integer pageSize, String sortBy, String direction, Long filter);

    ResponseDTO<List<RopingDivisionRankDTO>> listAll();

    ResponseDTO<List<RopingDivisionRankDTO>> listExample(RopingDivisionRankDTO ropingdivisionrankDTO);

    ResponseDTO delete(Long cdnRopingDivisionRank);

    ResponseDTO<Page<RopingDivisionRankDTO>> paginationFull(Integer page, Integer pageSize, String sortBy, String direction, Map<String, Object> filterMap);
}
