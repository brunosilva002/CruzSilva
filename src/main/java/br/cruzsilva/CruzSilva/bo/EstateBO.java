package br.cruzsilva.CruzSilva.bo;

import br.cruzsilva.CruzSilva.dto.EstateDTO;

import br.cruzsilva.CruzSilva.mapper.CycleAvoidingMappingContext;
import br.cruzsilva.CruzSilva.mapper.EstateMapper;
import br.cruzsilva.CruzSilva.model.masterDataBase.Estate;
import br.cruzsilva.CruzSilva.repository.masterDataBase.EstateRepository;
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
public class EstateBO {

    @Autowired
    UtilBO utilBO;

    @Autowired
    EstateRepository estateRepository;

    @Autowired
    EstateMapper estateMapper;

    public EstateDTO save(EstateDTO estateDTO) throws IllegalAccessException {

        Estate estate = estateMapper.toEntity(estateDTO, new CycleAvoidingMappingContext());

        utilBO.assingObjectToList(estate, "estate");

        estateRepository.save(estate);

        utilBO.entityToDtoCustom(estate, estateDTO, new ArrayList<>());

        return estateDTO;

    }

    public EstateDTO obtain(Long cdnEstate) {
        Estate estate = new Estate();

        estate = estateRepository.getReferenceById(cdnEstate);

        EstateDTO estateDTO = new EstateDTO(); //estateMapper.toDto(estate, new CycleAvoidingMappingContext());

        utilBO.entityToDtoCustom(estate, estateDTO, new ArrayList<>());

        return estateDTO;
    }

    public void delete(Long cdnEstate) {
        Estate estate = new Estate(cdnEstate);
        utilBO.checkRelationship(estate,cdnEstate);
        estateRepository.deleteById(cdnEstate);

    }

    public Page<EstateDTO> pagination(Integer page, Integer pageSize, String sortBy, String direction, Long filter) {

        Estate estate = new Estate();
        return estateRepository
                .findAll(Example.of(estate),
                        PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(direction), sortBy)))
                .map(x -> {
                    EstateDTO estateDTOAux = new EstateDTO();
                    utilBO.entityToDtoCustom(x, estateDTOAux, new ArrayList<>());
                    return estateDTOAux;
                });
    }

    public List<EstateDTO> listAll() {
        List<Estate> estate = new ArrayList<>();

        estate = estateRepository.findAll();

        //List<EstateDTO> estateDTO = estateMapper.toDto(estate, new CycleAvoidingMappingContext());
        List<EstateDTO> estateDTOList = new ArrayList<>();
        estate.forEach( t->{
            EstateDTO estateDTOAux = new EstateDTO();
            utilBO.entityToDtoCustom(t, estateDTOAux, new ArrayList<>());
            estateDTOList.add(estateDTOAux);
        });

        return estateDTOList;
    }

    public Object listExample(EstateDTO estateDTO) {
        List<Estate> estate = new ArrayList<>();

        Estate estateExemple = estateMapper.toEntity(estateDTO, new CycleAvoidingMappingContext());

        estate = estateRepository.findAll(Example.of(estateExemple));

        List<EstateDTO> estateDTOList = new ArrayList<>();
        estate.forEach( t->{
            EstateDTO estateDTOAux = new EstateDTO();
            utilBO.entityToDtoCustom(t, estateDTOAux, new ArrayList<>());
            estateDTOList.add(estateDTOAux);
        });

        return estateDTOList;
    }

    public Page<EstateDTO> paginationFull(Integer page, Integer pageSize, String sortBy, String direction, Map<String, Object> filterMap) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Page<EstateDTO> estateDTOPage = null;

        Specification<Estate> spec = (root, query, criteriaBuilder) -> {
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

        estateDTOPage = estateRepository
                .findAll(spec,
                        PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(direction), sortBy)))
                .map(x -> {
                    EstateDTO estateDTOAux = new EstateDTO();
                    utilBO.entityToDtoCustom(x, estateDTOAux, new ArrayList<>());
                    return estateDTOAux;
                });


        return estateDTOPage;
    }

}
