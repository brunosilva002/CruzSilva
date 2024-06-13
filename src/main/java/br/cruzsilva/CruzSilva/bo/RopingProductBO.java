package br.cruzsilva.CruzSilva.bo;

import br.cruzsilva.CruzSilva.dto.RopingProductDTO;

import br.cruzsilva.CruzSilva.mapper.CycleAvoidingMappingContext;
import br.cruzsilva.CruzSilva.mapper.RopingProductMapper;
import br.cruzsilva.CruzSilva.model.masterDataBase.RopingProduct;
import br.cruzsilva.CruzSilva.repository.masterDataBase.RopingProductRepository;
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
public class RopingProductBO {

    @Autowired
    UtilBO utilBO;

    @Autowired
    RopingProductRepository ropingproductRepository;

    @Autowired
    RopingProductMapper ropingproductMapper;

    public RopingProductDTO save(RopingProductDTO ropingproductDTO) throws IllegalAccessException {

        RopingProduct ropingproduct = ropingproductMapper.toEntity(ropingproductDTO, new CycleAvoidingMappingContext());

        utilBO.assingObjectToList(ropingproduct, "ropingproduct");

        ropingproductRepository.save(ropingproduct);

        utilBO.entityToDtoCustom(ropingproduct, ropingproductDTO, new ArrayList<>());

        return ropingproductDTO;

    }

    public RopingProductDTO obtain(Long cdnRopingProduct) {
        RopingProduct ropingproduct = new RopingProduct();

        ropingproduct = ropingproductRepository.getReferenceById(cdnRopingProduct);

        RopingProductDTO ropingproductDTO = new RopingProductDTO(); //ropingproductMapper.toDto(ropingproduct, new CycleAvoidingMappingContext());

        utilBO.entityToDtoCustom(ropingproduct, ropingproductDTO, new ArrayList<>());

        return ropingproductDTO;
    }

    public void delete(Long cdnRopingProduct) {
        RopingProduct ropingproduct = new RopingProduct(cdnRopingProduct);
        utilBO.checkRelationship(ropingproduct,cdnRopingProduct);
        ropingproductRepository.deleteById(cdnRopingProduct);

    }

    public Page<RopingProductDTO> pagination(Integer page, Integer pageSize, String sortBy, String direction, Long filter) {

        RopingProduct ropingproduct = new RopingProduct();
        return ropingproductRepository
                .findAll(Example.of(ropingproduct),
                        PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(direction), sortBy)))
                .map(x -> {
                    RopingProductDTO ropingproductDTOAux = new RopingProductDTO();
                    utilBO.entityToDtoCustom(x, ropingproductDTOAux, new ArrayList<>());
                    return ropingproductDTOAux;
                });
    }

    public List<RopingProductDTO> listAll() {
        List<RopingProduct> ropingproduct = new ArrayList<>();

        ropingproduct = ropingproductRepository.findAll();

        //List<RopingProductDTO> ropingproductDTO = ropingproductMapper.toDto(ropingproduct, new CycleAvoidingMappingContext());
        List<RopingProductDTO> ropingproductDTOList = new ArrayList<>();
        ropingproduct.forEach( t->{
            RopingProductDTO ropingproductDTOAux = new RopingProductDTO();
            utilBO.entityToDtoCustom(t, ropingproductDTOAux, new ArrayList<>());
            ropingproductDTOList.add(ropingproductDTOAux);
        });

        return ropingproductDTOList;
    }

    public Object listExample(RopingProductDTO ropingproductDTO) {
        List<RopingProduct> ropingproduct = new ArrayList<>();

        RopingProduct ropingproductExemple = ropingproductMapper.toEntity(ropingproductDTO, new CycleAvoidingMappingContext());

        ropingproduct = ropingproductRepository.findAll(Example.of(ropingproductExemple));

        List<RopingProductDTO> ropingproductDTOList = new ArrayList<>();
        ropingproduct.forEach( t->{
            RopingProductDTO ropingproductDTOAux = new RopingProductDTO();
            utilBO.entityToDtoCustom(t, ropingproductDTOAux, new ArrayList<>());
            ropingproductDTOList.add(ropingproductDTOAux);
        });

        return ropingproductDTOList;
    }

    public Page<RopingProductDTO> paginationFull(Integer page, Integer pageSize, String sortBy, String direction, Map<String, Object> filterMap) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Page<RopingProductDTO> ropingproductDTOPage = null;

        Specification<RopingProduct> spec = (root, query, criteriaBuilder) -> {
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

        ropingproductDTOPage = ropingproductRepository
                .findAll(spec,
                        PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(direction), sortBy)))
                .map(x -> {
                    RopingProductDTO ropingproductDTOAux = new RopingProductDTO();
                    utilBO.entityToDtoCustom(x, ropingproductDTOAux, new ArrayList<>());
                    return ropingproductDTOAux;
                });


        return ropingproductDTOPage;
    }

}
