package br.cruzsilva.CruzSilva.service;

import br.cruzsilva.CruzSilva.dto.TrackDTO;
import br.cruzsilva.CruzSilva.dto.ResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Map;

import java.util.List;

@Component
public interface TrackService {
    ResponseDTO<TrackDTO> save(TrackDTO trackDTO);

    ResponseDTO<TrackDTO> obtain(Long cdnTrack);

    ResponseDTO<Page<TrackDTO>> pagination(Integer page, Integer pageSize, String sortBy, String direction, Long filter);

    ResponseDTO<List<TrackDTO>> listAll();

    ResponseDTO<List<TrackDTO>> listExample(TrackDTO trackDTO);

    ResponseDTO delete(Long cdnTrack);

    ResponseDTO<Page<TrackDTO>> paginationFull(Integer page, Integer pageSize, String sortBy, String direction, Map<String, Object> filterMap);
}
