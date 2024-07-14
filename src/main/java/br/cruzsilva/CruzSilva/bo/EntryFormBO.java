package br.cruzsilva.CruzSilva.bo;

import br.cruzsilva.CruzSilva.dto.EntryFormDTO;

import br.cruzsilva.CruzSilva.mapper.CycleAvoidingMappingContext;
import br.cruzsilva.CruzSilva.mapper.EntryFormMapper;
import br.cruzsilva.CruzSilva.model.masterDataBase.EntryForm;
import br.cruzsilva.CruzSilva.repository.masterDataBase.EntryFormRepository;
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
public class EntryFormBO {

    @Autowired
    UtilBO utilBO;

    @Autowired
    EntryFormRepository entryformRepository;

    @Autowired
    EntryFormMapper entryformMapper;

    public EntryFormDTO save(EntryFormDTO entryformDTO) throws IllegalAccessException {

        EntryForm entryform = entryformMapper.toEntity(entryformDTO, new CycleAvoidingMappingContext());

        utilBO.assingObjectToList(entryform, "entryform");

        entryformRepository.save(entryform);

        utilBO.entityToDtoCustom(entryform, entryformDTO, new ArrayList<>());

        return entryformDTO;

    }

    public EntryFormDTO obtain(Long cdnEntryForm) {
        EntryForm entryform = new EntryForm();

        entryform = entryformRepository.getReferenceById(cdnEntryForm);

        EntryFormDTO entryformDTO = new EntryFormDTO(); //entryformMapper.toDto(entryform, new CycleAvoidingMappingContext());

        utilBO.entityToDtoCustom(entryform, entryformDTO, new ArrayList<>());

        return entryformDTO;
    }

    public void delete(Long cdnEntryForm) {
        EntryForm entryform = new EntryForm(cdnEntryForm);
        utilBO.checkRelationship(entryform,cdnEntryForm);
        entryformRepository.deleteById(cdnEntryForm);

    }

    public Page<EntryFormDTO> pagination(Integer page, Integer pageSize, String sortBy, String direction, Long filter) {

        EntryForm entryform = new EntryForm();
        return entryformRepository
                .findAll(Example.of(entryform),
                        PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(direction), sortBy)))
                .map(x -> {
                    EntryFormDTO entryformDTOAux = new EntryFormDTO();
                    utilBO.entityToDtoCustom(x, entryformDTOAux, new ArrayList<>());
                    return entryformDTOAux;
                });
    }

    public List<EntryFormDTO> listAll() {
        List<EntryForm> entryform = new ArrayList<>();

        entryform = entryformRepository.findAll();

        //List<EntryFormDTO> entryformDTO = entryformMapper.toDto(entryform, new CycleAvoidingMappingContext());
        List<EntryFormDTO> entryformDTOList = new ArrayList<>();
        entryform.forEach( t->{
            EntryFormDTO entryformDTOAux = new EntryFormDTO();
            utilBO.entityToDtoCustom(t, entryformDTOAux, new ArrayList<>());
            entryformDTOList.add(entryformDTOAux);
        });

        return entryformDTOList;
    }

    public Object listExample(EntryFormDTO entryformDTO) {
        List<EntryForm> entryform = new ArrayList<>();

        EntryForm entryformExemple = entryformMapper.toEntity(entryformDTO, new CycleAvoidingMappingContext());

        entryform = entryformRepository.findAll(Example.of(entryformExemple));

        List<EntryFormDTO> entryformDTOList = new ArrayList<>();
        entryform.forEach( t->{
            EntryFormDTO entryformDTOAux = new EntryFormDTO();
            utilBO.entityToDtoCustom(t, entryformDTOAux, new ArrayList<>());
            entryformDTOList.add(entryformDTOAux);
        });

        return entryformDTOList;
    }

    public Page<EntryFormDTO> paginationFull(Integer page, Integer pageSize, String sortBy, String direction, Map<String, Object> filterMap) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Page<EntryFormDTO> entryformDTOPage = null;

        Specification<EntryForm> spec = (root, query, criteriaBuilder) -> {
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

        entryformDTOPage = entryformRepository
                .findAll(spec,
                        PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(direction), sortBy)))
                .map(x -> {
                    EntryFormDTO entryformDTOAux = new EntryFormDTO();
                    utilBO.entityToDtoCustom(x, entryformDTOAux, new ArrayList<>());
                    return entryformDTOAux;
                });


        return entryformDTOPage;
    }

}
