package br.cruzsilva.CruzSilva.bo;

import br.cruzsilva.CruzSilva.dto.ChampionshipStageDTO;

import br.cruzsilva.CruzSilva.mapper.CycleAvoidingMappingContext;
import br.cruzsilva.CruzSilva.mapper.ChampionshipStageMapper;
import br.cruzsilva.CruzSilva.model.masterDataBase.ChampionshipStage;
import br.cruzsilva.CruzSilva.repository.masterDataBase.ChampionshipStageRepository;
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
public class ChampionshipStageBO {

    @Autowired
    UtilBO utilBO;

    @Autowired
    ChampionshipStageRepository championshipstageRepository;

    @Autowired
    ChampionshipStageMapper championshipstageMapper;

    public ChampionshipStageDTO save(ChampionshipStageDTO championshipstageDTO) throws IllegalAccessException {

        ChampionshipStage championshipstage = championshipstageMapper.toEntity(championshipstageDTO, new CycleAvoidingMappingContext());

        utilBO.assingObjectToList(championshipstage, "championshipstage");

        championshipstageRepository.save(championshipstage);

        utilBO.entityToDtoCustom(championshipstage, championshipstageDTO, new ArrayList<>());

        return championshipstageDTO;

    }

    public ChampionshipStageDTO obtain(Long cdnChampionshipStage) {
        ChampionshipStage championshipstage = new ChampionshipStage();

        championshipstage = championshipstageRepository.getReferenceById(cdnChampionshipStage);

        ChampionshipStageDTO championshipstageDTO = new ChampionshipStageDTO(); //championshipstageMapper.toDto(championshipstage, new CycleAvoidingMappingContext());

        utilBO.entityToDtoCustom(championshipstage, championshipstageDTO, new ArrayList<>());

        return championshipstageDTO;
    }

    public void delete(Long cdnChampionshipStage) {
        ChampionshipStage championshipstage = new ChampionshipStage(cdnChampionshipStage);
        utilBO.checkRelationship(championshipstage,cdnChampionshipStage);
        championshipstageRepository.deleteById(cdnChampionshipStage);

    }

    public Page<ChampionshipStageDTO> pagination(Integer page, Integer pageSize, String sortBy, String direction, Long filter) {

        ChampionshipStage championshipstage = new ChampionshipStage();
        return championshipstageRepository
                .findAll(Example.of(championshipstage),
                        PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(direction), sortBy)))
                .map(x -> {
                    ChampionshipStageDTO championshipstageDTOAux = new ChampionshipStageDTO();
                    utilBO.entityToDtoCustom(x, championshipstageDTOAux, new ArrayList<>());
                    return championshipstageDTOAux;
                });
    }

    public List<ChampionshipStageDTO> listAll() {
        List<ChampionshipStage> championshipstage = new ArrayList<>();

        championshipstage = championshipstageRepository.findAll();

        //List<ChampionshipStageDTO> championshipstageDTO = championshipstageMapper.toDto(championshipstage, new CycleAvoidingMappingContext());
        List<ChampionshipStageDTO> championshipstageDTOList = new ArrayList<>();
        championshipstage.forEach( t->{
            ChampionshipStageDTO championshipstageDTOAux = new ChampionshipStageDTO();
            utilBO.entityToDtoCustom(t, championshipstageDTOAux, new ArrayList<>());
            championshipstageDTOList.add(championshipstageDTOAux);
        });

        return championshipstageDTOList;
    }

    public Object listExample(ChampionshipStageDTO championshipstageDTO) {
        List<ChampionshipStage> championshipstage = new ArrayList<>();

        ChampionshipStage championshipstageExemple = championshipstageMapper.toEntity(championshipstageDTO, new CycleAvoidingMappingContext());

        championshipstage = championshipstageRepository.findAll(Example.of(championshipstageExemple));

        List<ChampionshipStageDTO> championshipstageDTOList = new ArrayList<>();
        championshipstage.forEach( t->{
            ChampionshipStageDTO championshipstageDTOAux = new ChampionshipStageDTO();
            utilBO.entityToDtoCustom(t, championshipstageDTOAux, new ArrayList<>());
            championshipstageDTOList.add(championshipstageDTOAux);
        });

        return championshipstageDTOList;
    }

    public Page<ChampionshipStageDTO> paginationFull(Integer page, Integer pageSize, String sortBy, String direction, Map<String, Object> filterMap) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Page<ChampionshipStageDTO> championshipstageDTOPage = null;

        Specification<ChampionshipStage> spec = (root, query, criteriaBuilder) -> {
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

        championshipstageDTOPage = championshipstageRepository
                .findAll(spec,
                        PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(direction), sortBy)))
                .map(x -> {
                    ChampionshipStageDTO championshipstageDTOAux = new ChampionshipStageDTO();
                    utilBO.entityToDtoCustom(x, championshipstageDTOAux, new ArrayList<>());
                    return championshipstageDTOAux;
                });


        return championshipstageDTOPage;
    }

}
