package br.cruzsilva.CruzSilva.repository.masterDataBase;

import br.cruzsilva.CruzSilva.model.masterDataBase.ChampionshipStage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ChampionshipStageRepository extends JpaRepository<ChampionshipStage, Long>, JpaSpecificationExecutor<ChampionshipStage> {
}
