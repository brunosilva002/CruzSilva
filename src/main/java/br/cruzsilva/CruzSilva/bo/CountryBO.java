package br.cruzsilva.CruzSilva.bo;

import br.cruzsilva.CruzSilva.dto.CountryDTO;

import br.cruzsilva.CruzSilva.mapper.CycleAvoidingMappingContext;
import br.cruzsilva.CruzSilva.mapper.CountryMapper;
import br.cruzsilva.CruzSilva.model.masterDataBase.Country;
import br.cruzsilva.CruzSilva.repository.masterDataBase.CountryRepository;
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
public class CountryBO {

    @Autowired
    UtilBO utilBO;

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    CountryMapper countryMapper;

    public CountryDTO save(CountryDTO countryDTO) throws IllegalAccessException {

        Country country = countryMapper.toEntity(countryDTO, new CycleAvoidingMappingContext());

        utilBO.assingObjectToList(country, "country");

        countryRepository.save(country);

        utilBO.entityToDtoCustom(country, countryDTO, new ArrayList<>());

        return countryDTO;

    }

    public CountryDTO obtain(Long cdnCountry) {
        Country country = new Country();

        country = countryRepository.getReferenceById(cdnCountry);

        CountryDTO countryDTO = new CountryDTO(); //countryMapper.toDto(country, new CycleAvoidingMappingContext());

        utilBO.entityToDtoCustom(country, countryDTO, new ArrayList<>());

        return countryDTO;
    }

    public void delete(Long cdnCountry) {
        Country country = new Country(cdnCountry);
        utilBO.checkRelationship(country,cdnCountry);
        countryRepository.deleteById(cdnCountry);

    }

    public Page<CountryDTO> pagination(Integer page, Integer pageSize, String sortBy, String direction, Long filter) {

        Country country = new Country();
        return countryRepository
                .findAll(Example.of(country),
                        PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(direction), sortBy)))
                .map(x -> {
                    CountryDTO countryDTOAux = new CountryDTO();
                    utilBO.entityToDtoCustom(x, countryDTOAux, new ArrayList<>());
                    return countryDTOAux;
                });
    }

    public List<CountryDTO> listAll() {
        List<Country> country = new ArrayList<>();

        country = countryRepository.findAll();

        //List<CountryDTO> countryDTO = countryMapper.toDto(country, new CycleAvoidingMappingContext());
        List<CountryDTO> countryDTOList = new ArrayList<>();
        country.forEach( t->{
            CountryDTO countryDTOAux = new CountryDTO();
            utilBO.entityToDtoCustom(t, countryDTOAux, new ArrayList<>());
            countryDTOList.add(countryDTOAux);
        });

        return countryDTOList;
    }

    public Object listExample(CountryDTO countryDTO) {
        List<Country> country = new ArrayList<>();

        Country countryExemple = countryMapper.toEntity(countryDTO, new CycleAvoidingMappingContext());

        country = countryRepository.findAll(Example.of(countryExemple));

        List<CountryDTO> countryDTOList = new ArrayList<>();
        country.forEach( t->{
            CountryDTO countryDTOAux = new CountryDTO();
            utilBO.entityToDtoCustom(t, countryDTOAux, new ArrayList<>());
            countryDTOList.add(countryDTOAux);
        });

        return countryDTOList;
    }

    public Page<CountryDTO> paginationFull(Integer page, Integer pageSize, String sortBy, String direction, Map<String, Object> filterMap) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Page<CountryDTO> countryDTOPage = null;

        Specification<Country> spec = (root, query, criteriaBuilder) -> {
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

        countryDTOPage = countryRepository
                .findAll(spec,
                        PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(direction), sortBy)))
                .map(x -> {
                    CountryDTO countryDTOAux = new CountryDTO();
                    utilBO.entityToDtoCustom(x, countryDTOAux, new ArrayList<>());
                    return countryDTOAux;
                });


        return countryDTOPage;
    }

}
