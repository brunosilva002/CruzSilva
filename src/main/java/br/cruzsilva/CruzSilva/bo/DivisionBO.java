package br.cruzsilva.CruzSilva.bo;

import br.cruzsilva.CruzSilva.dto.DivisionDTO;

import br.cruzsilva.CruzSilva.mapper.CycleAvoidingMappingContext;
import br.cruzsilva.CruzSilva.mapper.DivisionMapper;
import br.cruzsilva.CruzSilva.model.masterDataBase.Division;
import br.cruzsilva.CruzSilva.repository.masterDataBase.DivisionRepository;
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
public class DivisionBO {

    @Autowired
    UtilBO utilBO;

    @Autowired
    DivisionRepository divisionRepository;

    @Autowired
    DivisionMapper divisionMapper;

    public DivisionDTO save(DivisionDTO divisionDTO) throws IllegalAccessException {

        Division division = divisionMapper.toEntity(divisionDTO, new CycleAvoidingMappingContext());

        utilBO.assingObjectToList(division, "division");

        divisionRepository.save(division);

        utilBO.entityToDtoCustom(division, divisionDTO, new ArrayList<>());

        return divisionDTO;

    }

    public DivisionDTO obtain(Long cdnDivision) {
        Division division = new Division();

        division = divisionRepository.getReferenceById(cdnDivision);

        DivisionDTO divisionDTO = new DivisionDTO(); //divisionMapper.toDto(division, new CycleAvoidingMappingContext());

        utilBO.entityToDtoCustom(division, divisionDTO, new ArrayList<>());

        return divisionDTO;
    }

    public void delete(Long cdnDivision) {
        Division division = new Division(cdnDivision);
        utilBO.checkRelationship(division,cdnDivision);
        divisionRepository.deleteById(cdnDivision);

    }

    public Page<DivisionDTO> pagination(Integer page, Integer pageSize, String sortBy, String direction, Long filter) {

        Division division = new Division();
        return divisionRepository
                .findAll(Example.of(division),
                        PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(direction), sortBy)))
                .map(x -> {
                    DivisionDTO divisionDTOAux = new DivisionDTO();
                    utilBO.entityToDtoCustom(x, divisionDTOAux, new ArrayList<>());
                    return divisionDTOAux;
                });
    }

    public List<DivisionDTO> listAll() {
        List<Division> division = new ArrayList<>();

        division = divisionRepository.findAll();

        //List<DivisionDTO> divisionDTO = divisionMapper.toDto(division, new CycleAvoidingMappingContext());
        List<DivisionDTO> divisionDTOList = new ArrayList<>();
        division.forEach( t->{
            DivisionDTO divisionDTOAux = new DivisionDTO();
            utilBO.entityToDtoCustom(t, divisionDTOAux, new ArrayList<>());
            divisionDTOList.add(divisionDTOAux);
        });

        return divisionDTOList;
    }

    public Object listExample(DivisionDTO divisionDTO) {
        List<Division> division = new ArrayList<>();

        Division divisionExemple = divisionMapper.toEntity(divisionDTO, new CycleAvoidingMappingContext());

        division = divisionRepository.findAll(Example.of(divisionExemple));

        List<DivisionDTO> divisionDTOList = new ArrayList<>();
        division.forEach( t->{
            DivisionDTO divisionDTOAux = new DivisionDTO();
            utilBO.entityToDtoCustom(t, divisionDTOAux, new ArrayList<>());
            divisionDTOList.add(divisionDTOAux);
        });

        return divisionDTOList;
    }

    public Page<DivisionDTO> paginationFull(Integer page, Integer pageSize, String sortBy, String direction, Map<String, Object> filterMap) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Page<DivisionDTO> divisionDTOPage = null;

        Specification<Division> spec = (root, query, criteriaBuilder) -> {
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

        divisionDTOPage = divisionRepository
                .findAll(spec,
                        PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(direction), sortBy)))
                .map(x -> {
                    DivisionDTO divisionDTOAux = new DivisionDTO();
                    utilBO.entityToDtoCustom(x, divisionDTOAux, new ArrayList<>());
                    return divisionDTOAux;
                });


        return divisionDTOPage;
    }

    public Object saveList(List<DivisionDTO> divisionDTO) {
        List<Division> divisionExemple = divisionMapper.toEntity(divisionDTO, new CycleAvoidingMappingContext());

       return divisionRepository.saveAll(divisionExemple);
    }
}
