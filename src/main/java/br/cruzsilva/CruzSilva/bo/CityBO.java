package br.cruzsilva.CruzSilva.bo;

import br.cruzsilva.CruzSilva.dto.CityDTO;

import br.cruzsilva.CruzSilva.mapper.CycleAvoidingMappingContext;
import br.cruzsilva.CruzSilva.mapper.CityMapper;
import br.cruzsilva.CruzSilva.model.masterDataBase.City;
import br.cruzsilva.CruzSilva.repository.masterDataBase.CityRepository;
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
public class CityBO {

    @Autowired
    UtilBO utilBO;

    @Autowired
    CityRepository cityRepository;

    @Autowired
    CityMapper cityMapper;

    public CityDTO save(CityDTO cityDTO) throws IllegalAccessException {

        City city = cityMapper.toEntity(cityDTO, new CycleAvoidingMappingContext());

        utilBO.assingObjectToList(city, "city");

        cityRepository.save(city);

        utilBO.entityToDtoCustom(city, cityDTO, new ArrayList<>());

        return cityDTO;

    }

    public CityDTO obtain(Long cdnCity) {
        City city = new City();

        city = cityRepository.getReferenceById(cdnCity);

        CityDTO cityDTO = new CityDTO(); //cityMapper.toDto(city, new CycleAvoidingMappingContext());

        utilBO.entityToDtoCustom(city, cityDTO, new ArrayList<>());

        return cityDTO;
    }

    public void delete(Long cdnCity) {
        City city = new City(cdnCity);
        utilBO.checkRelationship(city,cdnCity);
        cityRepository.deleteById(cdnCity);

    }

    public Page<CityDTO> pagination(Integer page, Integer pageSize, String sortBy, String direction, Long filter) {

        City city = new City();
        return cityRepository
                .findAll(Example.of(city),
                        PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(direction), sortBy)))
                .map(x -> {
                    CityDTO cityDTOAux = new CityDTO();
                    utilBO.entityToDtoCustom(x, cityDTOAux, new ArrayList<>());
                    return cityDTOAux;
                });
    }

    public List<CityDTO> listAll() {
        List<City> city = new ArrayList<>();

        city = cityRepository.findAll();

        //List<CityDTO> cityDTO = cityMapper.toDto(city, new CycleAvoidingMappingContext());
        List<CityDTO> cityDTOList = new ArrayList<>();
        city.forEach( t->{
            CityDTO cityDTOAux = new CityDTO();
            utilBO.entityToDtoCustom(t, cityDTOAux, new ArrayList<>());
            cityDTOList.add(cityDTOAux);
        });

        return cityDTOList;
    }

    public Object listExample(CityDTO cityDTO) {
        List<City> city = new ArrayList<>();

        City cityExemple = cityMapper.toEntity(cityDTO, new CycleAvoidingMappingContext());

        city = cityRepository.findAll(Example.of(cityExemple));

        List<CityDTO> cityDTOList = new ArrayList<>();
        city.forEach( t->{
            CityDTO cityDTOAux = new CityDTO();
            utilBO.entityToDtoCustom(t, cityDTOAux, new ArrayList<>());
            cityDTOList.add(cityDTOAux);
        });

        return cityDTOList;
    }

    public Page<CityDTO> paginationFull(Integer page, Integer pageSize, String sortBy, String direction, Map<String, Object> filterMap) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Page<CityDTO> cityDTOPage = null;

        Specification<City> spec = (root, query, criteriaBuilder) -> {
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

        cityDTOPage = cityRepository
                .findAll(spec,
                        PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(direction), sortBy)))
                .map(x -> {
                    CityDTO cityDTOAux = new CityDTO();
                    utilBO.entityToDtoCustom(x, cityDTOAux, new ArrayList<>());
                    return cityDTOAux;
                });


        return cityDTOPage;
    }

}
