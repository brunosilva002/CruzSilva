package br.cruzsilva.CruzSilva.bo;

import br.cruzsilva.CruzSilva.dto.PaymentDTO;

import br.cruzsilva.CruzSilva.mapper.CycleAvoidingMappingContext;
import br.cruzsilva.CruzSilva.mapper.PaymentMapper;
import br.cruzsilva.CruzSilva.model.masterDataBase.Payment;
import br.cruzsilva.CruzSilva.repository.masterDataBase.PaymentRepository;
import jakarta.persistence.criteria.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

@Slf4j
@Component
public class PaymentBO {

    @Autowired
    UtilBO utilBO;

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    PaymentMapper paymentMapper;

    public PaymentDTO save(PaymentDTO paymentDTO) throws IllegalAccessException {

        Payment payment = paymentMapper.toEntity(paymentDTO, new CycleAvoidingMappingContext());

        utilBO.assingObjectToList(payment, "payment");

        paymentRepository.save(payment);

        utilBO.entityToDtoCustom(payment, paymentDTO, new ArrayList<>());

        return paymentDTO;

    }

    public PaymentDTO obtain(Long cdnPayment) {
        Payment payment = new Payment();

        payment = paymentRepository.getReferenceById(cdnPayment);

        PaymentDTO paymentDTO = new PaymentDTO(); //paymentMapper.toDto(payment, new CycleAvoidingMappingContext());

        utilBO.entityToDtoCustom(payment, paymentDTO, new ArrayList<>());

        return paymentDTO;
    }

    public void delete(Long cdnPayment) {
        Payment payment = new Payment(cdnPayment);
        utilBO.checkRelationship(payment,cdnPayment);
        paymentRepository.deleteById(cdnPayment);

    }

    public Page<PaymentDTO> pagination(Integer page, Integer pageSize, String sortBy, String direction, Long filter) {

        Payment payment = new Payment();
        return paymentRepository
                .findAll(Example.of(payment),
                        PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(direction), sortBy)))
                .map(x -> {
                    PaymentDTO paymentDTOAux = new PaymentDTO();
                    utilBO.entityToDtoCustom(x, paymentDTOAux, new ArrayList<>());
                    return paymentDTOAux;
                });
    }

    public List<PaymentDTO> listAll() {
        List<Payment> payment = new ArrayList<>();

        payment = paymentRepository.findAll();

        //List<PaymentDTO> paymentDTO = paymentMapper.toDto(payment, new CycleAvoidingMappingContext());
        List<PaymentDTO> paymentDTOList = new ArrayList<>();
        payment.forEach( t->{
            PaymentDTO paymentDTOAux = new PaymentDTO();
            utilBO.entityToDtoCustom(t, paymentDTOAux, new ArrayList<>());
            paymentDTOList.add(paymentDTOAux);
        });

        return paymentDTOList;
    }

    public Object listExample(PaymentDTO paymentDTO) {
        List<Payment> payment = new ArrayList<>();

        Payment paymentExemple = paymentMapper.toEntity(paymentDTO, new CycleAvoidingMappingContext());

        payment = paymentRepository.findAll(Example.of(paymentExemple));

        List<PaymentDTO> paymentDTOList = new ArrayList<>();
        payment.forEach( t->{
            PaymentDTO paymentDTOAux = new PaymentDTO();
            utilBO.entityToDtoCustom(t, paymentDTOAux, new ArrayList<>());
            paymentDTOList.add(paymentDTOAux);
        });

        return paymentDTOList;
    }

    public Page<PaymentDTO> paginationFull(Integer page, Integer pageSize, String sortBy, String direction, Map<String, Object> filterMap) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Page<PaymentDTO> paymentDTOPage = null;

        Specification<Payment> spec = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            for (Map.Entry<String, Object> entry : filterMap.entrySet()) {
                String[] propriedades = entry.getKey().split("\\.");
                String valor = "";
                String modo = "";
                Path<?> path = root;
                if (propriedades.length > 1) {
                    for (String propriedade : propriedades) {
                        path = path.get(propriedade);
                    }
                } else {
                    path = root.get(entry.getKey());
                }
                for (Map.Entry<String, Object> entry1 : ((Map<String, Object>) entry.getValue()).entrySet()) {
                    if (entry1.getKey().equals("matchMode")) {
                        modo = entry1.getValue().toString();
                    } else if (entry1.getKey().equals("value")) {
                        if (Objects.nonNull(entry1.getValue()))
                            valor = entry1.getValue().toString();
                        else
                            valor = null;
                    }
                }
                if (Objects.nonNull(valor)) {
                    switch (modo) {
                        case "startsWith":
                            predicates.add(criteriaBuilder.like((Expression<String>) path, valor + "%"));
                            break;
                        case "endsWith":
                            predicates.add(criteriaBuilder.like((Expression<String>) path, "%" + valor));
                            break;
                        case "equals":
                            predicates.add(criteriaBuilder.equal(path, valor));
                            break;
                        case "notEquals":
                            predicates.add(criteriaBuilder.notEqual(path, valor));
                            break;
                        case "notContains":
                            predicates.add(criteriaBuilder.notLike((Expression<String>) path, "%" + valor + "%"));
                            break;
                        case "contains":
                            predicates.add(criteriaBuilder.like((Expression<String>) path, "%" + valor + "%"));
                            break;
                    }
                }
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

        paymentDTOPage = paymentRepository
                .findAll(spec,
                        PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(direction), sortBy)))
                .map(x -> {
                    PaymentDTO paymentDTOAux = new PaymentDTO();
                    utilBO.entityToDtoCustom(x, paymentDTOAux, new ArrayList<>());
                    return paymentDTOAux;
                });


        return paymentDTOPage;
    }

}
