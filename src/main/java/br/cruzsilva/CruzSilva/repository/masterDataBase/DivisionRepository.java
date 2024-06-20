package br.cruzsilva.CruzSilva.repository.masterDataBase;

import br.cruzsilva.CruzSilva.model.masterDataBase.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DivisionRepository extends JpaRepository<Division, Long>, JpaSpecificationExecutor<Division> {
}
