package br.cruzsilva.CruzSilva.service;

import br.cruzsilva.CruzSilva.dto.ChampionshipDTO;
import br.cruzsilva.CruzSilva.dto.ResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Map;

import java.util.List;

@Component
public interface ChampionshipService {
    ResponseDTO<ChampionshipDTO> save(ChampionshipDTO championshipDTO);

    ResponseDTO<ChampionshipDTO> obtain(Long cdnChampionship);

    ResponseDTO<Page<ChampionshipDTO>> pagination(Integer page, Integer pageSize, String sortBy, String direction, Long filter);

    ResponseDTO<List<ChampionshipDTO>> listAll();

    ResponseDTO<List<ChampionshipDTO>> listExample(ChampionshipDTO championshipDTO);

    ResponseDTO delete(Long cdnChampionship);

    ResponseDTO<Page<ChampionshipDTO>> paginationFull(Integer page, Integer pageSize, String sortBy, String direction, Map<String, Object> filterMap);
}
