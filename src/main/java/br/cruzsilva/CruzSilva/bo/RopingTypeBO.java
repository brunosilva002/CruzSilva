package br.cruzsilva.CruzSilva.bo;

import br.cruzsilva.CruzSilva.dto.RopingTypeDTO;

import br.cruzsilva.CruzSilva.mapper.CycleAvoidingMappingContext;
import br.cruzsilva.CruzSilva.mapper.RopingTypeMapper;
import br.cruzsilva.CruzSilva.model.masterDataBase.RopingType;
import br.cruzsilva.CruzSilva.repository.masterDataBase.RopingTypeRepository;
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
public class RopingTypeBO {

    @Autowired
    UtilBO utilBO;

    @Autowired
    RopingTypeRepository ropingtypeRepository;

    @Autowired
    RopingTypeMapper ropingtypeMapper;

    public RopingTypeDTO save(RopingTypeDTO ropingtypeDTO) throws IllegalAccessException {

        RopingType ropingtype = ropingtypeMapper.toEntity(ropingtypeDTO, new CycleAvoidingMappingContext());

        utilBO.assingObjectToList(ropingtype, "ropingtype");

        ropingtypeRepository.save(ropingtype);

        utilBO.entityToDtoCustom(ropingtype, ropingtypeDTO, new ArrayList<>());

        return ropingtypeDTO;

    }

    public RopingTypeDTO obtain(Long cdnRopingType) {
        RopingType ropingtype = new RopingType();

        ropingtype = ropingtypeRepository.getReferenceById(cdnRopingType);

        RopingTypeDTO ropingtypeDTO = new RopingTypeDTO(); //ropingtypeMapper.toDto(ropingtype, new CycleAvoidingMappingContext());

        utilBO.entityToDtoCustom(ropingtype, ropingtypeDTO, new ArrayList<>());

        return ropingtypeDTO;
    }

    public void delete(Long cdnRopingType) {
        RopingType ropingtype = new RopingType(cdnRopingType);
        utilBO.checkRelationship(ropingtype,cdnRopingType);
        ropingtypeRepository.deleteById(cdnRopingType);

    }

    public Page<RopingTypeDTO> pagination(Integer page, Integer pageSize, String sortBy, String direction, Long filter) {

        RopingType ropingtype = new RopingType();
        return ropingtypeRepository
                .findAll(Example.of(ropingtype),
                        PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(direction), sortBy)))
                .map(x -> {
                    RopingTypeDTO ropingtypeDTOAux = new RopingTypeDTO();
                    utilBO.entityToDtoCustom(x, ropingtypeDTOAux, new ArrayList<>());
                    return ropingtypeDTOAux;
                });
    }

    public List<RopingTypeDTO> listAll() {
        List<RopingType> ropingtype = new ArrayList<>();

        ropingtype = ropingtypeRepository.findAll();

        //List<RopingTypeDTO> ropingtypeDTO = ropingtypeMapper.toDto(ropingtype, new CycleAvoidingMappingContext());
        List<RopingTypeDTO> ropingtypeDTOList = new ArrayList<>();
        ropingtype.forEach( t->{
            RopingTypeDTO ropingtypeDTOAux = new RopingTypeDTO();
            utilBO.entityToDtoCustom(t, ropingtypeDTOAux, new ArrayList<>());
            ropingtypeDTOList.add(ropingtypeDTOAux);
        });

        return ropingtypeDTOList;
    }

    public Object listExample(RopingTypeDTO ropingtypeDTO) {
        List<RopingType> ropingtype = new ArrayList<>();

        RopingType ropingtypeExemple = ropingtypeMapper.toEntity(ropingtypeDTO, new CycleAvoidingMappingContext());

        ropingtype = ropingtypeRepository.findAll(Example.of(ropingtypeExemple));

        List<RopingTypeDTO> ropingtypeDTOList = new ArrayList<>();
        ropingtype.forEach( t->{
            RopingTypeDTO ropingtypeDTOAux = new RopingTypeDTO();
            utilBO.entityToDtoCustom(t, ropingtypeDTOAux, new ArrayList<>());
            ropingtypeDTOList.add(ropingtypeDTOAux);
        });

        return ropingtypeDTOList;
    }

    public Page<RopingTypeDTO> paginationFull(Integer page, Integer pageSize, String sortBy, String direction, Map<String, Object> filterMap) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Page<RopingTypeDTO> ropingtypeDTOPage = null;

        Specification<RopingType> spec = (root, query, criteriaBuilder) -> {
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

        ropingtypeDTOPage = ropingtypeRepository
                .findAll(spec,
                        PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(direction), sortBy)))
                .map(x -> {
                    RopingTypeDTO ropingtypeDTOAux = new RopingTypeDTO();
                    utilBO.entityToDtoCustom(x, ropingtypeDTOAux, new ArrayList<>());
                    return ropingtypeDTOAux;
                });


        return ropingtypeDTOPage;
    }

}
