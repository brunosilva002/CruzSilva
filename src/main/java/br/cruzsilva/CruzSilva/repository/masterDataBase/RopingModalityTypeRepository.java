package br.cruzsilva.CruzSilva.repository.masterDataBase;

import br.cruzsilva.CruzSilva.model.masterDataBase.RopingModalityType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RopingModalityTypeRepository extends JpaRepository<RopingModalityType, Long>, JpaSpecificationExecutor<RopingModalityType> {
}
