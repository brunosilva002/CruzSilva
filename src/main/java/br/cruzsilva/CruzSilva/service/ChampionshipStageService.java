package br.cruzsilva.CruzSilva.service;

import br.cruzsilva.CruzSilva.dto.ChampionshipStageDTO;
import br.cruzsilva.CruzSilva.dto.ResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Map;

import java.util.List;

@Component
public interface ChampionshipStageService {
    ResponseDTO<ChampionshipStageDTO> save(ChampionshipStageDTO championshipstageDTO);

    ResponseDTO<ChampionshipStageDTO> obtain(Long cdnChampionshipStage);

    ResponseDTO<Page<ChampionshipStageDTO>> pagination(Integer page, Integer pageSize, String sortBy, String direction, Long filter);

    ResponseDTO<List<ChampionshipStageDTO>> listAll();

    ResponseDTO<List<ChampionshipStageDTO>> listExample(ChampionshipStageDTO championshipstageDTO);

    ResponseDTO delete(Long cdnChampionshipStage);

    ResponseDTO<Page<ChampionshipStageDTO>> paginationFull(Integer page, Integer pageSize, String sortBy, String direction, Map<String, Object> filterMap);
}
