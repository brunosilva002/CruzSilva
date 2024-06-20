package br.cruzsilva.CruzSilva.bo;

import br.cruzsilva.CruzSilva.dto.GenderDTO;

import br.cruzsilva.CruzSilva.mapper.CycleAvoidingMappingContext;
import br.cruzsilva.CruzSilva.mapper.GenderMapper;
import br.cruzsilva.CruzSilva.model.masterDataBase.Gender;
import br.cruzsilva.CruzSilva.repository.masterDataBase.GenderRepository;
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
public class GenderBO {

    @Autowired
    UtilBO utilBO;

    @Autowired
    GenderRepository genderRepository;

    @Autowired
    GenderMapper genderMapper;

    public GenderDTO save(GenderDTO genderDTO) throws IllegalAccessException {

        Gender gender = genderMapper.toEntity(genderDTO, new CycleAvoidingMappingContext());

        utilBO.assingObjectToList(gender, "gender");

        genderRepository.save(gender);

        utilBO.entityToDtoCustom(gender, genderDTO, new ArrayList<>());

        return genderDTO;

    }

    public GenderDTO obtain(Long cdnGender) {
        Gender gender = new Gender();

        gender = genderRepository.getReferenceById(cdnGender);

        GenderDTO genderDTO = new GenderDTO(); //genderMapper.toDto(gender, new CycleAvoidingMappingContext());

        utilBO.entityToDtoCustom(gender, genderDTO, new ArrayList<>());

        return genderDTO;
    }

    public void delete(Long cdnGender) {
        Gender gender = new Gender(cdnGender);
        utilBO.checkRelationship(gender,cdnGender);
        genderRepository.deleteById(cdnGender);

    }

    public Page<GenderDTO> pagination(Integer page, Integer pageSize, String sortBy, String direction, Long filter) {

        Gender gender = new Gender();
        return genderRepository
                .findAll(Example.of(gender),
                        PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(direction), sortBy)))
                .map(x -> {
                    GenderDTO genderDTOAux = new GenderDTO();
                    utilBO.entityToDtoCustom(x, genderDTOAux, new ArrayList<>());
                    return genderDTOAux;
                });
    }

    public List<GenderDTO> listAll() {
        List<Gender> gender = new ArrayList<>();

        gender = genderRepository.findAll();

        //List<GenderDTO> genderDTO = genderMapper.toDto(gender, new CycleAvoidingMappingContext());
        List<GenderDTO> genderDTOList = new ArrayList<>();
        gender.forEach( t->{
            GenderDTO genderDTOAux = new GenderDTO();
            utilBO.entityToDtoCustom(t, genderDTOAux, new ArrayList<>());
            genderDTOList.add(genderDTOAux);
        });

        return genderDTOList;
    }

    public Object listExample(GenderDTO genderDTO) {
        List<Gender> gender = new ArrayList<>();

        Gender genderExemple = genderMapper.toEntity(genderDTO, new CycleAvoidingMappingContext());

        gender = genderRepository.findAll(Example.of(genderExemple));

        List<GenderDTO> genderDTOList = new ArrayList<>();
        gender.forEach( t->{
            GenderDTO genderDTOAux = new GenderDTO();
            utilBO.entityToDtoCustom(t, genderDTOAux, new ArrayList<>());
            genderDTOList.add(genderDTOAux);
        });

        return genderDTOList;
    }

    public Page<GenderDTO> paginationFull(Integer page, Integer pageSize, String sortBy, String direction, Map<String, Object> filterMap) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Page<GenderDTO> genderDTOPage = null;

        Specification<Gender> spec = (root, query, criteriaBuilder) -> {
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

        genderDTOPage = genderRepository
                .findAll(spec,
                        PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(direction), sortBy)))
                .map(x -> {
                    GenderDTO genderDTOAux = new GenderDTO();
                    utilBO.entityToDtoCustom(x, genderDTOAux, new ArrayList<>());
                    return genderDTOAux;
                });


        return genderDTOPage;
    }

}
