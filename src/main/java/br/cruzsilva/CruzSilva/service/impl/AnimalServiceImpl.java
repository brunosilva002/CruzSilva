package br.cruzsilva.CruzSilva.service.impl;

import br.cruzsilva.CruzSilva.bo.AnimalBO;
import br.cruzsilva.CruzSilva.dto.AnimalDTO;
import br.cruzsilva.CruzSilva.dto.ResponseDTO;
import br.cruzsilva.CruzSilva.exception.BussineRuleException;
import br.cruzsilva.CruzSilva.exception.ExceptionMessage;
import br.cruzsilva.CruzSilva.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Map;

import java.util.List;

@Component
public class AnimalServiceImpl implements AnimalService {

    @Autowired
    ExceptionMessage exceptionMessage;

    @Autowired
    AnimalBO animalBO;

    @Override
    public ResponseDTO<AnimalDTO> save(AnimalDTO animalDTO) {
        ResponseDTO responseDTO = new ResponseDTO();

        try{
            responseDTO.setStatus(ResponseDTO.Status.SUCCESS);
            responseDTO.setData(animalBO.save(animalDTO));
            responseDTO.setCode(ResponseDTO.Code.SUCCESS.getCode());
            responseDTO.getMessagens().add(exceptionMessage.getMessage("operation.successfully", new Object[]{}));
        }catch (BussineRuleException e){
            responseDTO.setStatus(ResponseDTO.Status.ERROR);
            responseDTO.setCode(ResponseDTO.Code.ERROR_BUSINESS_RULE.getCode());
            responseDTO.getMessagens().add(e.getMessage());
            responseDTO.setData(animalDTO);
        } catch (Exception e){
            responseDTO.setStatus(ResponseDTO.Status.ERROR);
            responseDTO.setCode(ResponseDTO.Code.ERROR_GENERIC.getCode());
            responseDTO.getMessagens().add(e.getMessage());
            responseDTO.setData(animalDTO);
        }
        return responseDTO;
    }

    @Override
    public ResponseDTO<AnimalDTO> obtain(Long cdnAnimals) {
        ResponseDTO responseDTO = new ResponseDTO();

        try{
            responseDTO.setStatus(ResponseDTO.Status.SUCCESS);
            responseDTO.setData(animalBO.obtain(cdnAnimals));
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
    public ResponseDTO delete(Long cdnAnimals) {
        ResponseDTO responseDTO = new ResponseDTO();

        try{
            responseDTO.setStatus(ResponseDTO.Status.SUCCESS);
            animalBO.delete(cdnAnimals);
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
    public ResponseDTO<Page<AnimalDTO>> pagination(Integer page, Integer pageSize, String sortBy, String direction, Long filter) {
        ResponseDTO responseDTO = new ResponseDTO();

        try{
            responseDTO.setStatus(ResponseDTO.Status.SUCCESS);
            responseDTO.setData(animalBO.pagination(page, pageSize, sortBy, direction, filter));
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
    public ResponseDTO<List<AnimalDTO>> listAll() {
        ResponseDTO responseDTO = new ResponseDTO();

        try{
            responseDTO.setStatus(ResponseDTO.Status.SUCCESS);
            responseDTO.setData(animalBO.listAll());
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
    public ResponseDTO<List<AnimalDTO>> listExample(AnimalDTO animalDTO) {
        ResponseDTO responseDTO = new ResponseDTO();

        try{
            responseDTO.setStatus(ResponseDTO.Status.SUCCESS);
            responseDTO.setData(animalBO.listExample(animalDTO));
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
    public ResponseDTO<Page<AnimalDTO>> paginationFull(Integer page, Integer pageSize, String sortBy, String direction, Map<String, Object> filterMap) {
        ResponseDTO responseDTO = new ResponseDTO();

        try{
            responseDTO.setStatus(ResponseDTO.Status.SUCCESS);
            responseDTO.setData(animalBO.paginationFull(page, pageSize, sortBy, direction, filterMap));
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
