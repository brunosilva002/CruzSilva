package br.cruzsilva.CruzSilva.repository.masterDataBase;

import br.cruzsilva.CruzSilva.model.masterDataBase.RopingPaymentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RopingPaymentTypeRepository extends JpaRepository<RopingPaymentType, Long>, JpaSpecificationExecutor<RopingPaymentType> {
}
