package br.cruzsilva.CruzSilva.bo;

import br.cruzsilva.CruzSilva.dto.BarrelTypeDTO;

import br.cruzsilva.CruzSilva.mapper.CycleAvoidingMappingContext;
import br.cruzsilva.CruzSilva.mapper.BarrelTypeMapper;
import br.cruzsilva.CruzSilva.model.masterDataBase.BarrelType;
import br.cruzsilva.CruzSilva.repository.masterDataBase.BarrelTypeRepository;
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
public class BarrelTypeBO {

    @Autowired
    UtilBO utilBO;

    @Autowired
    BarrelTypeRepository barreltypeRepository;

    @Autowired
    BarrelTypeMapper barreltypeMapper;

    public BarrelTypeDTO save(BarrelTypeDTO barreltypeDTO) throws IllegalAccessException {

        BarrelType barreltype = barreltypeMapper.toEntity(barreltypeDTO, new CycleAvoidingMappingContext());

        utilBO.assingObjectToList(barreltype, "barreltype");

        barreltypeRepository.save(barreltype);

        utilBO.entityToDtoCustom(barreltype, barreltypeDTO, new ArrayList<>());

        return barreltypeDTO;

    }

    public BarrelTypeDTO obtain(Long cdnBarrelType) {
        BarrelType barreltype = new BarrelType();

        barreltype = barreltypeRepository.getReferenceById(cdnBarrelType);

        BarrelTypeDTO barreltypeDTO = new BarrelTypeDTO(); //barreltypeMapper.toDto(barreltype, new CycleAvoidingMappingContext());

        utilBO.entityToDtoCustom(barreltype, barreltypeDTO, new ArrayList<>());

        return barreltypeDTO;
    }

    public void delete(Long cdnBarrelType) {
        BarrelType barreltype = new BarrelType(cdnBarrelType);
        utilBO.checkRelationship(barreltype,cdnBarrelType);
        barreltypeRepository.deleteById(cdnBarrelType);

    }

    public Page<BarrelTypeDTO> pagination(Integer page, Integer pageSize, String sortBy, String direction, Long filter) {

        BarrelType barreltype = new BarrelType();
        return barreltypeRepository
                .findAll(Example.of(barreltype),
                        PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(direction), sortBy)))
                .map(x -> {
                    BarrelTypeDTO barreltypeDTOAux = new BarrelTypeDTO();
                    utilBO.entityToDtoCustom(x, barreltypeDTOAux, new ArrayList<>());
                    return barreltypeDTOAux;
                });
    }

    public List<BarrelTypeDTO> listAll() {
        List<BarrelType> barreltype = new ArrayList<>();

        barreltype = barreltypeRepository.findAll();

        //List<BarrelTypeDTO> barreltypeDTO = barreltypeMapper.toDto(barreltype, new CycleAvoidingMappingContext());
        List<BarrelTypeDTO> barreltypeDTOList = new ArrayList<>();
        barreltype.forEach( t->{
            BarrelTypeDTO barreltypeDTOAux = new BarrelTypeDTO();
            utilBO.entityToDtoCustom(t, barreltypeDTOAux, new ArrayList<>());
            barreltypeDTOList.add(barreltypeDTOAux);
        });

        return barreltypeDTOList;
    }

    public Object listExample(BarrelTypeDTO barreltypeDTO) {
        List<BarrelType> barreltype = new ArrayList<>();

        BarrelType barreltypeExemple = barreltypeMapper.toEntity(barreltypeDTO, new CycleAvoidingMappingContext());

        barreltype = barreltypeRepository.findAll(Example.of(barreltypeExemple));

        List<BarrelTypeDTO> barreltypeDTOList = new ArrayList<>();
        barreltype.forEach( t->{
            BarrelTypeDTO barreltypeDTOAux = new BarrelTypeDTO();
            utilBO.entityToDtoCustom(t, barreltypeDTOAux, new ArrayList<>());
            barreltypeDTOList.add(barreltypeDTOAux);
        });

        return barreltypeDTOList;
    }

    public Page<BarrelTypeDTO> paginationFull(Integer page, Integer pageSize, String sortBy, String direction, Map<String, Object> filterMap) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Page<BarrelTypeDTO> barreltypeDTOPage = null;

        Specification<BarrelType> spec = (root, query, criteriaBuilder) -> {
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

        barreltypeDTOPage = barreltypeRepository
                .findAll(spec,
                        PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(direction), sortBy)))
                .map(x -> {
                    BarrelTypeDTO barreltypeDTOAux = new BarrelTypeDTO();
                    utilBO.entityToDtoCustom(x, barreltypeDTOAux, new ArrayList<>());
                    return barreltypeDTOAux;
                });


        return barreltypeDTOPage;
    }

}
