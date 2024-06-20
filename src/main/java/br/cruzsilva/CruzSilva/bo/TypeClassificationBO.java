package br.cruzsilva.CruzSilva.bo;

import br.cruzsilva.CruzSilva.dto.TypeClassificationDTO;

import br.cruzsilva.CruzSilva.mapper.CycleAvoidingMappingContext;
import br.cruzsilva.CruzSilva.mapper.TypeClassificationMapper;
import br.cruzsilva.CruzSilva.model.masterDataBase.TypeClassification;
import br.cruzsilva.CruzSilva.repository.masterDataBase.TypeClassificationRepository;
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
public class TypeClassificationBO {

    @Autowired
    UtilBO utilBO;

    @Autowired
    TypeClassificationRepository typeclassificationRepository;

    @Autowired
    TypeClassificationMapper typeclassificationMapper;

    public TypeClassificationDTO save(TypeClassificationDTO typeclassificationDTO) throws IllegalAccessException {

        TypeClassification typeclassification = typeclassificationMapper.toEntity(typeclassificationDTO, new CycleAvoidingMappingContext());

        utilBO.assingObjectToList(typeclassification, "typeclassification");

        typeclassificationRepository.save(typeclassification);

        utilBO.entityToDtoCustom(typeclassification, typeclassificationDTO, new ArrayList<>());

        return typeclassificationDTO;

    }

    public TypeClassificationDTO obtain(Long cdnTypeClassification) {
        TypeClassification typeclassification = new TypeClassification();

        typeclassification = typeclassificationRepository.getReferenceById(cdnTypeClassification);

        TypeClassificationDTO typeclassificationDTO = new TypeClassificationDTO(); //typeclassificationMapper.toDto(typeclassification, new CycleAvoidingMappingContext());

        utilBO.entityToDtoCustom(typeclassification, typeclassificationDTO, new ArrayList<>());

        return typeclassificationDTO;
    }

    public void delete(Long cdnTypeClassification) {
        TypeClassification typeclassification = new TypeClassification(cdnTypeClassification);
        utilBO.checkRelationship(typeclassification,cdnTypeClassification);
        typeclassificationRepository.deleteById(cdnTypeClassification);

    }

    public Page<TypeClassificationDTO> pagination(Integer page, Integer pageSize, String sortBy, String direction, Long filter) {

        TypeClassification typeclassification = new TypeClassification();
        return typeclassificationRepository
                .findAll(Example.of(typeclassification),
                        PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(direction), sortBy)))
                .map(x -> {
                    TypeClassificationDTO typeclassificationDTOAux = new TypeClassificationDTO();
                    utilBO.entityToDtoCustom(x, typeclassificationDTOAux, new ArrayList<>());
                    return typeclassificationDTOAux;
                });
    }

    public List<TypeClassificationDTO> listAll() {
        List<TypeClassification> typeclassification = new ArrayList<>();

        typeclassification = typeclassificationRepository.findAll();

        //List<TypeClassificationDTO> typeclassificationDTO = typeclassificationMapper.toDto(typeclassification, new CycleAvoidingMappingContext());
        List<TypeClassificationDTO> typeclassificationDTOList = new ArrayList<>();
        typeclassification.forEach( t->{
            TypeClassificationDTO typeclassificationDTOAux = new TypeClassificationDTO();
            utilBO.entityToDtoCustom(t, typeclassificationDTOAux, new ArrayList<>());
            typeclassificationDTOList.add(typeclassificationDTOAux);
        });

        return typeclassificationDTOList;
    }

    public Object listExample(TypeClassificationDTO typeclassificationDTO) {
        List<TypeClassification> typeclassification = new ArrayList<>();

        TypeClassification typeclassificationExemple = typeclassificationMapper.toEntity(typeclassificationDTO, new CycleAvoidingMappingContext());

        typeclassification = typeclassificationRepository.findAll(Example.of(typeclassificationExemple));

        List<TypeClassificationDTO> typeclassificationDTOList = new ArrayList<>();
        typeclassification.forEach( t->{
            TypeClassificationDTO typeclassificationDTOAux = new TypeClassificationDTO();
            utilBO.entityToDtoCustom(t, typeclassificationDTOAux, new ArrayList<>());
            typeclassificationDTOList.add(typeclassificationDTOAux);
        });

        return typeclassificationDTOList;
    }

    public Page<TypeClassificationDTO> paginationFull(Integer page, Integer pageSize, String sortBy, String direction, Map<String, Object> filterMap) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Page<TypeClassificationDTO> typeclassificationDTOPage = null;

        Specification<TypeClassification> spec = (root, query, criteriaBuilder) -> {
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

        typeclassificationDTOPage = typeclassificationRepository
                .findAll(spec,
                        PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(direction), sortBy)))
                .map(x -> {
                    TypeClassificationDTO typeclassificationDTOAux = new TypeClassificationDTO();
                    utilBO.entityToDtoCustom(x, typeclassificationDTOAux, new ArrayList<>());
                    return typeclassificationDTOAux;
                });


        return typeclassificationDTOPage;
    }

}
