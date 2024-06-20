package br.cruzsilva.CruzSilva.bo;

import br.cruzsilva.CruzSilva.dto.TypeClassificationTimeDTO;

import br.cruzsilva.CruzSilva.mapper.CycleAvoidingMappingContext;
import br.cruzsilva.CruzSilva.mapper.TypeClassificationTimeMapper;
import br.cruzsilva.CruzSilva.model.masterDataBase.TypeClassificationTime;
import br.cruzsilva.CruzSilva.repository.masterDataBase.TypeClassificationTimeRepository;
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
public class TypeClassificationTimeBO {

    @Autowired
    UtilBO utilBO;

    @Autowired
    TypeClassificationTimeRepository typeclassificationtimeRepository;

    @Autowired
    TypeClassificationTimeMapper typeclassificationtimeMapper;

    public TypeClassificationTimeDTO save(TypeClassificationTimeDTO typeclassificationtimeDTO) throws IllegalAccessException {

        TypeClassificationTime typeclassificationtime = typeclassificationtimeMapper.toEntity(typeclassificationtimeDTO, new CycleAvoidingMappingContext());

        utilBO.assingObjectToList(typeclassificationtime, "typeclassificationtime");

        typeclassificationtimeRepository.save(typeclassificationtime);

        utilBO.entityToDtoCustom(typeclassificationtime, typeclassificationtimeDTO, new ArrayList<>());

        return typeclassificationtimeDTO;

    }

    public TypeClassificationTimeDTO obtain(Long cdnTypeClassificationTime) {
        TypeClassificationTime typeclassificationtime = new TypeClassificationTime();

        typeclassificationtime = typeclassificationtimeRepository.getReferenceById(cdnTypeClassificationTime);

        TypeClassificationTimeDTO typeclassificationtimeDTO = new TypeClassificationTimeDTO(); //typeclassificationtimeMapper.toDto(typeclassificationtime, new CycleAvoidingMappingContext());

        utilBO.entityToDtoCustom(typeclassificationtime, typeclassificationtimeDTO, new ArrayList<>());

        return typeclassificationtimeDTO;
    }

    public void delete(Long cdnTypeClassificationTime) {
        TypeClassificationTime typeclassificationtime = new TypeClassificationTime(cdnTypeClassificationTime);
        utilBO.checkRelationship(typeclassificationtime,cdnTypeClassificationTime);
        typeclassificationtimeRepository.deleteById(cdnTypeClassificationTime);

    }

    public Page<TypeClassificationTimeDTO> pagination(Integer page, Integer pageSize, String sortBy, String direction, Long filter) {

        TypeClassificationTime typeclassificationtime = new TypeClassificationTime();
        return typeclassificationtimeRepository
                .findAll(Example.of(typeclassificationtime),
                        PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(direction), sortBy)))
                .map(x -> {
                    TypeClassificationTimeDTO typeclassificationtimeDTOAux = new TypeClassificationTimeDTO();
                    utilBO.entityToDtoCustom(x, typeclassificationtimeDTOAux, new ArrayList<>());
                    return typeclassificationtimeDTOAux;
                });
    }

    public List<TypeClassificationTimeDTO> listAll() {
        List<TypeClassificationTime> typeclassificationtime = new ArrayList<>();

        typeclassificationtime = typeclassificationtimeRepository.findAll();

        //List<TypeClassificationTimeDTO> typeclassificationtimeDTO = typeclassificationtimeMapper.toDto(typeclassificationtime, new CycleAvoidingMappingContext());
        List<TypeClassificationTimeDTO> typeclassificationtimeDTOList = new ArrayList<>();
        typeclassificationtime.forEach( t->{
            TypeClassificationTimeDTO typeclassificationtimeDTOAux = new TypeClassificationTimeDTO();
            utilBO.entityToDtoCustom(t, typeclassificationtimeDTOAux, new ArrayList<>());
            typeclassificationtimeDTOList.add(typeclassificationtimeDTOAux);
        });

        return typeclassificationtimeDTOList;
    }

    public Object listExample(TypeClassificationTimeDTO typeclassificationtimeDTO) {
        List<TypeClassificationTime> typeclassificationtime = new ArrayList<>();

        TypeClassificationTime typeclassificationtimeExemple = typeclassificationtimeMapper.toEntity(typeclassificationtimeDTO, new CycleAvoidingMappingContext());

        typeclassificationtime = typeclassificationtimeRepository.findAll(Example.of(typeclassificationtimeExemple));

        List<TypeClassificationTimeDTO> typeclassificationtimeDTOList = new ArrayList<>();
        typeclassificationtime.forEach( t->{
            TypeClassificationTimeDTO typeclassificationtimeDTOAux = new TypeClassificationTimeDTO();
            utilBO.entityToDtoCustom(t, typeclassificationtimeDTOAux, new ArrayList<>());
            typeclassificationtimeDTOList.add(typeclassificationtimeDTOAux);
        });

        return typeclassificationtimeDTOList;
    }

    public Page<TypeClassificationTimeDTO> paginationFull(Integer page, Integer pageSize, String sortBy, String direction, Map<String, Object> filterMap) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Page<TypeClassificationTimeDTO> typeclassificationtimeDTOPage = null;

        Specification<TypeClassificationTime> spec = (root, query, criteriaBuilder) -> {
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

        typeclassificationtimeDTOPage = typeclassificationtimeRepository
                .findAll(spec,
                        PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(direction), sortBy)))
                .map(x -> {
                    TypeClassificationTimeDTO typeclassificationtimeDTOAux = new TypeClassificationTimeDTO();
                    utilBO.entityToDtoCustom(x, typeclassificationtimeDTOAux, new ArrayList<>());
                    return typeclassificationtimeDTOAux;
                });


        return typeclassificationtimeDTOPage;
    }

}
