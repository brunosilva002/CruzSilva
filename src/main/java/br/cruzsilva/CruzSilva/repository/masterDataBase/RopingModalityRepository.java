package br.cruzsilva.CruzSilva.repository.masterDataBase;

import br.cruzsilva.CruzSilva.model.masterDataBase.RopingModality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RopingModalityRepository extends JpaRepository<RopingModality, Long>, JpaSpecificationExecutor<RopingModality> {
}
