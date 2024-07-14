package br.cruzsilva.CruzSilva.service;

import br.cruzsilva.CruzSilva.dto.PaymentDTO;
import br.cruzsilva.CruzSilva.dto.ResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Map;

import java.util.List;

@Component
public interface PaymentService {
    ResponseDTO<PaymentDTO> save(PaymentDTO paymentDTO);

    ResponseDTO<PaymentDTO> obtain(Long cdnPayment);

    ResponseDTO<Page<PaymentDTO>> pagination(Integer page, Integer pageSize, String sortBy, String direction, Long filter);

    ResponseDTO<List<PaymentDTO>> listAll();

    ResponseDTO<List<PaymentDTO>> listExample(PaymentDTO paymentDTO);

    ResponseDTO delete(Long cdnPayment);

    ResponseDTO<Page<PaymentDTO>> paginationFull(Integer page, Integer pageSize, String sortBy, String direction, Map<String, Object> filterMap);
}
