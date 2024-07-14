package br.cruzsilva.CruzSilva.service;

import br.cruzsilva.CruzSilva.dto.PaymentTypeDTO;
import br.cruzsilva.CruzSilva.dto.ResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Map;

import java.util.List;

@Component
public interface PaymentTypeService {
    ResponseDTO<PaymentTypeDTO> save(PaymentTypeDTO paymenttypeDTO);

    ResponseDTO<PaymentTypeDTO> obtain(Long cdnPaymentType);

    ResponseDTO<Page<PaymentTypeDTO>> pagination(Integer page, Integer pageSize, String sortBy, String direction, Long filter);

    ResponseDTO<List<PaymentTypeDTO>> listAll();

    ResponseDTO<List<PaymentTypeDTO>> listExample(PaymentTypeDTO paymenttypeDTO);

    ResponseDTO delete(Long cdnPaymentType);

    ResponseDTO<Page<PaymentTypeDTO>> paginationFull(Integer page, Integer pageSize, String sortBy, String direction, Map<String, Object> filterMap);
}
