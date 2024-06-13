package br.cruzsilva.CruzSilva.bo;

import br.cruzsilva.CruzSilva.dto.CompetitorDTO;

import br.cruzsilva.CruzSilva.mapper.CycleAvoidingMappingContext;
import br.cruzsilva.CruzSilva.mapper.CompetitorMapper;
import br.cruzsilva.CruzSilva.model.masterDataBase.Competitor;
import br.cruzsilva.CruzSilva.repository.masterDataBase.CompetitorRepository;
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
public class CompetitorBO {

    @Autowired
    UtilBO utilBO;

    @Autowired
    CompetitorRepository competitorRepository;

    @Autowired
    CompetitorMapper competitorMapper;

    public CompetitorDTO save(CompetitorDTO competitorDTO) throws IllegalAccessException {

        Competitor competitor = competitorMapper.toEntity(competitorDTO, new CycleAvoidingMappingContext());

        utilBO.assingObjectToList(competitor, "competitor");

        competitorRepository.save(competitor);

        utilBO.entityToDtoCustom(competitor, competitorDTO, new ArrayList<>());

        return competitorDTO;

    }

    public CompetitorDTO obtain(Long cdnCompetitor) {
        Competitor competitor = new Competitor();

        competitor = competitorRepository.getReferenceById(cdnCompetitor);

        CompetitorDTO competitorDTO = new CompetitorDTO(); //competitorMapper.toDto(competitor, new CycleAvoidingMappingContext());

        utilBO.entityToDtoCustom(competitor, competitorDTO, new ArrayList<>());

        return competitorDTO;
    }

    public void delete(Long cdnCompetitor) {
        Competitor competitor = new Competitor(cdnCompetitor);
        utilBO.checkRelationship(competitor,cdnCompetitor);
        competitorRepository.deleteById(cdnCompetitor);

    }

    public Page<CompetitorDTO> pagination(Integer page, Integer pageSize, String sortBy, String direction, Long filter) {

        Competitor competitor = new Competitor();
        return competitorRepository
                .findAll(Example.of(competitor),
                        PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(direction), sortBy)))
                .map(x -> {
                    CompetitorDTO competitorDTOAux = new CompetitorDTO();
                    utilBO.entityToDtoCustom(x, competitorDTOAux, new ArrayList<>());
                    return competitorDTOAux;
                });
    }

    public List<CompetitorDTO> listAll() {
        List<Competitor> competitor = new ArrayList<>();

        competitor = competitorRepository.findAll();

        //List<CompetitorDTO> competitorDTO = competitorMapper.toDto(competitor, new CycleAvoidingMappingContext());
        List<CompetitorDTO> competitorDTOList = new ArrayList<>();
        competitor.forEach( t->{
            CompetitorDTO competitorDTOAux = new CompetitorDTO();
            utilBO.entityToDtoCustom(t, competitorDTOAux, new ArrayList<>());
            competitorDTOList.add(competitorDTOAux);
        });

        return competitorDTOList;
    }

    public Object listExample(CompetitorDTO competitorDTO) {
        List<Competitor> competitor = new ArrayList<>();

        Competitor competitorExemple = competitorMapper.toEntity(competitorDTO, new CycleAvoidingMappingContext());

        competitor = competitorRepository.findAll(Example.of(competitorExemple));

        List<CompetitorDTO> competitorDTOList = new ArrayList<>();
        competitor.forEach( t->{
            CompetitorDTO competitorDTOAux = new CompetitorDTO();
            utilBO.entityToDtoCustom(t, competitorDTOAux, new ArrayList<>());
            competitorDTOList.add(competitorDTOAux);
        });

        return competitorDTOList;
    }

    public Page<CompetitorDTO> paginationFull(Integer page, Integer pageSize, String sortBy, String direction, Map<String, Object> filterMap) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Page<CompetitorDTO> competitorDTOPage = null;

        Specification<Competitor> spec = (root, query, criteriaBuilder) -> {
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

        competitorDTOPage = competitorRepository
                .findAll(spec,
                        PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(direction), sortBy)))
                .map(x -> {
                    CompetitorDTO competitorDTOAux = new CompetitorDTO();
                    utilBO.entityToDtoCustom(x, competitorDTOAux, new ArrayList<>());
                    return competitorDTOAux;
                });


        return competitorDTOPage;
    }

}
