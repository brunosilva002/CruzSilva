package br.cruzsilva.CruzSilva.service.impl;

import br.cruzsilva.CruzSilva.bo.AuthBO;
import br.cruzsilva.CruzSilva.dto.*;
import br.cruzsilva.CruzSilva.exception.BussineRuleException;
import br.cruzsilva.CruzSilva.exception.ExceptionMessage;
import br.cruzsilva.CruzSilva.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthServiceImpl implements AuthService {

    @Autowired
    ExceptionMessage exceptionMessage;
    @Autowired
    AuthBO authBO;

    @Override
    public ResponseDTO<UserDTO> authenticate(AuthenticationRequestDTO request) {
        ResponseDTO responseDTO = new ResponseDTO();

        try {
            responseDTO.setStatus(ResponseDTO.Status.SUCCESS);
            responseDTO.setData(authBO.authenticate(request));
            responseDTO.setCode(ResponseDTO.Code.SUCCESS.getCode());
            responseDTO.getMessagens().add(exceptionMessage.getMessage("operation.successfully"));
        } catch (BussineRuleException e) {
            responseDTO.setStatus(ResponseDTO.Status.ERROR);
            responseDTO.setCode(ResponseDTO.Code.ERROR_BUSINESS_RULE.getCode());
            responseDTO.getMessagens().add(e.getMessage());
        } catch (Exception e) {
            responseDTO.setStatus(ResponseDTO.Status.ERROR);
            responseDTO.setCode(ResponseDTO.Code.ERROR_GENERIC.getCode());
            responseDTO.getMessagens().add(e.getMessage());
        }
        return responseDTO;
    }

    @Override
    public ResponseDTO<UserDTO> register(RegisterRequestDTO register) {
        ResponseDTO responseDTO = new ResponseDTO();

        try {
            responseDTO.setStatus(ResponseDTO.Status.SUCCESS);
            responseDTO.setData(authBO.register(register));
            responseDTO.setCode(ResponseDTO.Code.SUCCESS.getCode());
            responseDTO.getMessagens().add(exceptionMessage.getMessage("operation.successfully"));
        } catch (BussineRuleException e) {
            responseDTO.setStatus(ResponseDTO.Status.ERROR);
            responseDTO.setCode(ResponseDTO.Code.ERROR_BUSINESS_RULE.getCode());
            responseDTO.getMessagens().add(e.getMessage());
        } catch (Exception e) {
            responseDTO.setStatus(ResponseDTO.Status.ERROR);
            responseDTO.setCode(ResponseDTO.Code.ERROR_GENERIC.getCode());
            responseDTO.getMessagens().add(e.getMessage());
        }
        return responseDTO;
    }

    @Override
    public ResponseDTO<UserDTO> reNewToken(String email) {
        ResponseDTO responseDTO = new ResponseDTO();

        try {
            responseDTO.setStatus(ResponseDTO.Status.SUCCESS);
            responseDTO.setData(authBO.reNewToken(email));
            responseDTO.setCode(ResponseDTO.Code.SUCCESS.getCode());
            responseDTO.getMessagens().add(exceptionMessage.getMessage("operation.successfully"));
        } catch (BussineRuleException e) {
            responseDTO.setStatus(ResponseDTO.Status.ERROR);
            responseDTO.setCode(ResponseDTO.Code.ERROR_BUSINESS_RULE.getCode());
            responseDTO.getMessagens().add(e.getMessage());
        } catch (Exception e) {
            responseDTO.setStatus(ResponseDTO.Status.ERROR);
            responseDTO.setCode(ResponseDTO.Code.ERROR_GENERIC.getCode());
            responseDTO.getMessagens().add(e.getMessage());
        }
        return responseDTO;
    }
}
