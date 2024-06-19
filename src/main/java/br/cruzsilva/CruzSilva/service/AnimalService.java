package br.cruzsilva.CruzSilva.service;

import br.cruzsilva.CruzSilva.dto.AnimalDTO;
import br.cruzsilva.CruzSilva.dto.ResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Map;

import java.util.List;

@Component
public interface AnimalService {
    ResponseDTO<AnimalDTO> save(AnimalDTO animalDTO);

    ResponseDTO<AnimalDTO> obtain(Long cdnAnimals);

    ResponseDTO<Page<AnimalDTO>> pagination(Integer page, Integer pageSize, String sortBy, String direction, Long filter);

    ResponseDTO<List<AnimalDTO>> listAll();

    ResponseDTO<List<AnimalDTO>> listExample(AnimalDTO animalDTO);

    ResponseDTO delete(Long cdnAnimals);

    ResponseDTO<Page<AnimalDTO>> paginationFull(Integer page, Integer pageSize, String sortBy, String direction, Map<String, Object> filterMap);
}
