package br.cruzsilva.CruzSilva.repository.masterDataBase;

import br.cruzsilva.CruzSilva.model.masterDataBase.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface GenderRepository extends JpaRepository<Gender, Long>, JpaSpecificationExecutor<Gender> {
}
