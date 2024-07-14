package br.cruzsilva.CruzSilva.bo;

import br.cruzsilva.CruzSilva.dto.RopingPaymentTypeDTO;

import br.cruzsilva.CruzSilva.mapper.CycleAvoidingMappingContext;
import br.cruzsilva.CruzSilva.mapper.RopingPaymentTypeMapper;
import br.cruzsilva.CruzSilva.model.masterDataBase.RopingPaymentType;
import br.cruzsilva.CruzSilva.repository.masterDataBase.RopingPaymentTypeRepository;
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
public class RopingPaymentTypeBO {

    @Autowired
    UtilBO utilBO;

    @Autowired
    RopingPaymentTypeRepository ropingpaymenttypeRepository;

    @Autowired
    RopingPaymentTypeMapper ropingpaymenttypeMapper;

    public RopingPaymentTypeDTO save(RopingPaymentTypeDTO ropingpaymenttypeDTO) throws IllegalAccessException {

        RopingPaymentType ropingpaymenttype = ropingpaymenttypeMapper.toEntity(ropingpaymenttypeDTO, new CycleAvoidingMappingContext());

        utilBO.assingObjectToList(ropingpaymenttype, "ropingpaymenttype");

        ropingpaymenttypeRepository.save(ropingpaymenttype);

        utilBO.entityToDtoCustom(ropingpaymenttype, ropingpaymenttypeDTO, new ArrayList<>());

        return ropingpaymenttypeDTO;

    }

    public RopingPaymentTypeDTO obtain(Long cdnRopingPaymentType) {
        RopingPaymentType ropingpaymenttype = new RopingPaymentType();

        ropingpaymenttype = ropingpaymenttypeRepository.getReferenceById(cdnRopingPaymentType);

        RopingPaymentTypeDTO ropingpaymenttypeDTO = new RopingPaymentTypeDTO(); //ropingpaymenttypeMapper.toDto(ropingpaymenttype, new CycleAvoidingMappingContext());

        utilBO.entityToDtoCustom(ropingpaymenttype, ropingpaymenttypeDTO, new ArrayList<>());

        return ropingpaymenttypeDTO;
    }

    public void delete(Long cdnRopingPaymentType) {
        RopingPaymentType ropingpaymenttype = new RopingPaymentType(cdnRopingPaymentType);
        utilBO.checkRelationship(ropingpaymenttype,cdnRopingPaymentType);
        ropingpaymenttypeRepository.deleteById(cdnRopingPaymentType);

    }

    public Page<RopingPaymentTypeDTO> pagination(Integer page, Integer pageSize, String sortBy, String direction, Long filter) {

        RopingPaymentType ropingpaymenttype = new RopingPaymentType();
        return ropingpaymenttypeRepository
                .findAll(Example.of(ropingpaymenttype),
                        PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(direction), sortBy)))
                .map(x -> {
                    RopingPaymentTypeDTO ropingpaymenttypeDTOAux = new RopingPaymentTypeDTO();
                    utilBO.entityToDtoCustom(x, ropingpaymenttypeDTOAux, new ArrayList<>());
                    return ropingpaymenttypeDTOAux;
                });
    }

    public List<RopingPaymentTypeDTO> listAll() {
        List<RopingPaymentType> ropingpaymenttype = new ArrayList<>();

        ropingpaymenttype = ropingpaymenttypeRepository.findAll();

        //List<RopingPaymentTypeDTO> ropingpaymenttypeDTO = ropingpaymenttypeMapper.toDto(ropingpaymenttype, new CycleAvoidingMappingContext());
        List<RopingPaymentTypeDTO> ropingpaymenttypeDTOList = new ArrayList<>();
        ropingpaymenttype.forEach( t->{
            RopingPaymentTypeDTO ropingpaymenttypeDTOAux = new RopingPaymentTypeDTO();
            utilBO.entityToDtoCustom(t, ropingpaymenttypeDTOAux, new ArrayList<>());
            ropingpaymenttypeDTOList.add(ropingpaymenttypeDTOAux);
        });

        return ropingpaymenttypeDTOList;
    }

    public Object listExample(RopingPaymentTypeDTO ropingpaymenttypeDTO) {
        List<RopingPaymentType> ropingpaymenttype = new ArrayList<>();

        RopingPaymentType ropingpaymenttypeExemple = ropingpaymenttypeMapper.toEntity(ropingpaymenttypeDTO, new CycleAvoidingMappingContext());

        ropingpaymenttype = ropingpaymenttypeRepository.findAll(Example.of(ropingpaymenttypeExemple));

        List<RopingPaymentTypeDTO> ropingpaymenttypeDTOList = new ArrayList<>();
        ropingpaymenttype.forEach( t->{
            RopingPaymentTypeDTO ropingpaymenttypeDTOAux = new RopingPaymentTypeDTO();
            utilBO.entityToDtoCustom(t, ropingpaymenttypeDTOAux, new ArrayList<>());
            ropingpaymenttypeDTOList.add(ropingpaymenttypeDTOAux);
        });

        return ropingpaymenttypeDTOList;
    }

    public Page<RopingPaymentTypeDTO> paginationFull(Integer page, Integer pageSize, String sortBy, String direction, Map<String, Object> filterMap) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Page<RopingPaymentTypeDTO> ropingpaymenttypeDTOPage = null;

        Specification<RopingPaymentType> spec = (root, query, criteriaBuilder) -> {
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

        ropingpaymenttypeDTOPage = ropingpaymenttypeRepository
                .findAll(spec,
                        PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(direction), sortBy)))
                .map(x -> {
                    RopingPaymentTypeDTO ropingpaymenttypeDTOAux = new RopingPaymentTypeDTO();
                    utilBO.entityToDtoCustom(x, ropingpaymenttypeDTOAux, new ArrayList<>());
                    return ropingpaymenttypeDTOAux;
                });


        return ropingpaymenttypeDTOPage;
    }

}
