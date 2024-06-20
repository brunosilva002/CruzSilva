package br.cruzsilva.CruzSilva.repository.masterDataBase;

import br.cruzsilva.CruzSilva.model.masterDataBase.BarrelType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BarrelTypeRepository extends JpaRepository<BarrelType, Long>, JpaSpecificationExecutor<BarrelType> {
}
