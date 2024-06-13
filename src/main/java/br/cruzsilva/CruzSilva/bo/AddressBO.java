package br.cruzsilva.CruzSilva.bo;

import br.cruzsilva.CruzSilva.dto.AddressDTO;

import br.cruzsilva.CruzSilva.mapper.CycleAvoidingMappingContext;
import br.cruzsilva.CruzSilva.mapper.AddressMapper;
import br.cruzsilva.CruzSilva.model.masterDataBase.Address;
import br.cruzsilva.CruzSilva.repository.masterDataBase.AddressRepository;
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
public class AddressBO {

    @Autowired
    UtilBO utilBO;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    AddressMapper addressMapper;

    public AddressDTO save(AddressDTO addressDTO) throws IllegalAccessException {

        Address address = addressMapper.toEntity(addressDTO, new CycleAvoidingMappingContext());

        utilBO.assingObjectToList(address, "address");

        addressRepository.save(address);

        utilBO.entityToDtoCustom(address, addressDTO, new ArrayList<>());

        return addressDTO;

    }

    public AddressDTO obtain(Long cdnAddress) {
        Address address = new Address();

        address = addressRepository.getReferenceById(cdnAddress);

        AddressDTO addressDTO = new AddressDTO(); //addressMapper.toDto(address, new CycleAvoidingMappingContext());

        utilBO.entityToDtoCustom(address, addressDTO, new ArrayList<>());

        return addressDTO;
    }

    public void delete(Long cdnAddress) {
        Address address = new Address(cdnAddress);
        utilBO.checkRelationship(address,cdnAddress);
        addressRepository.deleteById(cdnAddress);

    }

    public Page<AddressDTO> pagination(Integer page, Integer pageSize, String sortBy, String direction, Long filter) {

        Address address = new Address();
        return addressRepository
                .findAll(Example.of(address),
                        PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(direction), sortBy)))
                .map(x -> {
                    AddressDTO addressDTOAux = new AddressDTO();
                    utilBO.entityToDtoCustom(x, addressDTOAux, new ArrayList<>());
                    return addressDTOAux;
                });
    }

    public List<AddressDTO> listAll() {
        List<Address> address = new ArrayList<>();

        address = addressRepository.findAll();

        //List<AddressDTO> addressDTO = addressMapper.toDto(address, new CycleAvoidingMappingContext());
        List<AddressDTO> addressDTOList = new ArrayList<>();
        address.forEach( t->{
            AddressDTO addressDTOAux = new AddressDTO();
            utilBO.entityToDtoCustom(t, addressDTOAux, new ArrayList<>());
            addressDTOList.add(addressDTOAux);
        });

        return addressDTOList;
    }

    public Object listExample(AddressDTO addressDTO) {
        List<Address> address = new ArrayList<>();

        Address addressExemple = addressMapper.toEntity(addressDTO, new CycleAvoidingMappingContext());

        address = addressRepository.findAll(Example.of(addressExemple));

        List<AddressDTO> addressDTOList = new ArrayList<>();
        address.forEach( t->{
            AddressDTO addressDTOAux = new AddressDTO();
            utilBO.entityToDtoCustom(t, addressDTOAux, new ArrayList<>());
            addressDTOList.add(addressDTOAux);
        });

        return addressDTOList;
    }

    public Page<AddressDTO> paginationFull(Integer page, Integer pageSize, String sortBy, String direction, Map<String, Object> filterMap) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Page<AddressDTO> addressDTOPage = null;

        Specification<Address> spec = (root, query, criteriaBuilder) -> {
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

        addressDTOPage = addressRepository
                .findAll(spec,
                        PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(direction), sortBy)))
                .map(x -> {
                    AddressDTO addressDTOAux = new AddressDTO();
                    utilBO.entityToDtoCustom(x, addressDTOAux, new ArrayList<>());
                    return addressDTOAux;
                });


        return addressDTOPage;
    }

}
