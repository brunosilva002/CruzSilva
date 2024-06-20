package br.cruzsilva.CruzSilva.bo;

import br.cruzsilva.CruzSilva.dto.GenderAnimalDTO;

import br.cruzsilva.CruzSilva.mapper.CycleAvoidingMappingContext;
import br.cruzsilva.CruzSilva.mapper.GenderAnimalMapper;
import br.cruzsilva.CruzSilva.model.masterDataBase.GenderAnimal;
import br.cruzsilva.CruzSilva.repository.masterDataBase.GenderAnimalRepository;
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
public class GenderAnimalBO {

    @Autowired
    UtilBO utilBO;

    @Autowired
    GenderAnimalRepository genderanimalRepository;

    @Autowired
    GenderAnimalMapper genderanimalMapper;

    public GenderAnimalDTO save(GenderAnimalDTO genderanimalDTO) throws IllegalAccessException {

        GenderAnimal genderanimal = genderanimalMapper.toEntity(genderanimalDTO, new CycleAvoidingMappingContext());

        utilBO.assingObjectToList(genderanimal, "genderanimal");

        genderanimalRepository.save(genderanimal);

        utilBO.entityToDtoCustom(genderanimal, genderanimalDTO, new ArrayList<>());

        return genderanimalDTO;

    }

    public GenderAnimalDTO obtain(Long cdnGenderAnimal) {
        GenderAnimal genderanimal = new GenderAnimal();

        genderanimal = genderanimalRepository.getReferenceById(cdnGenderAnimal);

        GenderAnimalDTO genderanimalDTO = new GenderAnimalDTO(); //genderanimalMapper.toDto(genderanimal, new CycleAvoidingMappingContext());

        utilBO.entityToDtoCustom(genderanimal, genderanimalDTO, new ArrayList<>());

        return genderanimalDTO;
    }

    public void delete(Long cdnGenderAnimal) {
        GenderAnimal genderanimal = new GenderAnimal(cdnGenderAnimal);
        utilBO.checkRelationship(genderanimal,cdnGenderAnimal);
        genderanimalRepository.deleteById(cdnGenderAnimal);

    }

    public Page<GenderAnimalDTO> pagination(Integer page, Integer pageSize, String sortBy, String direction, Long filter) {

        GenderAnimal genderanimal = new GenderAnimal();
        return genderanimalRepository
                .findAll(Example.of(genderanimal),
                        PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(direction), sortBy)))
                .map(x -> {
                    GenderAnimalDTO genderanimalDTOAux = new GenderAnimalDTO();
                    utilBO.entityToDtoCustom(x, genderanimalDTOAux, new ArrayList<>());
                    return genderanimalDTOAux;
                });
    }

    public List<GenderAnimalDTO> listAll() {
        List<GenderAnimal> genderanimal = new ArrayList<>();

        genderanimal = genderanimalRepository.findAll();

        //List<GenderAnimalDTO> genderanimalDTO = genderanimalMapper.toDto(genderanimal, new CycleAvoidingMappingContext());
        List<GenderAnimalDTO> genderanimalDTOList = new ArrayList<>();
        genderanimal.forEach( t->{
            GenderAnimalDTO genderanimalDTOAux = new GenderAnimalDTO();
            utilBO.entityToDtoCustom(t, genderanimalDTOAux, new ArrayList<>());
            genderanimalDTOList.add(genderanimalDTOAux);
        });

        return genderanimalDTOList;
    }

    public Object listExample(GenderAnimalDTO genderanimalDTO) {
        List<GenderAnimal> genderanimal = new ArrayList<>();

        GenderAnimal genderanimalExemple = genderanimalMapper.toEntity(genderanimalDTO, new CycleAvoidingMappingContext());

        genderanimal = genderanimalRepository.findAll(Example.of(genderanimalExemple));

        List<GenderAnimalDTO> genderanimalDTOList = new ArrayList<>();
        genderanimal.forEach( t->{
            GenderAnimalDTO genderanimalDTOAux = new GenderAnimalDTO();
            utilBO.entityToDtoCustom(t, genderanimalDTOAux, new ArrayList<>());
            genderanimalDTOList.add(genderanimalDTOAux);
        });

        return genderanimalDTOList;
    }

    public Page<GenderAnimalDTO> paginationFull(Integer page, Integer pageSize, String sortBy, String direction, Map<String, Object> filterMap) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Page<GenderAnimalDTO> genderanimalDTOPage = null;

        Specification<GenderAnimal> spec = (root, query, criteriaBuilder) -> {
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

        genderanimalDTOPage = genderanimalRepository
                .findAll(spec,
                        PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(direction), sortBy)))
                .map(x -> {
                    GenderAnimalDTO genderanimalDTOAux = new GenderAnimalDTO();
                    utilBO.entityToDtoCustom(x, genderanimalDTOAux, new ArrayList<>());
                    return genderanimalDTOAux;
                });


        return genderanimalDTOPage;
    }

}
