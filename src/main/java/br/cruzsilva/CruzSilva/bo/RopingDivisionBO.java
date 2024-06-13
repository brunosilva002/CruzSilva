package br.cruzsilva.CruzSilva.bo;

import br.cruzsilva.CruzSilva.dto.RopingDivisionDTO;

import br.cruzsilva.CruzSilva.mapper.CycleAvoidingMappingContext;
import br.cruzsilva.CruzSilva.mapper.RopingDivisionMapper;
import br.cruzsilva.CruzSilva.model.masterDataBase.RopingDivision;
import br.cruzsilva.CruzSilva.repository.masterDataBase.RopingDivisionRepository;
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
public class RopingDivisionBO {

    @Autowired
    UtilBO utilBO;

    @Autowired
    RopingDivisionRepository ropingdivisionRepository;

    @Autowired
    RopingDivisionMapper ropingdivisionMapper;

    public RopingDivisionDTO save(RopingDivisionDTO ropingdivisionDTO) throws IllegalAccessException {

        RopingDivision ropingdivision = ropingdivisionMapper.toEntity(ropingdivisionDTO, new CycleAvoidingMappingContext());

        utilBO.assingObjectToList(ropingdivision, "ropingdivision");

        ropingdivisionRepository.save(ropingdivision);

        utilBO.entityToDtoCustom(ropingdivision, ropingdivisionDTO, new ArrayList<>());

        return ropingdivisionDTO;

    }

    public RopingDivisionDTO obtain(Long cdnRopingDivision) {
        RopingDivision ropingdivision = new RopingDivision();

        ropingdivision = ropingdivisionRepository.getReferenceById(cdnRopingDivision);

        RopingDivisionDTO ropingdivisionDTO = new RopingDivisionDTO(); //ropingdivisionMapper.toDto(ropingdivision, new CycleAvoidingMappingContext());

        utilBO.entityToDtoCustom(ropingdivision, ropingdivisionDTO, new ArrayList<>());

        return ropingdivisionDTO;
    }

    public void delete(Long cdnRopingDivision) {
        RopingDivision ropingdivision = new RopingDivision(cdnRopingDivision);
        utilBO.checkRelationship(ropingdivision,cdnRopingDivision);
        ropingdivisionRepository.deleteById(cdnRopingDivision);

    }

    public Page<RopingDivisionDTO> pagination(Integer page, Integer pageSize, String sortBy, String direction, Long filter) {

        RopingDivision ropingdivision = new RopingDivision();
        return ropingdivisionRepository
                .findAll(Example.of(ropingdivision),
                        PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(direction), sortBy)))
                .map(x -> {
                    RopingDivisionDTO ropingdivisionDTOAux = new RopingDivisionDTO();
                    utilBO.entityToDtoCustom(x, ropingdivisionDTOAux, new ArrayList<>());
                    return ropingdivisionDTOAux;
                });
    }

    public List<RopingDivisionDTO> listAll() {
        List<RopingDivision> ropingdivision = new ArrayList<>();

        ropingdivision = ropingdivisionRepository.findAll();

        //List<RopingDivisionDTO> ropingdivisionDTO = ropingdivisionMapper.toDto(ropingdivision, new CycleAvoidingMappingContext());
        List<RopingDivisionDTO> ropingdivisionDTOList = new ArrayList<>();
        ropingdivision.forEach( t->{
            RopingDivisionDTO ropingdivisionDTOAux = new RopingDivisionDTO();
            utilBO.entityToDtoCustom(t, ropingdivisionDTOAux, new ArrayList<>());
            ropingdivisionDTOList.add(ropingdivisionDTOAux);
        });

        return ropingdivisionDTOList;
    }

    public Object listExample(RopingDivisionDTO ropingdivisionDTO) {
        List<RopingDivision> ropingdivision = new ArrayList<>();

        RopingDivision ropingdivisionExemple = ropingdivisionMapper.toEntity(ropingdivisionDTO, new CycleAvoidingMappingContext());

        ropingdivision = ropingdivisionRepository.findAll(Example.of(ropingdivisionExemple));

        List<RopingDivisionDTO> ropingdivisionDTOList = new ArrayList<>();
        ropingdivision.forEach( t->{
            RopingDivisionDTO ropingdivisionDTOAux = new RopingDivisionDTO();
            utilBO.entityToDtoCustom(t, ropingdivisionDTOAux, new ArrayList<>());
            ropingdivisionDTOList.add(ropingdivisionDTOAux);
        });

        return ropingdivisionDTOList;
    }

    public Page<RopingDivisionDTO> paginationFull(Integer page, Integer pageSize, String sortBy, String direction, Map<String, Object> filterMap) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Page<RopingDivisionDTO> ropingdivisionDTOPage = null;

        Specification<RopingDivision> spec = (root, query, criteriaBuilder) -> {
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

        ropingdivisionDTOPage = ropingdivisionRepository
                .findAll(spec,
                        PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(direction), sortBy)))
                .map(x -> {
                    RopingDivisionDTO ropingdivisionDTOAux = new RopingDivisionDTO();
                    utilBO.entityToDtoCustom(x, ropingdivisionDTOAux, new ArrayList<>());
                    return ropingdivisionDTOAux;
                });


        return ropingdivisionDTOPage;
    }

}
