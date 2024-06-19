package br.cruzsilva.CruzSilva.bo;

import br.cruzsilva.CruzSilva.dto.AnimalDTO;

import br.cruzsilva.CruzSilva.mapper.AnimalMapper;
import br.cruzsilva.CruzSilva.mapper.CycleAvoidingMappingContext;
import br.cruzsilva.CruzSilva.model.masterDataBase.Animal;
import br.cruzsilva.CruzSilva.repository.masterDataBase.AnimalRepository;
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
public class AnimalBO {

    @Autowired
    UtilBO utilBO;

    @Autowired
    AnimalRepository animalRepository;

    @Autowired
    AnimalMapper animalMapper;

    public AnimalDTO save(AnimalDTO animalDTO) throws IllegalAccessException {

        Animal animal = animalMapper.toEntity(animalDTO, new CycleAvoidingMappingContext());

        utilBO.assingObjectToList(animal, "animals");

        animalRepository.save(animal);

        utilBO.entityToDtoCustom(animal, animalDTO, new ArrayList<>());

        return animalDTO;

    }

    public AnimalDTO obtain(Long cdnAnimals) {
        Animal animal = new Animal();

        animal = animalRepository.getReferenceById(cdnAnimals);

        AnimalDTO animalDTO = new AnimalDTO(); //animalsMapper.toDto(animals, new CycleAvoidingMappingContext());

        utilBO.entityToDtoCustom(animal, animalDTO, new ArrayList<>());

        return animalDTO;
    }

    public void delete(Long cdnAnimals) {
        Animal animal = new Animal(cdnAnimals);
        utilBO.checkRelationship(animal,cdnAnimals);
        animalRepository.deleteById(cdnAnimals);

    }

    public Page<AnimalDTO> pagination(Integer page, Integer pageSize, String sortBy, String direction, Long filter) {

        Animal animal = new Animal();
        return animalRepository
                .findAll(Example.of(animal),
                        PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(direction), sortBy)))
                .map(x -> {
                    AnimalDTO animalDTOAux = new AnimalDTO();
                    utilBO.entityToDtoCustom(x, animalDTOAux, new ArrayList<>());
                    return animalDTOAux;
                });
    }

    public List<AnimalDTO> listAll() {
        List<Animal> animals = new ArrayList<>();

        animals = animalRepository.findAll();

        //List<AnimalsDTO> animalsDTO = animalsMapper.toDto(animals, new CycleAvoidingMappingContext());
        List<AnimalDTO> animalDTOList = new ArrayList<>();
        animals.forEach( t->{
            AnimalDTO animalDTOAux = new AnimalDTO();
            utilBO.entityToDtoCustom(t, animalDTOAux, new ArrayList<>());
            animalDTOList.add(animalDTOAux);
        });

        return animalDTOList;
    }

    public Object listExample(AnimalDTO animalDTO) {
        List<Animal> animals = new ArrayList<>();

        Animal animalExemple = animalMapper.toEntity(animalDTO, new CycleAvoidingMappingContext());

        animals = animalRepository.findAll(Example.of(animalExemple));

        List<AnimalDTO> animalDTOList = new ArrayList<>();
        animals.forEach( t->{
            AnimalDTO animalDTOAux = new AnimalDTO();
            utilBO.entityToDtoCustom(t, animalDTOAux, new ArrayList<>());
            animalDTOList.add(animalDTOAux);
        });

        return animalDTOList;
    }

    public Page<AnimalDTO> paginationFull(Integer page, Integer pageSize, String sortBy, String direction, Map<String, Object> filterMap) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Page<AnimalDTO> animalsDTOPage = null;

        Specification<Animal> spec = (root, query, criteriaBuilder) -> {
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

        animalsDTOPage = animalRepository
                .findAll(spec,
                        PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(direction), sortBy)))
                .map(x -> {
                    AnimalDTO animalDTOAux = new AnimalDTO();
                    utilBO.entityToDtoCustom(x, animalDTOAux, new ArrayList<>());
                    return animalDTOAux;
                });


        return animalsDTOPage;
    }

}
