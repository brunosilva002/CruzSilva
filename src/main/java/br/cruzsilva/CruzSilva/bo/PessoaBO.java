package br.cruzsilva.CruzSilva.bo;

import br.cruzsilva.CruzSilva.dto.PessoaDTO;

import br.cruzsilva.CruzSilva.mapper.CycleAvoidingMappingContext;
import br.cruzsilva.CruzSilva.mapper.PessoaMapper;
import br.cruzsilva.CruzSilva.model.masterDataBase.Pessoa;
import br.cruzsilva.CruzSilva.repository.masterDataBase.PessoaRepository;
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
public class PessoaBO {

    @Autowired
    UtilBO utilBO;

    @Autowired
    PessoaRepository pessoaRepository;

    @Autowired
    PessoaMapper pessoaMapper;

    public PessoaDTO save(PessoaDTO pessoaDTO) throws IllegalAccessException {

        Pessoa pessoa = pessoaMapper.toEntity(pessoaDTO, new CycleAvoidingMappingContext());

        utilBO.assingObjectToList(pessoa, "pessoa");

        pessoaRepository.save(pessoa);

        utilBO.entityToDtoCustom(pessoa, pessoaDTO, new ArrayList<>());

        return pessoaDTO;

    }

    public PessoaDTO obtain(Long cdnPessoa) {
        Pessoa pessoa = new Pessoa();

        pessoa = pessoaRepository.getReferenceById(cdnPessoa);

        PessoaDTO pessoaDTO = new PessoaDTO(); //pessoaMapper.toDto(pessoa, new CycleAvoidingMappingContext());

        utilBO.entityToDtoCustom(pessoa, pessoaDTO, new ArrayList<>());

        return pessoaDTO;
    }

    public void delete(Long cdnPessoa) {
        Pessoa pessoa = new Pessoa(cdnPessoa);
        utilBO.checkRelationship(pessoa,cdnPessoa);
        pessoaRepository.deleteById(cdnPessoa);

    }

    public Page<PessoaDTO> pagination(Integer page, Integer pageSize, String sortBy, String direction, Long filter) {

        Pessoa pessoa = new Pessoa();
        return pessoaRepository
                .findAll(Example.of(pessoa),
                        PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(direction), sortBy)))
                .map(x -> {
                    PessoaDTO pessoaDTOAux = new PessoaDTO();
                    utilBO.entityToDtoCustom(x, pessoaDTOAux, new ArrayList<>());
                    return pessoaDTOAux;
                });
    }

    public List<PessoaDTO> listAll() {
        List<Pessoa> pessoa = new ArrayList<>();

        pessoa = pessoaRepository.findAll();

        //List<PessoaDTO> pessoaDTO = pessoaMapper.toDto(pessoa, new CycleAvoidingMappingContext());
        List<PessoaDTO> pessoaDTOList = new ArrayList<>();
        pessoa.forEach( t->{
            PessoaDTO pessoaDTOAux = new PessoaDTO();
            utilBO.entityToDtoCustom(t, pessoaDTOAux, new ArrayList<>());
            pessoaDTOList.add(pessoaDTOAux);
        });

        return pessoaDTOList;
    }

    public Object listExample(PessoaDTO pessoaDTO) {
        List<Pessoa> pessoa = new ArrayList<>();

        Pessoa pessoaExemple = pessoaMapper.toEntity(pessoaDTO, new CycleAvoidingMappingContext());

        pessoa = pessoaRepository.findAll(Example.of(pessoaExemple));

        List<PessoaDTO> pessoaDTOList = new ArrayList<>();
        pessoa.forEach( t->{
            PessoaDTO pessoaDTOAux = new PessoaDTO();
            utilBO.entityToDtoCustom(t, pessoaDTOAux, new ArrayList<>());
            pessoaDTOList.add(pessoaDTOAux);
        });

        return pessoaDTOList;
    }

    public Page<PessoaDTO> paginationFull(Integer page, Integer pageSize, String sortBy, String direction, Map<String, Object> filterMap) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Page<PessoaDTO> pessoaDTOPage = null;

        Specification<Pessoa> spec = (root, query, criteriaBuilder) -> {
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

        pessoaDTOPage = pessoaRepository
                .findAll(spec,
                        PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(direction), sortBy)))
                .map(x -> {
                    PessoaDTO pessoaDTOAux = new PessoaDTO();
                    utilBO.entityToDtoCustom(x, pessoaDTOAux, new ArrayList<>());
                    return pessoaDTOAux;
                });


        return pessoaDTOPage;
    }

}
