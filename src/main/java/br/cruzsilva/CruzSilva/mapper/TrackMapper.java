package br.cruzsilva.CruzSilva.mapper;

import br.cruzsilva.CruzSilva.dto.TrackDTO;
import br.cruzsilva.CruzSilva.model.masterDataBase.Track;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface TrackMapper  extends EntityMapper<TrackDTO, Track>{
}
