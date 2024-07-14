package br.cruzsilva.CruzSilva.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

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
public class TrackDTO implements Serializable {
    private Long cdnRoping;
    private String name;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private AddressDTO address;
    private LocalDateTime creationDate;
    private String creationUser;
    private LocalDateTime updateDate;
    private String updateUser;

    private Boolean showInscription;
    private String url;
    private RopingStatusDTO ropingStatus;
    private RopingModalityDTO ropingModality;
    private List<PaymentTypeDTO> paymentTypes = new ArrayList<>();
}
