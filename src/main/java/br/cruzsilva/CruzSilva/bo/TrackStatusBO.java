package br.cruzsilva.CruzSilva.bo;

import br.cruzsilva.CruzSilva.dto.TrackStatusDTO;

import br.cruzsilva.CruzSilva.mapper.CycleAvoidingMappingContext;
import br.cruzsilva.CruzSilva.mapper.TrackStatusMapper;
import br.cruzsilva.CruzSilva.model.masterDataBase.TrackStatus;
import br.cruzsilva.CruzSilva.repository.masterDataBase.TrackStatusRepository;
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
public class TrackStatusBO {

    @Autowired
    UtilBO utilBO;

    @Autowired
    TrackStatusRepository trackstatusRepository;

    @Autowired
    TrackStatusMapper trackstatusMapper;

    public TrackStatusDTO save(TrackStatusDTO trackstatusDTO) throws IllegalAccessException {

        TrackStatus trackstatus = trackstatusMapper.toEntity(trackstatusDTO, new CycleAvoidingMappingContext());

        utilBO.assingObjectToList(trackstatus, "trackstatus");

        trackstatusRepository.save(trackstatus);

        utilBO.entityToDtoCustom(trackstatus, trackstatusDTO, new ArrayList<>());

        return trackstatusDTO;

    }

    public TrackStatusDTO obtain(Long cdnTrackStatus) {
        TrackStatus trackstatus = new TrackStatus();

        trackstatus = trackstatusRepository.getReferenceById(cdnTrackStatus);

        TrackStatusDTO trackstatusDTO = new TrackStatusDTO(); //trackstatusMapper.toDto(trackstatus, new CycleAvoidingMappingContext());

        utilBO.entityToDtoCustom(trackstatus, trackstatusDTO, new ArrayList<>());

        return trackstatusDTO;
    }

    public void delete(Long cdnTrackStatus) {
        TrackStatus trackstatus = new TrackStatus(cdnTrackStatus);
        utilBO.checkRelationship(trackstatus,cdnTrackStatus);
        trackstatusRepository.deleteById(cdnTrackStatus);

    }

    public Page<TrackStatusDTO> pagination(Integer page, Integer pageSize, String sortBy, String direction, Long filter) {

        TrackStatus trackstatus = new TrackStatus();
        return trackstatusRepository
                .findAll(Example.of(trackstatus),
                        PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(direction), sortBy)))
                .map(x -> {
                    TrackStatusDTO trackstatusDTOAux = new TrackStatusDTO();
                    utilBO.entityToDtoCustom(x, trackstatusDTOAux, new ArrayList<>());
                    return trackstatusDTOAux;
                });
    }

    public List<TrackStatusDTO> listAll() {
        List<TrackStatus> trackstatus = new ArrayList<>();

        trackstatus = trackstatusRepository.findAll();

        //List<TrackStatusDTO> trackstatusDTO = trackstatusMapper.toDto(trackstatus, new CycleAvoidingMappingContext());
        List<TrackStatusDTO> trackstatusDTOList = new ArrayList<>();
        trackstatus.forEach( t->{
            TrackStatusDTO trackstatusDTOAux = new TrackStatusDTO();
            utilBO.entityToDtoCustom(t, trackstatusDTOAux, new ArrayList<>());
            trackstatusDTOList.add(trackstatusDTOAux);
        });

        return trackstatusDTOList;
    }

    public Object listExample(TrackStatusDTO trackstatusDTO) {
        List<TrackStatus> trackstatus = new ArrayList<>();

        TrackStatus trackstatusExemple = trackstatusMapper.toEntity(trackstatusDTO, new CycleAvoidingMappingContext());

        trackstatus = trackstatusRepository.findAll(Example.of(trackstatusExemple));

        List<TrackStatusDTO> trackstatusDTOList = new ArrayList<>();
        trackstatus.forEach( t->{
            TrackStatusDTO trackstatusDTOAux = new TrackStatusDTO();
            utilBO.entityToDtoCustom(t, trackstatusDTOAux, new ArrayList<>());
            trackstatusDTOList.add(trackstatusDTOAux);
        });

        return trackstatusDTOList;
    }

    public Page<TrackStatusDTO> paginationFull(Integer page, Integer pageSize, String sortBy, String direction, Map<String, Object> filterMap) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Page<TrackStatusDTO> trackstatusDTOPage = null;

        Specification<TrackStatus> spec = (root, query, criteriaBuilder) -> {
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

        trackstatusDTOPage = trackstatusRepository
                .findAll(spec,
                        PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(direction), sortBy)))
                .map(x -> {
                    TrackStatusDTO trackstatusDTOAux = new TrackStatusDTO();
                    utilBO.entityToDtoCustom(x, trackstatusDTOAux, new ArrayList<>());
                    return trackstatusDTOAux;
                });


        return trackstatusDTOPage;
    }

}
