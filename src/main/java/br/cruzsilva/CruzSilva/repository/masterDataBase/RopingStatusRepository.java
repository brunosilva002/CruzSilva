package br.cruzsilva.CruzSilva.repository.masterDataBase;

import br.cruzsilva.CruzSilva.model.masterDataBase.RopingStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RopingStatusRepository extends JpaRepository<RopingStatus, Long>, JpaSpecificationExecutor<RopingStatus> {
}
