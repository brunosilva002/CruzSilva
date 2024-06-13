package br.cruzsilva.CruzSilva.repository.masterDataBase;

import br.cruzsilva.CruzSilva.model.masterDataBase.RopingDivisionRank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RopingDivisionRankRepository extends JpaRepository<RopingDivisionRank, Long>, JpaSpecificationExecutor<RopingDivisionRank> {
}
