package br.cruzsilva.CruzSilva.repository.masterDataBase;

import br.cruzsilva.CruzSilva.model.masterDataBase.RewardKind;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RewardKindRepository extends JpaRepository<RewardKind, Long>, JpaSpecificationExecutor<RewardKind> {
}
