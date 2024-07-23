package br.cruzsilva.CruzSilva.bo;

import br.cruzsilva.CruzSilva.dto.EventDTO;

import br.cruzsilva.CruzSilva.mapper.CycleAvoidingMappingContext;
import br.cruzsilva.CruzSilva.mapper.EventMapper;
import br.cruzsilva.CruzSilva.model.masterDataBase.Event;
import br.cruzsilva.CruzSilva.repository.masterDataBase.EventRepository;
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
public class EventBO {

    @Autowired
    UtilBO utilBO;

    @Autowired
    EventRepository eventRepository;

    @Autowired
    EventMapper eventMapper;

    public EventDTO save(EventDTO eventDTO) throws IllegalAccessException {

        Event event = eventMapper.toEntity(eventDTO, new CycleAvoidingMappingContext());

        utilBO.assingObjectToList(event, "event");

        eventRepository.save(event);

        utilBO.entityToDtoCustom(event, eventDTO, new ArrayList<>());

        return eventDTO;

    }

    public EventDTO obtain(Long cdnEvent) {
        Event event = new Event();

        event = eventRepository.getReferenceById(cdnEvent);

        EventDTO eventDTO = new EventDTO(); //eventMapper.toDto(event, new CycleAvoidingMappingContext());

        utilBO.entityToDtoCustom(event, eventDTO, new ArrayList<>());

        return eventDTO;
    }

    public void delete(Long cdnEvent) {
        Event event = new Event(cdnEvent);
        utilBO.checkRelationship(event,cdnEvent);
        eventRepository.deleteById(cdnEvent);

    }

    public Page<EventDTO> pagination(Integer page, Integer pageSize, String sortBy, String direction, Long filter) {

        Event event = new Event();
        return eventRepository
                .findAll(Example.of(event),
                        PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(direction), sortBy)))
                .map(x -> {
                    EventDTO eventDTOAux = new EventDTO();
                    utilBO.entityToDtoCustom(x, eventDTOAux, new ArrayList<>());
                    return eventDTOAux;
                });
    }

    public List<EventDTO> listAll() {
        List<Event> event = new ArrayList<>();

        event = eventRepository.findAll();

        //List<EventDTO> eventDTO = eventMapper.toDto(event, new CycleAvoidingMappingContext());
        List<EventDTO> eventDTOList = new ArrayList<>();
        event.forEach( t->{
            EventDTO eventDTOAux = new EventDTO();
            utilBO.entityToDtoCustom(t, eventDTOAux, new ArrayList<>());
            eventDTOList.add(eventDTOAux);
        });

        return eventDTOList;
    }

    public Object listExample(EventDTO eventDTO) {
        List<Event> event = new ArrayList<>();

        Event eventExemple = eventMapper.toEntity(eventDTO, new CycleAvoidingMappingContext());

        event = eventRepository.findAll(Example.of(eventExemple));

        List<EventDTO> eventDTOList = new ArrayList<>();
        event.forEach( t->{
            EventDTO eventDTOAux = new EventDTO();
            utilBO.entityToDtoCustom(t, eventDTOAux, new ArrayList<>());
            eventDTOList.add(eventDTOAux);
        });

        return eventDTOList;
    }

    public Page<EventDTO> paginationFull(Integer page, Integer pageSize, String sortBy, String direction, Map<String, Object> filterMap) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Page<EventDTO> eventDTOPage = null;

        Specification<Event> spec = (root, query, criteriaBuilder) -> {
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

        eventDTOPage = eventRepository
                .findAll(spec,
                        PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(direction), sortBy)))
                .map(x -> {
                    EventDTO eventDTOAux = new EventDTO();
                    utilBO.entityToDtoCustom(x, eventDTOAux, new ArrayList<>());
                    return eventDTOAux;
                });


        return eventDTOPage;
    }

}
