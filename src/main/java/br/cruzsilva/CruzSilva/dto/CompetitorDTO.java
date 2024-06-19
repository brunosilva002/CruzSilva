package br.cruzsilva.CruzSilva.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CompetitorDTO implements Serializable {
    private Long cdnCompetitor;
    private String name;
    private String nickName;
    private GenderDTO gender;
    private String cpf;
    private String handcapHeader;
    private String handcapHeeler;
    private String email;
    private AddressDTO address;
    private LocalDateTime creationDate;
    private String creationUser;
    private LocalDateTime updateDate;
    private String updateUser;
}
