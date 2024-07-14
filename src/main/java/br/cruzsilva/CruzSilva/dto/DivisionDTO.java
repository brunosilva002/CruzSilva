package br.cruzsilva.CruzSilva.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class DivisionDTO implements Serializable {
    private Long cdnDivision;
    private String name;
    private String gender;
    private Boolean proAmCabeca;
    private Boolean proAmPe;
    private Boolean incentive;
    private Boolean testHorse;
    private Boolean considerRanking;
}
