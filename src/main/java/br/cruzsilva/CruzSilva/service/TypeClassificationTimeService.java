package br.cruzsilva.CruzSilva.service;

import br.cruzsilva.CruzSilva.dto.TypeClassificationTimeDTO;
import br.cruzsilva.CruzSilva.dto.ResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Map;

import java.util.List;

@Component
public interface TypeClassificationTimeService {
    ResponseDTO<TypeClassificationTimeDTO> save(TypeClassificationTimeDTO typeclassificationtimeDTO);

    ResponseDTO<TypeClassificationTimeDTO> obtain(Long cdnTypeClassificationTime);

    ResponseDTO<Page<TypeClassificationTimeDTO>> pagination(Integer page, Integer pageSize, String sortBy, String direction, Long filter);

    ResponseDTO<List<TypeClassificationTimeDTO>> listAll();

    ResponseDTO<List<TypeClassificationTimeDTO>> listExample(TypeClassificationTimeDTO typeclassificationtimeDTO);

    ResponseDTO delete(Long cdnTypeClassificationTime);

    ResponseDTO<Page<TypeClassificationTimeDTO>> paginationFull(Integer page, Integer pageSize, String sortBy, String direction, Map<String, Object> filterMap);
}
