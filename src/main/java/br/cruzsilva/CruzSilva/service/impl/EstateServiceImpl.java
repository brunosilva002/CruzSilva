package br.cruzsilva.CruzSilva.service.impl;

import br.cruzsilva.CruzSilva.bo.EstateBO;
import br.cruzsilva.CruzSilva.dto.EstateDTO;
import br.cruzsilva.CruzSilva.dto.ResponseDTO;
import br.cruzsilva.CruzSilva.exception.BussineRuleException;
import br.cruzsilva.CruzSilva.exception.ExceptionMessage;
import br.cruzsilva.CruzSilva.service.EstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Map;

import java.util.List;

@Component
public class EstateServiceImpl implements EstateService {

    @Autowired
    ExceptionMessage exceptionMessage;

    @Autowired
    EstateBO estateBO;

    @Override
    public ResponseDTO<EstateDTO> save(EstateDTO estateDTO) {
        ResponseDTO responseDTO = new ResponseDTO();

        try{
            responseDTO.setStatus(ResponseDTO.Status.SUCCESS);
            responseDTO.setData(estateBO.save(estateDTO));
            responseDTO.setCode(ResponseDTO.Code.SUCCESS.getCode());
            responseDTO.getMessagens().add(exceptionMessage.getMessage("operation.successfully", new Object[]{}));
        }catch (BussineRuleException e){
            responseDTO.setStatus(ResponseDTO.Status.ERROR);
            responseDTO.setCode(ResponseDTO.Code.ERROR_BUSINESS_RULE.getCode());
            responseDTO.getMessagens().add(e.getMessage());
            responseDTO.setData(estateDTO);
        } catch (Exception e){
            responseDTO.setStatus(ResponseDTO.Status.ERROR);
            responseDTO.setCode(ResponseDTO.Code.ERROR_GENERIC.getCode());
            responseDTO.getMessagens().add(e.getMessage());
            responseDTO.setData(estateDTO);
        }
        return responseDTO;
    }

    @Override
    public ResponseDTO<EstateDTO> obtain(Long cdnEstate) {
        ResponseDTO responseDTO = new ResponseDTO();

        try{
            responseDTO.setStatus(ResponseDTO.Status.SUCCESS);
            responseDTO.setData(estateBO.obtain(cdnEstate));
            responseDTO.setCode(ResponseDTO.Code.SUCCESS.getCode());
            responseDTO.getMessagens().add(exceptionMessage.getMessage("operation.successfully", new Object[]{}));
        }catch (BussineRuleException e){
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
    public ResponseDTO delete(Long cdnEstate) {
        ResponseDTO responseDTO = new ResponseDTO();

        try{
            responseDTO.setStatus(ResponseDTO.Status.SUCCESS);
            estateBO.delete(cdnEstate);
            responseDTO.setCode(ResponseDTO.Code.SUCCESS.getCode());
            responseDTO.getMessagens().add(exceptionMessage.getMessage("operation.successfully", new Object[]{}));
        }catch (BussineRuleException e){
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
    public ResponseDTO<Page<EstateDTO>> pagination(Integer page, Integer pageSize, String sortBy, String direction, Long filter) {
        ResponseDTO responseDTO = new ResponseDTO();

        try{
            responseDTO.setStatus(ResponseDTO.Status.SUCCESS);
            responseDTO.setData(estateBO.pagination(page, pageSize, sortBy, direction, filter));
            responseDTO.setCode(ResponseDTO.Code.SUCCESS.getCode());
            responseDTO.getMessagens().add(exceptionMessage.getMessage("operation.successfully", new Object[]{}));
        }catch (BussineRuleException e){
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
    public ResponseDTO<List<EstateDTO>> listAll() {
        ResponseDTO responseDTO = new ResponseDTO();

        try{
            responseDTO.setStatus(ResponseDTO.Status.SUCCESS);
            responseDTO.setData(estateBO.listAll());
            responseDTO.setCode(ResponseDTO.Code.SUCCESS.getCode());
            responseDTO.getMessagens().add(exceptionMessage.getMessage("operation.successfully", new Object[]{}));
        }catch (BussineRuleException e){
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
    public ResponseDTO<List<EstateDTO>> listExample(EstateDTO estateDTO) {
        ResponseDTO responseDTO = new ResponseDTO();

        try{
            responseDTO.setStatus(ResponseDTO.Status.SUCCESS);
            responseDTO.setData(estateBO.listExample(estateDTO));
            responseDTO.setCode(ResponseDTO.Code.SUCCESS.getCode());
            responseDTO.getMessagens().add(exceptionMessage.getMessage("operation.successfully", new Object[]{}));
        }catch (BussineRuleException e){
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
    public ResponseDTO<Page<EstateDTO>> paginationFull(Integer page, Integer pageSize, String sortBy, String direction, Map<String, Object> filterMap) {
        ResponseDTO responseDTO = new ResponseDTO();

        try{
            responseDTO.setStatus(ResponseDTO.Status.SUCCESS);
            responseDTO.setData(estateBO.paginationFull(page, pageSize, sortBy, direction, filterMap));
            responseDTO.setCode(ResponseDTO.Code.SUCCESS.getCode());
            responseDTO.getMessagens().add(exceptionMessage.getMessage("operation.successfully", new Object[]{}));
        }catch (BussineRuleException e){
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
