package br.cruzsilva.CruzSilva.bo;

import br.cruzsilva.CruzSilva.dto.RopingModalityTypeDTO;

import br.cruzsilva.CruzSilva.mapper.CycleAvoidingMappingContext;
import br.cruzsilva.CruzSilva.mapper.RopingModalityTypeMapper;
import br.cruzsilva.CruzSilva.model.masterDataBase.RopingModalityType;
import br.cruzsilva.CruzSilva.repository.masterDataBase.RopingModalityTypeRepository;
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
public class RopingModalityTypeBO {

    @Autowired
    UtilBO utilBO;

    @Autowired
    RopingModalityTypeRepository ropingmodalitytypeRepository;

    @Autowired
    RopingModalityTypeMapper ropingmodalitytypeMapper;

    public RopingModalityTypeDTO save(RopingModalityTypeDTO ropingmodalitytypeDTO) throws IllegalAccessException {

        RopingModalityType ropingmodalitytype = ropingmodalitytypeMapper.toEntity(ropingmodalitytypeDTO, new CycleAvoidingMappingContext());

        utilBO.assingObjectToList(ropingmodalitytype, "ropingmodalitytype");

        ropingmodalitytypeRepository.save(ropingmodalitytype);

        utilBO.entityToDtoCustom(ropingmodalitytype, ropingmodalitytypeDTO, new ArrayList<>());

        return ropingmodalitytypeDTO;

    }

    public RopingModalityTypeDTO obtain(Long cdnRopingModalityType) {
        RopingModalityType ropingmodalitytype = new RopingModalityType();

        ropingmodalitytype = ropingmodalitytypeRepository.getReferenceById(cdnRopingModalityType);

        RopingModalityTypeDTO ropingmodalitytypeDTO = new RopingModalityTypeDTO(); //ropingmodalitytypeMapper.toDto(ropingmodalitytype, new CycleAvoidingMappingContext());

        utilBO.entityToDtoCustom(ropingmodalitytype, ropingmodalitytypeDTO, new ArrayList<>());

        return ropingmodalitytypeDTO;
    }

    public void delete(Long cdnRopingModalityType) {
        RopingModalityType ropingmodalitytype = new RopingModalityType(cdnRopingModalityType);
        utilBO.checkRelationship(ropingmodalitytype,cdnRopingModalityType);
        ropingmodalitytypeRepository.deleteById(cdnRopingModalityType);

    }

    public Page<RopingModalityTypeDTO> pagination(Integer page, Integer pageSize, String sortBy, String direction, Long filter) {

        RopingModalityType ropingmodalitytype = new RopingModalityType();
        return ropingmodalitytypeRepository
                .findAll(Example.of(ropingmodalitytype),
                        PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(direction), sortBy)))
                .map(x -> {
                    RopingModalityTypeDTO ropingmodalitytypeDTOAux = new RopingModalityTypeDTO();
                    utilBO.entityToDtoCustom(x, ropingmodalitytypeDTOAux, new ArrayList<>());
                    return ropingmodalitytypeDTOAux;
                });
    }

    public List<RopingModalityTypeDTO> listAll() {
        List<RopingModalityType> ropingmodalitytype = new ArrayList<>();

        ropingmodalitytype = ropingmodalitytypeRepository.findAll();

        //List<RopingModalityTypeDTO> ropingmodalitytypeDTO = ropingmodalitytypeMapper.toDto(ropingmodalitytype, new CycleAvoidingMappingContext());
        List<RopingModalityTypeDTO> ropingmodalitytypeDTOList = new ArrayList<>();
        ropingmodalitytype.forEach( t->{
            RopingModalityTypeDTO ropingmodalitytypeDTOAux = new RopingModalityTypeDTO();
            utilBO.entityToDtoCustom(t, ropingmodalitytypeDTOAux, new ArrayList<>());
            ropingmodalitytypeDTOList.add(ropingmodalitytypeDTOAux);
        });

        return ropingmodalitytypeDTOList;
    }

    public Object listExample(RopingModalityTypeDTO ropingmodalitytypeDTO) {
        List<RopingModalityType> ropingmodalitytype = new ArrayList<>();

        RopingModalityType ropingmodalitytypeExemple = ropingmodalitytypeMapper.toEntity(ropingmodalitytypeDTO, new CycleAvoidingMappingContext());

        ropingmodalitytype = ropingmodalitytypeRepository.findAll(Example.of(ropingmodalitytypeExemple));

        List<RopingModalityTypeDTO> ropingmodalitytypeDTOList = new ArrayList<>();
        ropingmodalitytype.forEach( t->{
            RopingModalityTypeDTO ropingmodalitytypeDTOAux = new RopingModalityTypeDTO();
            utilBO.entityToDtoCustom(t, ropingmodalitytypeDTOAux, new ArrayList<>());
            ropingmodalitytypeDTOList.add(ropingmodalitytypeDTOAux);
        });

        return ropingmodalitytypeDTOList;
    }

    public Page<RopingModalityTypeDTO> paginationFull(Integer page, Integer pageSize, String sortBy, String direction, Map<String, Object> filterMap) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Page<RopingModalityTypeDTO> ropingmodalitytypeDTOPage = null;

        Specification<RopingModalityType> spec = (root, query, criteriaBuilder) -> {
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

        ropingmodalitytypeDTOPage = ropingmodalitytypeRepository
                .findAll(spec,
                        PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(direction), sortBy)))
                .map(x -> {
                    RopingModalityTypeDTO ropingmodalitytypeDTOAux = new RopingModalityTypeDTO();
                    utilBO.entityToDtoCustom(x, ropingmodalitytypeDTOAux, new ArrayList<>());
                    return ropingmodalitytypeDTOAux;
                });


        return ropingmodalitytypeDTOPage;
    }

}
