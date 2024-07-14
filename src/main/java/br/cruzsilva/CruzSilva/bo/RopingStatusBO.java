package br.cruzsilva.CruzSilva.bo;

import br.cruzsilva.CruzSilva.dto.RopingStatusDTO;

import br.cruzsilva.CruzSilva.mapper.CycleAvoidingMappingContext;
import br.cruzsilva.CruzSilva.mapper.RopingStatusMapper;
import br.cruzsilva.CruzSilva.model.masterDataBase.RopingStatus;
import br.cruzsilva.CruzSilva.repository.masterDataBase.RopingStatusRepository;
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
public class RopingStatusBO {

    @Autowired
    UtilBO utilBO;

    @Autowired
    RopingStatusRepository ropingstatusRepository;

    @Autowired
    RopingStatusMapper ropingstatusMapper;

    public RopingStatusDTO save(RopingStatusDTO ropingstatusDTO) throws IllegalAccessException {

        RopingStatus ropingstatus = ropingstatusMapper.toEntity(ropingstatusDTO, new CycleAvoidingMappingContext());

        utilBO.assingObjectToList(ropingstatus, "ropingstatus");

        ropingstatusRepository.save(ropingstatus);

        utilBO.entityToDtoCustom(ropingstatus, ropingstatusDTO, new ArrayList<>());

        return ropingstatusDTO;

    }

    public RopingStatusDTO obtain(Long cdnRopingStatus) {
        RopingStatus ropingstatus = new RopingStatus();

        ropingstatus = ropingstatusRepository.getReferenceById(cdnRopingStatus);

        RopingStatusDTO ropingstatusDTO = new RopingStatusDTO(); //ropingstatusMapper.toDto(ropingstatus, new CycleAvoidingMappingContext());

        utilBO.entityToDtoCustom(ropingstatus, ropingstatusDTO, new ArrayList<>());

        return ropingstatusDTO;
    }

    public void delete(Long cdnRopingStatus) {
        RopingStatus ropingstatus = new RopingStatus(cdnRopingStatus);
        utilBO.checkRelationship(ropingstatus,cdnRopingStatus);
        ropingstatusRepository.deleteById(cdnRopingStatus);

    }

    public Page<RopingStatusDTO> pagination(Integer page, Integer pageSize, String sortBy, String direction, Long filter) {

        RopingStatus ropingstatus = new RopingStatus();
        return ropingstatusRepository
                .findAll(Example.of(ropingstatus),
                        PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(direction), sortBy)))
                .map(x -> {
                    RopingStatusDTO ropingstatusDTOAux = new RopingStatusDTO();
                    utilBO.entityToDtoCustom(x, ropingstatusDTOAux, new ArrayList<>());
                    return ropingstatusDTOAux;
                });
    }

    public List<RopingStatusDTO> listAll() {
        List<RopingStatus> ropingstatus = new ArrayList<>();

        ropingstatus = ropingstatusRepository.findAll();

        //List<RopingStatusDTO> ropingstatusDTO = ropingstatusMapper.toDto(ropingstatus, new CycleAvoidingMappingContext());
        List<RopingStatusDTO> ropingstatusDTOList = new ArrayList<>();
        ropingstatus.forEach( t->{
            RopingStatusDTO ropingstatusDTOAux = new RopingStatusDTO();
            utilBO.entityToDtoCustom(t, ropingstatusDTOAux, new ArrayList<>());
            ropingstatusDTOList.add(ropingstatusDTOAux);
        });

        return ropingstatusDTOList;
    }

    public Object listExample(RopingStatusDTO ropingstatusDTO) {
        List<RopingStatus> ropingstatus = new ArrayList<>();

        RopingStatus ropingstatusExemple = ropingstatusMapper.toEntity(ropingstatusDTO, new CycleAvoidingMappingContext());

        ropingstatus = ropingstatusRepository.findAll(Example.of(ropingstatusExemple));

        List<RopingStatusDTO> ropingstatusDTOList = new ArrayList<>();
        ropingstatus.forEach( t->{
            RopingStatusDTO ropingstatusDTOAux = new RopingStatusDTO();
            utilBO.entityToDtoCustom(t, ropingstatusDTOAux, new ArrayList<>());
            ropingstatusDTOList.add(ropingstatusDTOAux);
        });

        return ropingstatusDTOList;
    }

    public Page<RopingStatusDTO> paginationFull(Integer page, Integer pageSize, String sortBy, String direction, Map<String, Object> filterMap) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Page<RopingStatusDTO> ropingstatusDTOPage = null;

        Specification<RopingStatus> spec = (root, query, criteriaBuilder) -> {
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

        ropingstatusDTOPage = ropingstatusRepository
                .findAll(spec,
                        PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(direction), sortBy)))
                .map(x -> {
                    RopingStatusDTO ropingstatusDTOAux = new RopingStatusDTO();
                    utilBO.entityToDtoCustom(x, ropingstatusDTOAux, new ArrayList<>());
                    return ropingstatusDTOAux;
                });


        return ropingstatusDTOPage;
    }

}
