package br.cruzsilva.CruzSilva.service;

import br.cruzsilva.CruzSilva.dto.EventDTO;
import br.cruzsilva.CruzSilva.dto.ResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Map;

import java.util.List;

@Component
public interface EventService {
    ResponseDTO<EventDTO> save(EventDTO eventDTO);

    ResponseDTO<EventDTO> obtain(Long cdnEvent);

    ResponseDTO<Page<EventDTO>> pagination(Integer page, Integer pageSize, String sortBy, String direction, Long filter);

    ResponseDTO<List<EventDTO>> listAll();

    ResponseDTO<List<EventDTO>> listExample(EventDTO eventDTO);

    ResponseDTO delete(Long cdnEvent);

    ResponseDTO<Page<EventDTO>> paginationFull(Integer page, Integer pageSize, String sortBy, String direction, Map<String, Object> filterMap);
}
