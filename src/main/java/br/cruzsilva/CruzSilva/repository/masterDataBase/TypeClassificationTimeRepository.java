package br.cruzsilva.CruzSilva.repository.masterDataBase;

import br.cruzsilva.CruzSilva.model.masterDataBase.TypeClassificationTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TypeClassificationTimeRepository extends JpaRepository<TypeClassificationTime, Long>, JpaSpecificationExecutor<TypeClassificationTime> {
}
