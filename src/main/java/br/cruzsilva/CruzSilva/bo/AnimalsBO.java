package br.cruzsilva.CruzSilva.bo;

import br.cruzsilva.CruzSilva.dto.AnimalsDTO;

import br.cruzsilva.CruzSilva.mapper.CycleAvoidingMappingContext;
import br.cruzsilva.CruzSilva.mapper.AnimalsMapper;
import br.cruzsilva.CruzSilva.model.masterDataBase.Animals;
import br.cruzsilva.CruzSilva.repository.masterDataBase.AnimalsRepository;
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
public class AnimalsBO {

    @Autowired
    UtilBO utilBO;

    @Autowired
    AnimalsRepository animalsRepository;

    @Autowired
    AnimalsMapper animalsMapper;

    public AnimalsDTO save(AnimalsDTO animalsDTO) throws IllegalAccessException {

        Animals animals = animalsMapper.toEntity(animalsDTO, new CycleAvoidingMappingContext());

        utilBO.assingObjectToList(animals, "animals");

        animalsRepository.save(animals);

        utilBO.entityToDtoCustom(animals, animalsDTO, new ArrayList<>());

        return animalsDTO;

    }

    public AnimalsDTO obtain(Long cdnAnimals) {
        Animals animals = new Animals();

        animals = animalsRepository.getReferenceById(cdnAnimals);

        AnimalsDTO animalsDTO = new AnimalsDTO(); //animalsMapper.toDto(animals, new CycleAvoidingMappingContext());

        utilBO.entityToDtoCustom(animals, animalsDTO, new ArrayList<>());

        return animalsDTO;
    }

    public void delete(Long cdnAnimals) {
        Animals animals = new Animals(cdnAnimals);
        utilBO.checkRelationship(animals,cdnAnimals);
        animalsRepository.deleteById(cdnAnimals);

    }

    public Page<AnimalsDTO> pagination(Integer page, Integer pageSize, String sortBy, String direction, Long filter) {

        Animals animals = new Animals();
        return animalsRepository
                .findAll(Example.of(animals),
                        PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(direction), sortBy)))
                .map(x -> {
                    AnimalsDTO animalsDTOAux = new AnimalsDTO();
                    utilBO.entityToDtoCustom(x, animalsDTOAux, new ArrayList<>());
                    return animalsDTOAux;
                });
    }

    public List<AnimalsDTO> listAll() {
        List<Animals> animals = new ArrayList<>();

        animals = animalsRepository.findAll();

        //List<AnimalsDTO> animalsDTO = animalsMapper.toDto(animals, new CycleAvoidingMappingContext());
        List<AnimalsDTO> animalsDTOList = new ArrayList<>();
        animals.forEach( t->{
            AnimalsDTO animalsDTOAux = new AnimalsDTO();
            utilBO.entityToDtoCustom(t, animalsDTOAux, new ArrayList<>());
            animalsDTOList.add(animalsDTOAux);
        });

        return animalsDTOList;
    }

    public Object listExample(AnimalsDTO animalsDTO) {
        List<Animals> animals = new ArrayList<>();

        Animals animalsExemple = animalsMapper.toEntity(animalsDTO, new CycleAvoidingMappingContext());

        animals = animalsRepository.findAll(Example.of(animalsExemple));

        List<AnimalsDTO> animalsDTOList = new ArrayList<>();
        animals.forEach( t->{
            AnimalsDTO animalsDTOAux = new AnimalsDTO();
            utilBO.entityToDtoCustom(t, animalsDTOAux, new ArrayList<>());
            animalsDTOList.add(animalsDTOAux);
        });

        return animalsDTOList;
    }

    public Page<AnimalsDTO> paginationFull(Integer page, Integer pageSize, String sortBy, String direction, Map<String, Object> filterMap) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Page<AnimalsDTO> animalsDTOPage = null;

        Specification<Animals> spec = (root, query, criteriaBuilder) -> {
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

        animalsDTOPage = animalsRepository
                .findAll(spec,
                        PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(direction), sortBy)))
                .map(x -> {
                    AnimalsDTO animalsDTOAux = new AnimalsDTO();
                    utilBO.entityToDtoCustom(x, animalsDTOAux, new ArrayList<>());
                    return animalsDTOAux;
                });


        return animalsDTOPage;
    }

}
