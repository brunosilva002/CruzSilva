package br.cruzsilva.CruzSilva.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticatoinResponseDTO {

    private String token;
    private Date timeOut;
    private Date timeAt;
    private Long cdnUser;
}
