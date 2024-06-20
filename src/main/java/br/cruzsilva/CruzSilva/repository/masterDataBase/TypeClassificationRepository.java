package br.cruzsilva.CruzSilva.repository.masterDataBase;

import br.cruzsilva.CruzSilva.model.masterDataBase.TypeClassification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TypeClassificationRepository extends JpaRepository<TypeClassification, Long>, JpaSpecificationExecutor<TypeClassification> {
}
