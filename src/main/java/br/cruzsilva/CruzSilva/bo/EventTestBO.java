package br.cruzsilva.CruzSilva.bo;

import br.cruzsilva.CruzSilva.dto.EventTestDTO;

import br.cruzsilva.CruzSilva.mapper.CycleAvoidingMappingContext;
import br.cruzsilva.CruzSilva.mapper.EventTestMapper;
import br.cruzsilva.CruzSilva.model.masterDataBase.EventTest;
import br.cruzsilva.CruzSilva.repository.masterDataBase.EventTestRepository;
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
public class EventTestBO {

    @Autowired
    UtilBO utilBO;

    @Autowired
    EventTestRepository eventtestRepository;

    @Autowired
    EventTestMapper eventtestMapper;

    public EventTestDTO save(EventTestDTO eventtestDTO) throws IllegalAccessException {

        EventTest eventtest = eventtestMapper.toEntity(eventtestDTO, new CycleAvoidingMappingContext());

        utilBO.assingObjectToList(eventtest, "eventtest");

        eventtestRepository.save(eventtest);

        utilBO.entityToDtoCustom(eventtest, eventtestDTO, new ArrayList<>());

        return eventtestDTO;

    }

    public EventTestDTO obtain(Long cdnEventTest) {
        EventTest eventtest = new EventTest();

        eventtest = eventtestRepository.getReferenceById(cdnEventTest);

        EventTestDTO eventtestDTO = new EventTestDTO(); //eventtestMapper.toDto(eventtest, new CycleAvoidingMappingContext());

        utilBO.entityToDtoCustom(eventtest, eventtestDTO, new ArrayList<>());

        return eventtestDTO;
    }

    public void delete(Long cdnEventTest) {
        EventTest eventtest = new EventTest(cdnEventTest);
        utilBO.checkRelationship(eventtest,cdnEventTest);
        eventtestRepository.deleteById(cdnEventTest);

    }

    public Page<EventTestDTO> pagination(Integer page, Integer pageSize, String sortBy, String direction, Long filter) {

        EventTest eventtest = new EventTest();
        return eventtestRepository
                .findAll(Example.of(eventtest),
                        PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(direction), sortBy)))
                .map(x -> {
                    EventTestDTO eventtestDTOAux = new EventTestDTO();
                    utilBO.entityToDtoCustom(x, eventtestDTOAux, new ArrayList<>());
                    return eventtestDTOAux;
                });
    }

    public List<EventTestDTO> listAll() {
        List<EventTest> eventtest = new ArrayList<>();

        eventtest = eventtestRepository.findAll();

        //List<EventTestDTO> eventtestDTO = eventtestMapper.toDto(eventtest, new CycleAvoidingMappingContext());
        List<EventTestDTO> eventtestDTOList = new ArrayList<>();
        eventtest.forEach( t->{
            EventTestDTO eventtestDTOAux = new EventTestDTO();
            utilBO.entityToDtoCustom(t, eventtestDTOAux, new ArrayList<>());
            eventtestDTOList.add(eventtestDTOAux);
        });

        return eventtestDTOList;
    }

    public Object listExample(EventTestDTO eventtestDTO) {
        List<EventTest> eventtest = new ArrayList<>();

        EventTest eventtestExemple = eventtestMapper.toEntity(eventtestDTO, new CycleAvoidingMappingContext());

        eventtest = eventtestRepository.findAll(Example.of(eventtestExemple));

        List<EventTestDTO> eventtestDTOList = new ArrayList<>();
        eventtest.forEach( t->{
            EventTestDTO eventtestDTOAux = new EventTestDTO();
            utilBO.entityToDtoCustom(t, eventtestDTOAux, new ArrayList<>());
            eventtestDTOList.add(eventtestDTOAux);
        });

        return eventtestDTOList;
    }

    public Page<EventTestDTO> paginationFull(Integer page, Integer pageSize, String sortBy, String direction, Map<String, Object> filterMap) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Page<EventTestDTO> eventtestDTOPage = null;

        Specification<EventTest> spec = (root, query, criteriaBuilder) -> {
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

        eventtestDTOPage = eventtestRepository
                .findAll(spec,
                        PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(direction), sortBy)))
                .map(x -> {
                    EventTestDTO eventtestDTOAux = new EventTestDTO();
                    utilBO.entityToDtoCustom(x, eventtestDTOAux, new ArrayList<>());
                    return eventtestDTOAux;
                });


        return eventtestDTOPage;
    }

}
