package br.cruzsilva.CruzSilva.dto;

import br.cruzsilva.CruzSilva.model.masterDataBase.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class RopingDTO implements Serializable {
    private Long cdnRoping;
    private String name;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Boolean showInscription;
    private String url;
    private AddressDTO address;
    private RopingStatusDTO ropingStatus;
    private RopingModalityDTO ropingModality;
    private TrackDTO track;
    private List<RopingPaymentTypeDTO> ropingPaymentTypes = new ArrayList<>();
    private ChampionshipStageDTO championshipStage;
    private LocalDateTime creationDate;
    private String creationUser;
    private LocalDateTime updateDate;
    private String updateUser;
}
