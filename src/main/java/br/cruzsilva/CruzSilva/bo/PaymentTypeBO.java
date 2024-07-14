package br.cruzsilva.CruzSilva.bo;

import br.cruzsilva.CruzSilva.dto.PaymentTypeDTO;

import br.cruzsilva.CruzSilva.mapper.CycleAvoidingMappingContext;
import br.cruzsilva.CruzSilva.mapper.PaymentTypeMapper;
import br.cruzsilva.CruzSilva.model.masterDataBase.PaymentType;
import br.cruzsilva.CruzSilva.repository.masterDataBase.PaymentTypeRepository;
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
public class PaymentTypeBO {

    @Autowired
    UtilBO utilBO;

    @Autowired
    PaymentTypeRepository paymenttypeRepository;

    @Autowired
    PaymentTypeMapper paymenttypeMapper;

    public PaymentTypeDTO save(PaymentTypeDTO paymenttypeDTO) throws IllegalAccessException {

        PaymentType paymenttype = paymenttypeMapper.toEntity(paymenttypeDTO, new CycleAvoidingMappingContext());

        utilBO.assingObjectToList(paymenttype, "paymenttype");

        paymenttypeRepository.save(paymenttype);

        utilBO.entityToDtoCustom(paymenttype, paymenttypeDTO, new ArrayList<>());

        return paymenttypeDTO;

    }

    public PaymentTypeDTO obtain(Long cdnPaymentType) {
        PaymentType paymenttype = new PaymentType();

        paymenttype = paymenttypeRepository.getReferenceById(cdnPaymentType);

        PaymentTypeDTO paymenttypeDTO = new PaymentTypeDTO(); //paymenttypeMapper.toDto(paymenttype, new CycleAvoidingMappingContext());

        utilBO.entityToDtoCustom(paymenttype, paymenttypeDTO, new ArrayList<>());

        return paymenttypeDTO;
    }

    public void delete(Long cdnPaymentType) {
        PaymentType paymenttype = new PaymentType(cdnPaymentType);
        utilBO.checkRelationship(paymenttype,cdnPaymentType);
        paymenttypeRepository.deleteById(cdnPaymentType);

    }

    public Page<PaymentTypeDTO> pagination(Integer page, Integer pageSize, String sortBy, String direction, Long filter) {

        PaymentType paymenttype = new PaymentType();
        return paymenttypeRepository
                .findAll(Example.of(paymenttype),
                        PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(direction), sortBy)))
                .map(x -> {
                    PaymentTypeDTO paymenttypeDTOAux = new PaymentTypeDTO();
                    utilBO.entityToDtoCustom(x, paymenttypeDTOAux, new ArrayList<>());
                    return paymenttypeDTOAux;
                });
    }

    public List<PaymentTypeDTO> listAll() {
        List<PaymentType> paymenttype = new ArrayList<>();

        paymenttype = paymenttypeRepository.findAll();

        //List<PaymentTypeDTO> paymenttypeDTO = paymenttypeMapper.toDto(paymenttype, new CycleAvoidingMappingContext());
        List<PaymentTypeDTO> paymenttypeDTOList = new ArrayList<>();
        paymenttype.forEach( t->{
            PaymentTypeDTO paymenttypeDTOAux = new PaymentTypeDTO();
            utilBO.entityToDtoCustom(t, paymenttypeDTOAux, new ArrayList<>());
            paymenttypeDTOList.add(paymenttypeDTOAux);
        });

        return paymenttypeDTOList;
    }

    public Object listExample(PaymentTypeDTO paymenttypeDTO) {
        List<PaymentType> paymenttype = new ArrayList<>();

        PaymentType paymenttypeExemple = paymenttypeMapper.toEntity(paymenttypeDTO, new CycleAvoidingMappingContext());

        paymenttype = paymenttypeRepository.findAll(Example.of(paymenttypeExemple));

        List<PaymentTypeDTO> paymenttypeDTOList = new ArrayList<>();
        paymenttype.forEach( t->{
            PaymentTypeDTO paymenttypeDTOAux = new PaymentTypeDTO();
            utilBO.entityToDtoCustom(t, paymenttypeDTOAux, new ArrayList<>());
            paymenttypeDTOList.add(paymenttypeDTOAux);
        });

        return paymenttypeDTOList;
    }

    public Page<PaymentTypeDTO> paginationFull(Integer page, Integer pageSize, String sortBy, String direction, Map<String, Object> filterMap) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Page<PaymentTypeDTO> paymenttypeDTOPage = null;

        Specification<PaymentType> spec = (root, query, criteriaBuilder) -> {
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

        paymenttypeDTOPage = paymenttypeRepository
                .findAll(spec,
                        PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(direction), sortBy)))
                .map(x -> {
                    PaymentTypeDTO paymenttypeDTOAux = new PaymentTypeDTO();
                    utilBO.entityToDtoCustom(x, paymenttypeDTOAux, new ArrayList<>());
                    return paymenttypeDTOAux;
                });


        return paymenttypeDTOPage;
    }

}
