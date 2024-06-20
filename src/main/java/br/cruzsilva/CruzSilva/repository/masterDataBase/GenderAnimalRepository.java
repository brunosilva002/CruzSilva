package br.cruzsilva.CruzSilva.repository.masterDataBase;

import br.cruzsilva.CruzSilva.model.masterDataBase.GenderAnimal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface GenderAnimalRepository extends JpaRepository<GenderAnimal, Long>, JpaSpecificationExecutor<GenderAnimal> {
}
