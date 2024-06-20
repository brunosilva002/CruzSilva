package br.cruzsilva.CruzSilva.service;

import br.cruzsilva.CruzSilva.dto.BarrelTypeDTO;
import br.cruzsilva.CruzSilva.dto.ResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Map;

import java.util.List;

@Component
public interface BarrelTypeService {
    ResponseDTO<BarrelTypeDTO> save(BarrelTypeDTO barreltypeDTO);

    ResponseDTO<BarrelTypeDTO> obtain(Long cdnBarrelType);

    ResponseDTO<Page<BarrelTypeDTO>> pagination(Integer page, Integer pageSize, String sortBy, String direction, Long filter);

    ResponseDTO<List<BarrelTypeDTO>> listAll();

    ResponseDTO<List<BarrelTypeDTO>> listExample(BarrelTypeDTO barreltypeDTO);

    ResponseDTO delete(Long cdnBarrelType);

    ResponseDTO<Page<BarrelTypeDTO>> paginationFull(Integer page, Integer pageSize, String sortBy, String direction, Map<String, Object> filterMap);
}
