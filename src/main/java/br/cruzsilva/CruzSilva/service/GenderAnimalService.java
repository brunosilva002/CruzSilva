package br.cruzsilva.CruzSilva.service;

import br.cruzsilva.CruzSilva.dto.GenderAnimalDTO;
import br.cruzsilva.CruzSilva.dto.ResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Map;

import java.util.List;

@Component
public interface GenderAnimalService {
    ResponseDTO<GenderAnimalDTO> save(GenderAnimalDTO genderanimalDTO);

    ResponseDTO<GenderAnimalDTO> obtain(Long cdnGenderAnimal);

    ResponseDTO<Page<GenderAnimalDTO>> pagination(Integer page, Integer pageSize, String sortBy, String direction, Long filter);

    ResponseDTO<List<GenderAnimalDTO>> listAll();

    ResponseDTO<List<GenderAnimalDTO>> listExample(GenderAnimalDTO genderanimalDTO);

    ResponseDTO delete(Long cdnGenderAnimal);

    ResponseDTO<Page<GenderAnimalDTO>> paginationFull(Integer page, Integer pageSize, String sortBy, String direction, Map<String, Object> filterMap);
}
