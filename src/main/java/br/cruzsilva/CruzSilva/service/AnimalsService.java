package br.cruzsilva.CruzSilva.service;

import br.cruzsilva.CruzSilva.dto.AnimalsDTO;
import br.cruzsilva.CruzSilva.dto.ResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Map;

import java.util.List;

@Component
public interface AnimalsService {
    ResponseDTO<AnimalsDTO> save(AnimalsDTO animalsDTO);

    ResponseDTO<AnimalsDTO> obtain(Long cdnAnimals);

    ResponseDTO<Page<AnimalsDTO>> pagination(Integer page, Integer pageSize, String sortBy, String direction, Long filter);

    ResponseDTO<List<AnimalsDTO>> listAll();

    ResponseDTO<List<AnimalsDTO>> listExample(AnimalsDTO animalsDTO);

    ResponseDTO delete(Long cdnAnimals);

    ResponseDTO<Page<AnimalsDTO>> paginationFull(Integer page, Integer pageSize, String sortBy, String direction, Map<String, Object> filterMap);
}
