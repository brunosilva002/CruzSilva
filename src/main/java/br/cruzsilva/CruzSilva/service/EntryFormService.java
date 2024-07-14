package br.cruzsilva.CruzSilva.service;

import br.cruzsilva.CruzSilva.dto.EntryFormDTO;
import br.cruzsilva.CruzSilva.dto.ResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Map;

import java.util.List;

@Component
public interface EntryFormService {
    ResponseDTO<EntryFormDTO> save(EntryFormDTO entryformDTO);

    ResponseDTO<EntryFormDTO> obtain(Long cdnEntryForm);

    ResponseDTO<Page<EntryFormDTO>> pagination(Integer page, Integer pageSize, String sortBy, String direction, Long filter);

    ResponseDTO<List<EntryFormDTO>> listAll();

    ResponseDTO<List<EntryFormDTO>> listExample(EntryFormDTO entryformDTO);

    ResponseDTO delete(Long cdnEntryForm);

    ResponseDTO<Page<EntryFormDTO>> paginationFull(Integer page, Integer pageSize, String sortBy, String direction, Map<String, Object> filterMap);
}
