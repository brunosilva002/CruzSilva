package br.cruzsilva.CruzSilva.service.impl;

import br.cruzsilva.CruzSilva.bo.RopingStatusBO;
import br.cruzsilva.CruzSilva.dto.RopingStatusDTO;
import br.cruzsilva.CruzSilva.dto.ResponseDTO;
import br.cruzsilva.CruzSilva.exception.BussineRuleException;
import br.cruzsilva.CruzSilva.exception.ExceptionMessage;
import br.cruzsilva.CruzSilva.service.RopingStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Map;

import java.util.List;

@Component
public class RopingStatusServiceImpl implements RopingStatusService {

    @Autowired
    ExceptionMessage exceptionMessage;

    @Autowired
    RopingStatusBO ropingstatusBO;

    @Override
    public ResponseDTO<RopingStatusDTO> save(RopingStatusDTO ropingstatusDTO) {
        ResponseDTO responseDTO = new ResponseDTO();

        try{
            responseDTO.setStatus(ResponseDTO.Status.SUCCESS);
            responseDTO.setData(ropingstatusBO.save(ropingstatusDTO));
            responseDTO.setCode(ResponseDTO.Code.SUCCESS.getCode());
            responseDTO.getMessagens().add(exceptionMessage.getMessage("operation.successfully", new Object[]{}));
        }catch (BussineRuleException e){
            responseDTO.setStatus(ResponseDTO.Status.ERROR);
            responseDTO.setCode(ResponseDTO.Code.ERROR_BUSINESS_RULE.getCode());
            responseDTO.getMessagens().add(e.getMessage());
            responseDTO.setData(ropingstatusDTO);
        } catch (Exception e){
            responseDTO.setStatus(ResponseDTO.Status.ERROR);
            responseDTO.setCode(ResponseDTO.Code.ERROR_GENERIC.getCode());
            responseDTO.getMessagens().add(e.getMessage());
            responseDTO.setData(ropingstatusDTO);
        }
        return responseDTO;
    }

    @Override
    public ResponseDTO<RopingStatusDTO> obtain(Long cdnRopingStatus) {
        ResponseDTO responseDTO = new ResponseDTO();

        try{
            responseDTO.setStatus(ResponseDTO.Status.SUCCESS);
            responseDTO.setData(ropingstatusBO.obtain(cdnRopingStatus));
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
    public ResponseDTO delete(Long cdnRopingStatus) {
        ResponseDTO responseDTO = new ResponseDTO();

        try{
            responseDTO.setStatus(ResponseDTO.Status.SUCCESS);
            ropingstatusBO.delete(cdnRopingStatus);
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
    public ResponseDTO<Page<RopingStatusDTO>> pagination(Integer page, Integer pageSize, String sortBy, String direction, Long filter) {
        ResponseDTO responseDTO = new ResponseDTO();

        try{
            responseDTO.setStatus(ResponseDTO.Status.SUCCESS);
            responseDTO.setData(ropingstatusBO.pagination(page, pageSize, sortBy, direction, filter));
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
    public ResponseDTO<List<RopingStatusDTO>> listAll() {
        ResponseDTO responseDTO = new ResponseDTO();

        try{
            responseDTO.setStatus(ResponseDTO.Status.SUCCESS);
            responseDTO.setData(ropingstatusBO.listAll());
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
    public ResponseDTO<List<RopingStatusDTO>> listExample(RopingStatusDTO ropingstatusDTO) {
        ResponseDTO responseDTO = new ResponseDTO();

        try{
            responseDTO.setStatus(ResponseDTO.Status.SUCCESS);
            responseDTO.setData(ropingstatusBO.listExample(ropingstatusDTO));
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
    public ResponseDTO<Page<RopingStatusDTO>> paginationFull(Integer page, Integer pageSize, String sortBy, String direction, Map<String, Object> filterMap) {
        ResponseDTO responseDTO = new ResponseDTO();

        try{
            responseDTO.setStatus(ResponseDTO.Status.SUCCESS);
            responseDTO.setData(ropingstatusBO.paginationFull(page, pageSize, sortBy, direction, filterMap));
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
