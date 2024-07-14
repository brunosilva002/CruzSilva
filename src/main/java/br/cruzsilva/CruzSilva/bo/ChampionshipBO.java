package br.cruzsilva.CruzSilva.bo;

import br.cruzsilva.CruzSilva.dto.ChampionshipDTO;

import br.cruzsilva.CruzSilva.mapper.CycleAvoidingMappingContext;
import br.cruzsilva.CruzSilva.mapper.ChampionshipMapper;
import br.cruzsilva.CruzSilva.model.masterDataBase.Championship;
import br.cruzsilva.CruzSilva.repository.masterDataBase.ChampionshipRepository;
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
public class ChampionshipBO {

    @Autowired
    UtilBO utilBO;

    @Autowired
    ChampionshipRepository championshipRepository;

    @Autowired
    ChampionshipMapper championshipMapper;

    public ChampionshipDTO save(ChampionshipDTO championshipDTO) throws IllegalAccessException {

        Championship championship = championshipMapper.toEntity(championshipDTO, new CycleAvoidingMappingContext());

        utilBO.assingObjectToList(championship, "championship");

        championshipRepository.save(championship);

        utilBO.entityToDtoCustom(championship, championshipDTO, new ArrayList<>());

        return championshipDTO;

    }

    public ChampionshipDTO obtain(Long cdnChampionship) {
        Championship championship = new Championship();

        championship = championshipRepository.getReferenceById(cdnChampionship);

        ChampionshipDTO championshipDTO = new ChampionshipDTO(); //championshipMapper.toDto(championship, new CycleAvoidingMappingContext());

        utilBO.entityToDtoCustom(championship, championshipDTO, new ArrayList<>());

        return championshipDTO;
    }

    public void delete(Long cdnChampionship) {
        Championship championship = new Championship(cdnChampionship);
        utilBO.checkRelationship(championship,cdnChampionship);
        championshipRepository.deleteById(cdnChampionship);

    }

    public Page<ChampionshipDTO> pagination(Integer page, Integer pageSize, String sortBy, String direction, Long filter) {

        Championship championship = new Championship();
        return championshipRepository
                .findAll(Example.of(championship),
                        PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(direction), sortBy)))
                .map(x -> {
                    ChampionshipDTO championshipDTOAux = new ChampionshipDTO();
                    utilBO.entityToDtoCustom(x, championshipDTOAux, new ArrayList<>());
                    return championshipDTOAux;
                });
    }

    public List<ChampionshipDTO> listAll() {
        List<Championship> championship = new ArrayList<>();

        championship = championshipRepository.findAll();

        //List<ChampionshipDTO> championshipDTO = championshipMapper.toDto(championship, new CycleAvoidingMappingContext());
        List<ChampionshipDTO> championshipDTOList = new ArrayList<>();
        championship.forEach( t->{
            ChampionshipDTO championshipDTOAux = new ChampionshipDTO();
            utilBO.entityToDtoCustom(t, championshipDTOAux, new ArrayList<>());
            championshipDTOList.add(championshipDTOAux);
        });

        return championshipDTOList;
    }

    public Object listExample(ChampionshipDTO championshipDTO) {
        List<Championship> championship = new ArrayList<>();

        Championship championshipExemple = championshipMapper.toEntity(championshipDTO, new CycleAvoidingMappingContext());

        championship = championshipRepository.findAll(Example.of(championshipExemple));

        List<ChampionshipDTO> championshipDTOList = new ArrayList<>();
        championship.forEach( t->{
            ChampionshipDTO championshipDTOAux = new ChampionshipDTO();
            utilBO.entityToDtoCustom(t, championshipDTOAux, new ArrayList<>());
            championshipDTOList.add(championshipDTOAux);
        });

        return championshipDTOList;
    }

    public Page<ChampionshipDTO> paginationFull(Integer page, Integer pageSize, String sortBy, String direction, Map<String, Object> filterMap) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Page<ChampionshipDTO> championshipDTOPage = null;

        Specification<Championship> spec = (root, query, criteriaBuilder) -> {
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

        championshipDTOPage = championshipRepository
                .findAll(spec,
                        PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(direction), sortBy)))
                .map(x -> {
                    ChampionshipDTO championshipDTOAux = new ChampionshipDTO();
                    utilBO.entityToDtoCustom(x, championshipDTOAux, new ArrayList<>());
                    return championshipDTOAux;
                });


        return championshipDTOPage;
    }

}
