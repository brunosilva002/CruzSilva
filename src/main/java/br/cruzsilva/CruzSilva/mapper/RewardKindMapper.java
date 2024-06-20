package br.cruzsilva.CruzSilva.mapper;

import br.cruzsilva.CruzSilva.dto.RewardKindDTO;
import br.cruzsilva.CruzSilva.model.masterDataBase.RewardKind;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface RewardKindMapper  extends EntityMapper<RewardKindDTO, RewardKind>{
}
