package br.cruzsilva.CruzSilva.service;

import br.cruzsilva.CruzSilva.dto.CustomerDTO;
import br.cruzsilva.CruzSilva.dto.ResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Map;

import java.util.List;

@Component
public interface CustomerService {
    ResponseDTO<CustomerDTO> save(CustomerDTO customerDTO);

    ResponseDTO<CustomerDTO> obtain(Long cdnCustomer);

    ResponseDTO<Page<CustomerDTO>> pagination(Integer page, Integer pageSize, String sortBy, String direction, Long filter);

    ResponseDTO<List<CustomerDTO>> listAll();

    ResponseDTO<List<CustomerDTO>> listExample(CustomerDTO customerDTO);

    ResponseDTO delete(Long cdnCustomer);

    ResponseDTO<Page<CustomerDTO>> paginationFull(Integer page, Integer pageSize, String sortBy, String direction, Map<String, Object> filterMap);
}
