package br.cruzsilva.CruzSilva.bo;

import br.cruzsilva.CruzSilva.dto.RopingDivisionRankDTO;

import br.cruzsilva.CruzSilva.mapper.CycleAvoidingMappingContext;
import br.cruzsilva.CruzSilva.mapper.RopingDivisionRankMapper;
import br.cruzsilva.CruzSilva.model.masterDataBase.RopingDivisionRank;
import br.cruzsilva.CruzSilva.repository.masterDataBase.RopingDivisionRankRepository;
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
public class RopingDivisionRankBO {

    @Autowired
    UtilBO utilBO;

    @Autowired
    RopingDivisionRankRepository ropingdivisionrankRepository;

    @Autowired
    RopingDivisionRankMapper ropingdivisionrankMapper;

    public RopingDivisionRankDTO save(RopingDivisionRankDTO ropingdivisionrankDTO) throws IllegalAccessException {

        RopingDivisionRank ropingdivisionrank = ropingdivisionrankMapper.toEntity(ropingdivisionrankDTO, new CycleAvoidingMappingContext());

        utilBO.assingObjectToList(ropingdivisionrank, "ropingdivisionrank");

        ropingdivisionrankRepository.save(ropingdivisionrank);

        utilBO.entityToDtoCustom(ropingdivisionrank, ropingdivisionrankDTO, new ArrayList<>());

        return ropingdivisionrankDTO;

    }

    public RopingDivisionRankDTO obtain(Long cdnRopingDivisionRank) {
        RopingDivisionRank ropingdivisionrank = new RopingDivisionRank();

        ropingdivisionrank = ropingdivisionrankRepository.getReferenceById(cdnRopingDivisionRank);

        RopingDivisionRankDTO ropingdivisionrankDTO = new RopingDivisionRankDTO(); //ropingdivisionrankMapper.toDto(ropingdivisionrank, new CycleAvoidingMappingContext());

        utilBO.entityToDtoCustom(ropingdivisionrank, ropingdivisionrankDTO, new ArrayList<>());

        return ropingdivisionrankDTO;
    }

    public void delete(Long cdnRopingDivisionRank) {
        RopingDivisionRank ropingdivisionrank = new RopingDivisionRank(cdnRopingDivisionRank);
        utilBO.checkRelationship(ropingdivisionrank,cdnRopingDivisionRank);
        ropingdivisionrankRepository.deleteById(cdnRopingDivisionRank);

    }

    public Page<RopingDivisionRankDTO> pagination(Integer page, Integer pageSize, String sortBy, String direction, Long filter) {

        RopingDivisionRank ropingdivisionrank = new RopingDivisionRank();
        return ropingdivisionrankRepository
                .findAll(Example.of(ropingdivisionrank),
                        PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(direction), sortBy)))
                .map(x -> {
                    RopingDivisionRankDTO ropingdivisionrankDTOAux = new RopingDivisionRankDTO();
                    utilBO.entityToDtoCustom(x, ropingdivisionrankDTOAux, new ArrayList<>());
                    return ropingdivisionrankDTOAux;
                });
    }

    public List<RopingDivisionRankDTO> listAll() {
        List<RopingDivisionRank> ropingdivisionrank = new ArrayList<>();

        ropingdivisionrank = ropingdivisionrankRepository.findAll();

        //List<RopingDivisionRankDTO> ropingdivisionrankDTO = ropingdivisionrankMapper.toDto(ropingdivisionrank, new CycleAvoidingMappingContext());
        List<RopingDivisionRankDTO> ropingdivisionrankDTOList = new ArrayList<>();
        ropingdivisionrank.forEach( t->{
            RopingDivisionRankDTO ropingdivisionrankDTOAux = new RopingDivisionRankDTO();
            utilBO.entityToDtoCustom(t, ropingdivisionrankDTOAux, new ArrayList<>());
            ropingdivisionrankDTOList.add(ropingdivisionrankDTOAux);
        });

        return ropingdivisionrankDTOList;
    }

    public Object listExample(RopingDivisionRankDTO ropingdivisionrankDTO) {
        List<RopingDivisionRank> ropingdivisionrank = new ArrayList<>();

        RopingDivisionRank ropingdivisionrankExemple = ropingdivisionrankMapper.toEntity(ropingdivisionrankDTO, new CycleAvoidingMappingContext());

        ropingdivisionrank = ropingdivisionrankRepository.findAll(Example.of(ropingdivisionrankExemple));

        List<RopingDivisionRankDTO> ropingdivisionrankDTOList = new ArrayList<>();
        ropingdivisionrank.forEach( t->{
            RopingDivisionRankDTO ropingdivisionrankDTOAux = new RopingDivisionRankDTO();
            utilBO.entityToDtoCustom(t, ropingdivisionrankDTOAux, new ArrayList<>());
            ropingdivisionrankDTOList.add(ropingdivisionrankDTOAux);
        });

        return ropingdivisionrankDTOList;
    }

    public Page<RopingDivisionRankDTO> paginationFull(Integer page, Integer pageSize, String sortBy, String direction, Map<String, Object> filterMap) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Page<RopingDivisionRankDTO> ropingdivisionrankDTOPage = null;

        Specification<RopingDivisionRank> spec = (root, query, criteriaBuilder) -> {
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

        ropingdivisionrankDTOPage = ropingdivisionrankRepository
                .findAll(spec,
                        PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(direction), sortBy)))
                .map(x -> {
                    RopingDivisionRankDTO ropingdivisionrankDTOAux = new RopingDivisionRankDTO();
                    utilBO.entityToDtoCustom(x, ropingdivisionrankDTOAux, new ArrayList<>());
                    return ropingdivisionrankDTOAux;
                });


        return ropingdivisionrankDTOPage;
    }

}
