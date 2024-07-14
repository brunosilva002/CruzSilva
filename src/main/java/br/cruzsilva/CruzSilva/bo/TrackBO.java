package br.cruzsilva.CruzSilva.bo;

import br.cruzsilva.CruzSilva.dto.TrackDTO;

import br.cruzsilva.CruzSilva.mapper.CycleAvoidingMappingContext;
import br.cruzsilva.CruzSilva.mapper.TrackMapper;
import br.cruzsilva.CruzSilva.model.masterDataBase.Track;
import br.cruzsilva.CruzSilva.repository.masterDataBase.TrackRepository;
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
public class TrackBO {

    @Autowired
    UtilBO utilBO;

    @Autowired
    TrackRepository trackRepository;

    @Autowired
    TrackMapper trackMapper;

    public TrackDTO save(TrackDTO trackDTO) throws IllegalAccessException {

        Track track = trackMapper.toEntity(trackDTO, new CycleAvoidingMappingContext());

        utilBO.assingObjectToList(track, "track");

        trackRepository.save(track);

        utilBO.entityToDtoCustom(track, trackDTO, new ArrayList<>());

        return trackDTO;

    }

    public TrackDTO obtain(Long cdnTrack) {
        Track track = new Track();

        track = trackRepository.getReferenceById(cdnTrack);

        TrackDTO trackDTO = new TrackDTO(); //trackMapper.toDto(track, new CycleAvoidingMappingContext());

        utilBO.entityToDtoCustom(track, trackDTO, new ArrayList<>());

        return trackDTO;
    }

    public void delete(Long cdnTrack) {
        Track track = new Track(cdnTrack);
        utilBO.checkRelationship(track,cdnTrack);
        trackRepository.deleteById(cdnTrack);

    }

    public Page<TrackDTO> pagination(Integer page, Integer pageSize, String sortBy, String direction, Long filter) {

        Track track = new Track();
        return trackRepository
                .findAll(Example.of(track),
                        PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(direction), sortBy)))
                .map(x -> {
                    TrackDTO trackDTOAux = new TrackDTO();
                    utilBO.entityToDtoCustom(x, trackDTOAux, new ArrayList<>());
                    return trackDTOAux;
                });
    }

    public List<TrackDTO> listAll() {
        List<Track> track = new ArrayList<>();

        track = trackRepository.findAll();

        //List<TrackDTO> trackDTO = trackMapper.toDto(track, new CycleAvoidingMappingContext());
        List<TrackDTO> trackDTOList = new ArrayList<>();
        track.forEach( t->{
            TrackDTO trackDTOAux = new TrackDTO();
            utilBO.entityToDtoCustom(t, trackDTOAux, new ArrayList<>());
            trackDTOList.add(trackDTOAux);
        });

        return trackDTOList;
    }

    public Object listExample(TrackDTO trackDTO) {
        List<Track> track = new ArrayList<>();

        Track trackExemple = trackMapper.toEntity(trackDTO, new CycleAvoidingMappingContext());

        track = trackRepository.findAll(Example.of(trackExemple));

        List<TrackDTO> trackDTOList = new ArrayList<>();
        track.forEach( t->{
            TrackDTO trackDTOAux = new TrackDTO();
            utilBO.entityToDtoCustom(t, trackDTOAux, new ArrayList<>());
            trackDTOList.add(trackDTOAux);
        });

        return trackDTOList;
    }

    public Page<TrackDTO> paginationFull(Integer page, Integer pageSize, String sortBy, String direction, Map<String, Object> filterMap) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Page<TrackDTO> trackDTOPage = null;

        Specification<Track> spec = (root, query, criteriaBuilder) -> {
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

        trackDTOPage = trackRepository
                .findAll(spec,
                        PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(direction), sortBy)))
                .map(x -> {
                    TrackDTO trackDTOAux = new TrackDTO();
                    utilBO.entityToDtoCustom(x, trackDTOAux, new ArrayList<>());
                    return trackDTOAux;
                });


        return trackDTOPage;
    }

}
