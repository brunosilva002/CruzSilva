package br.cruzsilva.CruzSilva.bo;

import br.cruzsilva.CruzSilva.dto.JudgeDTO;

import br.cruzsilva.CruzSilva.mapper.CycleAvoidingMappingContext;
import br.cruzsilva.CruzSilva.mapper.JudgeMapper;
import br.cruzsilva.CruzSilva.model.masterDataBase.Judge;
import br.cruzsilva.CruzSilva.repository.masterDataBase.JudgeRepository;
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
public class JudgeBO {

    @Autowired
    UtilBO utilBO;

    @Autowired
    JudgeRepository judgeRepository;

    @Autowired
    JudgeMapper judgeMapper;

    public JudgeDTO save(JudgeDTO judgeDTO) throws IllegalAccessException {

        Judge judge = judgeMapper.toEntity(judgeDTO, new CycleAvoidingMappingContext());

        utilBO.assingObjectToList(judge, "judge");

        judgeRepository.save(judge);

        utilBO.entityToDtoCustom(judge, judgeDTO, new ArrayList<>());

        return judgeDTO;

    }

    public JudgeDTO obtain(Long cdnJudge) {
        Judge judge = new Judge();

        judge = judgeRepository.getReferenceById(cdnJudge);

        JudgeDTO judgeDTO = new JudgeDTO(); //judgeMapper.toDto(judge, new CycleAvoidingMappingContext());

        utilBO.entityToDtoCustom(judge, judgeDTO, new ArrayList<>());

        return judgeDTO;
    }

    public void delete(Long cdnJudge) {
        Judge judge = new Judge(cdnJudge);
        utilBO.checkRelationship(judge,cdnJudge);
        judgeRepository.deleteById(cdnJudge);

    }

    public Page<JudgeDTO> pagination(Integer page, Integer pageSize, String sortBy, String direction, Long filter) {

        Judge judge = new Judge();
        return judgeRepository
                .findAll(Example.of(judge),
                        PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(direction), sortBy)))
                .map(x -> {
                    JudgeDTO judgeDTOAux = new JudgeDTO();
                    utilBO.entityToDtoCustom(x, judgeDTOAux, new ArrayList<>());
                    return judgeDTOAux;
                });
    }

    public List<JudgeDTO> listAll() {
        List<Judge> judge = new ArrayList<>();

        judge = judgeRepository.findAll();

        //List<JudgeDTO> judgeDTO = judgeMapper.toDto(judge, new CycleAvoidingMappingContext());
        List<JudgeDTO> judgeDTOList = new ArrayList<>();
        judge.forEach( t->{
            JudgeDTO judgeDTOAux = new JudgeDTO();
            utilBO.entityToDtoCustom(t, judgeDTOAux, new ArrayList<>());
            judgeDTOList.add(judgeDTOAux);
        });

        return judgeDTOList;
    }

    public Object listExample(JudgeDTO judgeDTO) {
        List<Judge> judge = new ArrayList<>();

        Judge judgeExemple = judgeMapper.toEntity(judgeDTO, new CycleAvoidingMappingContext());

        judge = judgeRepository.findAll(Example.of(judgeExemple));

        List<JudgeDTO> judgeDTOList = new ArrayList<>();
        judge.forEach( t->{
            JudgeDTO judgeDTOAux = new JudgeDTO();
            utilBO.entityToDtoCustom(t, judgeDTOAux, new ArrayList<>());
            judgeDTOList.add(judgeDTOAux);
        });

        return judgeDTOList;
    }

    public Page<JudgeDTO> paginationFull(Integer page, Integer pageSize, String sortBy, String direction, Map<String, Object> filterMap) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Page<JudgeDTO> judgeDTOPage = null;

        Specification<Judge> spec = (root, query, criteriaBuilder) -> {
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

        judgeDTOPage = judgeRepository
                .findAll(spec,
                        PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(direction), sortBy)))
                .map(x -> {
                    JudgeDTO judgeDTOAux = new JudgeDTO();
                    utilBO.entityToDtoCustom(x, judgeDTOAux, new ArrayList<>());
                    return judgeDTOAux;
                });


        return judgeDTOPage;
    }

}
