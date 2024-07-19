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
public class EntryFormDTO implements Serializable {
    private Long cdnEntryForm;
    private String note;
    private Roping roping;
    private RopingDivisionDTO ropingDivision;
    private RopingTypeDTO ropingType;
    private CompetitorDTO competitor;
    private AnimalDTO animal;
    private List<PaymentDTO> payments = new ArrayList<>();
    private LocalDateTime creationDate;
    private String creationUser;
    private LocalDateTime updateDate;
    private String updateUser;
}
