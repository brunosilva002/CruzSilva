package br.cruzsilva.CruzSilva.dto;

import br.cruzsilva.CruzSilva.model.masterDataBase.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentDTO implements Serializable {
    private Long cdnPayment;
    private LocalDate paymentDate;
    private BigDecimal paymentValue;
    private Long numPayment;
    private PaymentTypeDTO paymentType;
    private EntryFormDTO entryForm;
}
