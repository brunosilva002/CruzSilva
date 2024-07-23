package br.cruzsilva.CruzSilva.service.impl;

import br.cruzsilva.CruzSilva.bo.EventBO;
import br.cruzsilva.CruzSilva.dto.EventDTO;
import br.cruzsilva.CruzSilva.dto.ResponseDTO;
import br.cruzsilva.CruzSilva.exception.BussineRuleException;
import br.cruzsilva.CruzSilva.exception.ExceptionMessage;
import br.cruzsilva.CruzSilva.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Map;

import java.util.List;

@Component
public class EventServiceImpl implements EventService {

    @Autowired
    ExceptionMessage exceptionMessage;

    @Autowired
    EventBO eventBO;

    @Override
    public ResponseDTO<EventDTO> save(EventDTO eventDTO) {
        ResponseDTO responseDTO = new ResponseDTO();

        try{
            responseDTO.setStatus(ResponseDTO.Status.SUCCESS);
            responseDTO.setData(eventBO.save(eventDTO));
            responseDTO.setCode(ResponseDTO.Code.SUCCESS.getCode());
            responseDTO.getMessagens().add(exceptionMessage.getMessage("operation.successfully", new Object[]{}));
        }catch (BussineRuleException e){
            responseDTO.setStatus(ResponseDTO.Status.ERROR);
            responseDTO.setCode(ResponseDTO.Code.ERROR_BUSINESS_RULE.getCode());
            responseDTO.getMessagens().add(e.getMessage());
            responseDTO.setData(eventDTO);
        } catch (Exception e){
            responseDTO.setStatus(ResponseDTO.Status.ERROR);
            responseDTO.setCode(ResponseDTO.Code.ERROR_GENERIC.getCode());
            responseDTO.getMessagens().add(e.getMessage());
            responseDTO.setData(eventDTO);
        }
        return responseDTO;
    }

    @Override
    public ResponseDTO<EventDTO> obtain(Long cdnEvent) {
        ResponseDTO responseDTO = new ResponseDTO();

        try{
            responseDTO.setStatus(ResponseDTO.Status.SUCCESS);
            responseDTO.setData(eventBO.obtain(cdnEvent));
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
    public ResponseDTO delete(Long cdnEvent) {
        ResponseDTO responseDTO = new ResponseDTO();

        try{
            responseDTO.setStatus(ResponseDTO.Status.SUCCESS);
            eventBO.delete(cdnEvent);
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
    public ResponseDTO<Page<EventDTO>> pagination(Integer page, Integer pageSize, String sortBy, String direction, Long filter) {
        ResponseDTO responseDTO = new ResponseDTO();

        try{
            responseDTO.setStatus(ResponseDTO.Status.SUCCESS);
            responseDTO.setData(eventBO.pagination(page, pageSize, sortBy, direction, filter));
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
    public ResponseDTO<List<EventDTO>> listAll() {
        ResponseDTO responseDTO = new ResponseDTO();

        try{
            responseDTO.setStatus(ResponseDTO.Status.SUCCESS);
            responseDTO.setData(eventBO.listAll());
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
    public ResponseDTO<List<EventDTO>> listExample(EventDTO eventDTO) {
        ResponseDTO responseDTO = new ResponseDTO();

        try{
            responseDTO.setStatus(ResponseDTO.Status.SUCCESS);
            responseDTO.setData(eventBO.listExample(eventDTO));
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
    public ResponseDTO<Page<EventDTO>> paginationFull(Integer page, Integer pageSize, String sortBy, String direction, Map<String, Object> filterMap) {
        ResponseDTO responseDTO = new ResponseDTO();

        try{
            responseDTO.setStatus(ResponseDTO.Status.SUCCESS);
            responseDTO.setData(eventBO.paginationFull(page, pageSize, sortBy, direction, filterMap));
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
