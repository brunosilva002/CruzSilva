package br.cruzsilva.CruzSilva.bo;

import br.cruzsilva.CruzSilva.dto.RewardKindDTO;

import br.cruzsilva.CruzSilva.mapper.CycleAvoidingMappingContext;
import br.cruzsilva.CruzSilva.mapper.RewardKindMapper;
import br.cruzsilva.CruzSilva.model.masterDataBase.RewardKind;
import br.cruzsilva.CruzSilva.repository.masterDataBase.RewardKindRepository;
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
public class RewardKindBO {

    @Autowired
    UtilBO utilBO;

    @Autowired
    RewardKindRepository rewardkindRepository;

    @Autowired
    RewardKindMapper rewardkindMapper;

    public RewardKindDTO save(RewardKindDTO rewardkindDTO) throws IllegalAccessException {

        RewardKind rewardkind = rewardkindMapper.toEntity(rewardkindDTO, new CycleAvoidingMappingContext());

        utilBO.assingObjectToList(rewardkind, "rewardkind");

        rewardkindRepository.save(rewardkind);

        utilBO.entityToDtoCustom(rewardkind, rewardkindDTO, new ArrayList<>());

        return rewardkindDTO;

    }

    public RewardKindDTO obtain(Long cdnRewardKind) {
        RewardKind rewardkind = new RewardKind();

        rewardkind = rewardkindRepository.getReferenceById(cdnRewardKind);

        RewardKindDTO rewardkindDTO = new RewardKindDTO(); //rewardkindMapper.toDto(rewardkind, new CycleAvoidingMappingContext());

        utilBO.entityToDtoCustom(rewardkind, rewardkindDTO, new ArrayList<>());

        return rewardkindDTO;
    }

    public void delete(Long cdnRewardKind) {
        RewardKind rewardkind = new RewardKind(cdnRewardKind);
        utilBO.checkRelationship(rewardkind,cdnRewardKind);
        rewardkindRepository.deleteById(cdnRewardKind);

    }

    public Page<RewardKindDTO> pagination(Integer page, Integer pageSize, String sortBy, String direction, Long filter) {

        RewardKind rewardkind = new RewardKind();
        return rewardkindRepository
                .findAll(Example.of(rewardkind),
                        PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(direction), sortBy)))
                .map(x -> {
                    RewardKindDTO rewardkindDTOAux = new RewardKindDTO();
                    utilBO.entityToDtoCustom(x, rewardkindDTOAux, new ArrayList<>());
                    return rewardkindDTOAux;
                });
    }

    public List<RewardKindDTO> listAll() {
        List<RewardKind> rewardkind = new ArrayList<>();

        rewardkind = rewardkindRepository.findAll();

        //List<RewardKindDTO> rewardkindDTO = rewardkindMapper.toDto(rewardkind, new CycleAvoidingMappingContext());
        List<RewardKindDTO> rewardkindDTOList = new ArrayList<>();
        rewardkind.forEach( t->{
            RewardKindDTO rewardkindDTOAux = new RewardKindDTO();
            utilBO.entityToDtoCustom(t, rewardkindDTOAux, new ArrayList<>());
            rewardkindDTOList.add(rewardkindDTOAux);
        });

        return rewardkindDTOList;
    }

    public Object listExample(RewardKindDTO rewardkindDTO) {
        List<RewardKind> rewardkind = new ArrayList<>();

        RewardKind rewardkindExemple = rewardkindMapper.toEntity(rewardkindDTO, new CycleAvoidingMappingContext());

        rewardkind = rewardkindRepository.findAll(Example.of(rewardkindExemple));

        List<RewardKindDTO> rewardkindDTOList = new ArrayList<>();
        rewardkind.forEach( t->{
            RewardKindDTO rewardkindDTOAux = new RewardKindDTO();
            utilBO.entityToDtoCustom(t, rewardkindDTOAux, new ArrayList<>());
            rewardkindDTOList.add(rewardkindDTOAux);
        });

        return rewardkindDTOList;
    }

    public Page<RewardKindDTO> paginationFull(Integer page, Integer pageSize, String sortBy, String direction, Map<String, Object> filterMap) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Page<RewardKindDTO> rewardkindDTOPage = null;

        Specification<RewardKind> spec = (root, query, criteriaBuilder) -> {
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

        rewardkindDTOPage = rewardkindRepository
                .findAll(spec,
                        PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(direction), sortBy)))
                .map(x -> {
                    RewardKindDTO rewardkindDTOAux = new RewardKindDTO();
                    utilBO.entityToDtoCustom(x, rewardkindDTOAux, new ArrayList<>());
                    return rewardkindDTOAux;
                });


        return rewardkindDTOPage;
    }

}
