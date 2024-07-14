package br.cruzsilva.CruzSilva.service;

import br.cruzsilva.CruzSilva.dto.TrackStatusDTO;
import br.cruzsilva.CruzSilva.dto.ResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Map;

import java.util.List;

@Component
public interface TrackStatusService {
    ResponseDTO<TrackStatusDTO> save(TrackStatusDTO trackstatusDTO);

    ResponseDTO<TrackStatusDTO> obtain(Long cdnTrackStatus);

    ResponseDTO<Page<TrackStatusDTO>> pagination(Integer page, Integer pageSize, String sortBy, String direction, Long filter);

    ResponseDTO<List<TrackStatusDTO>> listAll();

    ResponseDTO<List<TrackStatusDTO>> listExample(TrackStatusDTO trackstatusDTO);

    ResponseDTO delete(Long cdnTrackStatus);

    ResponseDTO<Page<TrackStatusDTO>> paginationFull(Integer page, Integer pageSize, String sortBy, String direction, Map<String, Object> filterMap);
}
