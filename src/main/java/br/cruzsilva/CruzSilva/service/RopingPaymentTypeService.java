package br.cruzsilva.CruzSilva.service;

import br.cruzsilva.CruzSilva.dto.RopingPaymentTypeDTO;
import br.cruzsilva.CruzSilva.dto.ResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Map;

import java.util.List;

@Component
public interface RopingPaymentTypeService {
    ResponseDTO<RopingPaymentTypeDTO> save(RopingPaymentTypeDTO ropingpaymenttypeDTO);

    ResponseDTO<RopingPaymentTypeDTO> obtain(Long cdnRopingPaymentType);

    ResponseDTO<Page<RopingPaymentTypeDTO>> pagination(Integer page, Integer pageSize, String sortBy, String direction, Long filter);

    ResponseDTO<List<RopingPaymentTypeDTO>> listAll();

    ResponseDTO<List<RopingPaymentTypeDTO>> listExample(RopingPaymentTypeDTO ropingpaymenttypeDTO);

    ResponseDTO delete(Long cdnRopingPaymentType);

    ResponseDTO<Page<RopingPaymentTypeDTO>> paginationFull(Integer page, Integer pageSize, String sortBy, String direction, Map<String, Object> filterMap);
}
