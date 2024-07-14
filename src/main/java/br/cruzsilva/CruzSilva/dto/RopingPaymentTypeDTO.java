package br.cruzsilva.CruzSilva.dto;

import br.cruzsilva.CruzSilva.model.masterDataBase.PaymentType;
import br.cruzsilva.CruzSilva.model.masterDataBase.Roping;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.io.Serializable;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class RopingPaymentTypeDTO implements Serializable {
    private Long cdnRopingPaymentType;
    private RopingDTO roping;
    private PaymentTypeDTO paymentType;
}
