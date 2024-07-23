package br.cruzsilva.CruzSilva.service;

import br.cruzsilva.CruzSilva.dto.EventTestDTO;
import br.cruzsilva.CruzSilva.dto.ResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Map;

import java.util.List;

@Component
public interface EventTestService {
    ResponseDTO<EventTestDTO> save(EventTestDTO eventtestDTO);

    ResponseDTO<EventTestDTO> obtain(Long cdnEventTest);

    ResponseDTO<Page<EventTestDTO>> pagination(Integer page, Integer pageSize, String sortBy, String direction, Long filter);

    ResponseDTO<List<EventTestDTO>> listAll();

    ResponseDTO<List<EventTestDTO>> listExample(EventTestDTO eventtestDTO);

    ResponseDTO delete(Long cdnEventTest);

    ResponseDTO<Page<EventTestDTO>> paginationFull(Integer page, Integer pageSize, String sortBy, String direction, Map<String, Object> filterMap);
}
