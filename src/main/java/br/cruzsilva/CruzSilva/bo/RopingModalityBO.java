package br.cruzsilva.CruzSilva.bo;

import br.cruzsilva.CruzSilva.dto.RopingModalityDTO;

import br.cruzsilva.CruzSilva.mapper.CycleAvoidingMappingContext;
import br.cruzsilva.CruzSilva.mapper.RopingModalityMapper;
import br.cruzsilva.CruzSilva.model.masterDataBase.RopingModality;
import br.cruzsilva.CruzSilva.repository.masterDataBase.RopingModalityRepository;
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
public class RopingModalityBO {

    @Autowired
    UtilBO utilBO;

    @Autowired
    RopingModalityRepository ropingmodalityRepository;

    @Autowired
    RopingModalityMapper ropingmodalityMapper;

    public RopingModalityDTO save(RopingModalityDTO ropingmodalityDTO) throws IllegalAccessException {

        RopingModality ropingmodality = ropingmodalityMapper.toEntity(ropingmodalityDTO, new CycleAvoidingMappingContext());

        utilBO.assingObjectToList(ropingmodality, "ropingmodality");

        ropingmodalityRepository.save(ropingmodality);

        utilBO.entityToDtoCustom(ropingmodality, ropingmodalityDTO, new ArrayList<>());

        return ropingmodalityDTO;

    }

    public RopingModalityDTO obtain(Long cdnRopingModality) {
        RopingModality ropingmodality = new RopingModality();

        ropingmodality = ropingmodalityRepository.getReferenceById(cdnRopingModality);

        RopingModalityDTO ropingmodalityDTO = new RopingModalityDTO(); //ropingmodalityMapper.toDto(ropingmodality, new CycleAvoidingMappingContext());

        utilBO.entityToDtoCustom(ropingmodality, ropingmodalityDTO, new ArrayList<>());

        return ropingmodalityDTO;
    }

    public void delete(Long cdnRopingModality) {
        RopingModality ropingmodality = new RopingModality(cdnRopingModality);
        utilBO.checkRelationship(ropingmodality,cdnRopingModality);
        ropingmodalityRepository.deleteById(cdnRopingModality);

    }

    public Page<RopingModalityDTO> pagination(Integer page, Integer pageSize, String sortBy, String direction, Long filter) {

        RopingModality ropingmodality = new RopingModality();
        return ropingmodalityRepository
                .findAll(Example.of(ropingmodality),
                        PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(direction), sortBy)))
                .map(x -> {
                    RopingModalityDTO ropingmodalityDTOAux = new RopingModalityDTO();
                    utilBO.entityToDtoCustom(x, ropingmodalityDTOAux, new ArrayList<>());
                    return ropingmodalityDTOAux;
                });
    }

    public List<RopingModalityDTO> listAll() {
        List<RopingModality> ropingmodality = new ArrayList<>();

        ropingmodality = ropingmodalityRepository.findAll();

        //List<RopingModalityDTO> ropingmodalityDTO = ropingmodalityMapper.toDto(ropingmodality, new CycleAvoidingMappingContext());
        List<RopingModalityDTO> ropingmodalityDTOList = new ArrayList<>();
        ropingmodality.forEach( t->{
            RopingModalityDTO ropingmodalityDTOAux = new RopingModalityDTO();
            utilBO.entityToDtoCustom(t, ropingmodalityDTOAux, new ArrayList<>());
            ropingmodalityDTOList.add(ropingmodalityDTOAux);
        });

        return ropingmodalityDTOList;
    }

    public Object listExample(RopingModalityDTO ropingmodalityDTO) {
        List<RopingModality> ropingmodality = new ArrayList<>();

        RopingModality ropingmodalityExemple = ropingmodalityMapper.toEntity(ropingmodalityDTO, new CycleAvoidingMappingContext());

        ropingmodality = ropingmodalityRepository.findAll(Example.of(ropingmodalityExemple));

        List<RopingModalityDTO> ropingmodalityDTOList = new ArrayList<>();
        ropingmodality.forEach( t->{
            RopingModalityDTO ropingmodalityDTOAux = new RopingModalityDTO();
            utilBO.entityToDtoCustom(t, ropingmodalityDTOAux, new ArrayList<>());
            ropingmodalityDTOList.add(ropingmodalityDTOAux);
        });

        return ropingmodalityDTOList;
    }

    public Page<RopingModalityDTO> paginationFull(Integer page, Integer pageSize, String sortBy, String direction, Map<String, Object> filterMap) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Page<RopingModalityDTO> ropingmodalityDTOPage = null;

        Specification<RopingModality> spec = (root, query, criteriaBuilder) -> {
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

        ropingmodalityDTOPage = ropingmodalityRepository
                .findAll(spec,
                        PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(direction), sortBy)))
                .map(x -> {
                    RopingModalityDTO ropingmodalityDTOAux = new RopingModalityDTO();
                    utilBO.entityToDtoCustom(x, ropingmodalityDTOAux, new ArrayList<>());
                    return ropingmodalityDTOAux;
                });


        return ropingmodalityDTOPage;
    }

}
