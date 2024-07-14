package br.cruzsilva.CruzSilva.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentTypeDTO implements Serializable {
    private Long cdnPaymentType;
    private String name;
    private LocalDateTime creationDate;
    private String creationUser;
    private LocalDateTime updateDate;
    private String updateUser;
}
