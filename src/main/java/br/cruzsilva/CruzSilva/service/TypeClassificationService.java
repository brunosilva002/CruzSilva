package br.cruzsilva.CruzSilva.service;

import br.cruzsilva.CruzSilva.dto.TypeClassificationDTO;
import br.cruzsilva.CruzSilva.dto.ResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Map;

import java.util.List;

@Component
public interface TypeClassificationService {
    ResponseDTO<TypeClassificationDTO> save(TypeClassificationDTO typeclassificationDTO);

    ResponseDTO<TypeClassificationDTO> obtain(Long cdnTypeClassification);

    ResponseDTO<Page<TypeClassificationDTO>> pagination(Integer page, Integer pageSize, String sortBy, String direction, Long filter);

    ResponseDTO<List<TypeClassificationDTO>> listAll();

    ResponseDTO<List<TypeClassificationDTO>> listExample(TypeClassificationDTO typeclassificationDTO);

    ResponseDTO delete(Long cdnTypeClassification);

    ResponseDTO<Page<TypeClassificationDTO>> paginationFull(Integer page, Integer pageSize, String sortBy, String direction, Map<String, Object> filterMap);
}
