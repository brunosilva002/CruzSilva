package br.cruzsilva.CruzSilva.service;

import br.cruzsilva.CruzSilva.dto.RopingProductDTO;
import br.cruzsilva.CruzSilva.dto.ResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Map;

import java.util.List;

@Component
public interface RopingProductService {
    ResponseDTO<RopingProductDTO> save(RopingProductDTO ropingproductDTO);

    ResponseDTO<RopingProductDTO> obtain(Long cdnRopingProduct);

    ResponseDTO<Page<RopingProductDTO>> pagination(Integer page, Integer pageSize, String sortBy, String direction, Long filter);

    ResponseDTO<List<RopingProductDTO>> listAll();

    ResponseDTO<List<RopingProductDTO>> listExample(RopingProductDTO ropingproductDTO);

    ResponseDTO delete(Long cdnRopingProduct);

    ResponseDTO<Page<RopingProductDTO>> paginationFull(Integer page, Integer pageSize, String sortBy, String direction, Map<String, Object> filterMap);
}
