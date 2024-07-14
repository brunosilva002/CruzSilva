package br.cruzsilva.CruzSilva.mapper;

import br.cruzsilva.CruzSilva.dto.TrackStatusDTO;
import br.cruzsilva.CruzSilva.model.masterDataBase.TrackStatus;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface TrackStatusMapper  extends EntityMapper<TrackStatusDTO, TrackStatus>{
}
