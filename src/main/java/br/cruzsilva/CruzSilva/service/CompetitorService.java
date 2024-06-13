package br.cruzsilva.CruzSilva.service;

import br.cruzsilva.CruzSilva.dto.CompetitorDTO;
import br.cruzsilva.CruzSilva.dto.ResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Map;

import java.util.List;

@Component
public interface CompetitorService {
    ResponseDTO<CompetitorDTO> save(CompetitorDTO competitorDTO);

    ResponseDTO<CompetitorDTO> obtain(Long cdnCompetitor);

    ResponseDTO<Page<CompetitorDTO>> pagination(Integer page, Integer pageSize, String sortBy, String direction, Long filter);

    ResponseDTO<List<CompetitorDTO>> listAll();

    ResponseDTO<List<CompetitorDTO>> listExample(CompetitorDTO competitorDTO);

    ResponseDTO delete(Long cdnCompetitor);

    ResponseDTO<Page<CompetitorDTO>> paginationFull(Integer page, Integer pageSize, String sortBy, String direction, Map<String, Object> filterMap);
}
