package br.cruzsilva.CruzSilva.bo;

import br.cruzsilva.CruzSilva.dto.RopingDTO;

import br.cruzsilva.CruzSilva.mapper.CycleAvoidingMappingContext;
import br.cruzsilva.CruzSilva.mapper.RopingMapper;
import br.cruzsilva.CruzSilva.model.masterDataBase.Roping;
import br.cruzsilva.CruzSilva.repository.masterDataBase.RopingRepository;
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
public class RopingBO {

    @Autowired
    UtilBO utilBO;

    @Autowired
    RopingRepository ropingRepository;

    @Autowired
    RopingMapper ropingMapper;

    public RopingDTO save(RopingDTO ropingDTO) throws IllegalAccessException {

        Roping roping = ropingMapper.toEntity(ropingDTO, new CycleAvoidingMappingContext());

        utilBO.assingObjectToList(roping, "roping");

        ropingRepository.save(roping);

        utilBO.entityToDtoCustom(roping, ropingDTO, new ArrayList<>());

        return ropingDTO;

    }

    public RopingDTO obtain(Long cdnRoping) {
        Roping roping = new Roping();

        roping = ropingRepository.getReferenceById(cdnRoping);

        RopingDTO ropingDTO = new RopingDTO(); //ropingMapper.toDto(roping, new CycleAvoidingMappingContext());

        utilBO.entityToDtoCustom(roping, ropingDTO, new ArrayList<>());

        return ropingDTO;
    }

    public void delete(Long cdnRoping) {
        Roping roping = new Roping(cdnRoping);
        utilBO.checkRelationship(roping,cdnRoping);
        ropingRepository.deleteById(cdnRoping);

    }

    public Page<RopingDTO> pagination(Integer page, Integer pageSize, String sortBy, String direction, Long filter) {

        Roping roping = new Roping();
        return ropingRepository
                .findAll(Example.of(roping),
                        PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(direction), sortBy)))
                .map(x -> {
                    RopingDTO ropingDTOAux = new RopingDTO();
                    utilBO.entityToDtoCustom(x, ropingDTOAux, new ArrayList<>());
                    return ropingDTOAux;
                });
    }

    public List<RopingDTO> listAll() {
        List<Roping> roping = new ArrayList<>();

        roping = ropingRepository.findAll();

        //List<RopingDTO> ropingDTO = ropingMapper.toDto(roping, new CycleAvoidingMappingContext());
        List<RopingDTO> ropingDTOList = new ArrayList<>();
        roping.forEach( t->{
            RopingDTO ropingDTOAux = new RopingDTO();
            utilBO.entityToDtoCustom(t, ropingDTOAux, new ArrayList<>());
            ropingDTOList.add(ropingDTOAux);
        });

        return ropingDTOList;
    }

    public Object listExample(RopingDTO ropingDTO) {
        List<Roping> roping = new ArrayList<>();

        Roping ropingExemple = ropingMapper.toEntity(ropingDTO, new CycleAvoidingMappingContext());

        roping = ropingRepository.findAll(Example.of(ropingExemple));

        List<RopingDTO> ropingDTOList = new ArrayList<>();
        roping.forEach( t->{
            RopingDTO ropingDTOAux = new RopingDTO();
            utilBO.entityToDtoCustom(t, ropingDTOAux, new ArrayList<>());
            ropingDTOList.add(ropingDTOAux);
        });

        return ropingDTOList;
    }

    public Page<RopingDTO> paginationFull(Integer page, Integer pageSize, String sortBy, String direction, Map<String, Object> filterMap) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Page<RopingDTO> ropingDTOPage = null;

        Specification<Roping> spec = (root, query, criteriaBuilder) -> {
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

        ropingDTOPage = ropingRepository
                .findAll(spec,
                        PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(direction), sortBy)))
                .map(x -> {
                    RopingDTO ropingDTOAux = new RopingDTO();
                    utilBO.entityToDtoCustom(x, ropingDTOAux, new ArrayList<>());
                    return ropingDTOAux;
                });


        return ropingDTOPage;
    }

}
