package br.cruzsilva.CruzSilva.service;

import br.cruzsilva.CruzSilva.dto.*;
import br.cruzsilva.CruzSilva.dto.UserDTO;
import org.springframework.stereotype.Component;

@Component
public interface AuthService {

    ResponseDTO<UserDTO> authenticate(AuthenticationRequestDTO request);

    ResponseDTO<UserDTO> register(RegisterRequestDTO register);

    ResponseDTO<UserDTO> reNewToken(String email);
}
