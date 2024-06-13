package br.cruzsilva.CruzSilva.service;

import br.cruzsilva.CruzSilva.dto.AddressDTO;
import br.cruzsilva.CruzSilva.dto.ResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Map;

import java.util.List;

@Component
public interface AddressService {
    ResponseDTO<AddressDTO> save(AddressDTO addressDTO);

    ResponseDTO<AddressDTO> obtain(Long cdnAddress);

    ResponseDTO<Page<AddressDTO>> pagination(Integer page, Integer pageSize, String sortBy, String direction, Long filter);

    ResponseDTO<List<AddressDTO>> listAll();

    ResponseDTO<List<AddressDTO>> listExample(AddressDTO addressDTO);

    ResponseDTO delete(Long cdnAddress);

    ResponseDTO<Page<AddressDTO>> paginationFull(Integer page, Integer pageSize, String sortBy, String direction, Map<String, Object> filterMap);
}
