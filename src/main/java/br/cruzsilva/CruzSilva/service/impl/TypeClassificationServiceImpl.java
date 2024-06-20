package br.cruzsilva.CruzSilva.service.impl;

import br.cruzsilva.CruzSilva.bo.TypeClassificationBO;
import br.cruzsilva.CruzSilva.dto.TypeClassificationDTO;
import br.cruzsilva.CruzSilva.dto.ResponseDTO;
import br.cruzsilva.CruzSilva.exception.BussineRuleException;
import br.cruzsilva.CruzSilva.exception.ExceptionMessage;
import br.cruzsilva.CruzSilva.service.TypeClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Map;

import java.util.List;

@Component
public class TypeClassificationServiceImpl implements TypeClassificationService {

    @Autowired
    ExceptionMessage exceptionMessage;

    @Autowired
    TypeClassificationBO typeclassificationBO;

    @Override
    public ResponseDTO<TypeClassificationDTO> save(TypeClassificationDTO typeclassificationDTO) {
        ResponseDTO responseDTO = new ResponseDTO();

        try{
            responseDTO.setStatus(ResponseDTO.Status.SUCCESS);
            responseDTO.setData(typeclassificationBO.save(typeclassificationDTO));
            responseDTO.setCode(ResponseDTO.Code.SUCCESS.getCode());
            responseDTO.getMessagens().add(exceptionMessage.getMessage("operation.successfully", new Object[]{}));
        }catch (BussineRuleException e){
            responseDTO.setStatus(ResponseDTO.Status.ERROR);
            responseDTO.setCode(ResponseDTO.Code.ERROR_BUSINESS_RULE.getCode());
            responseDTO.getMessagens().add(e.getMessage());
            responseDTO.setData(typeclassificationDTO);
        } catch (Exception e){
            responseDTO.setStatus(ResponseDTO.Status.ERROR);
            responseDTO.setCode(ResponseDTO.Code.ERROR_GENERIC.getCode());
            responseDTO.getMessagens().add(e.getMessage());
            responseDTO.setData(typeclassificationDTO);
        }
        return responseDTO;
    }

    @Override
    public ResponseDTO<TypeClassificationDTO> obtain(Long cdnTypeClassification) {
        ResponseDTO responseDTO = new ResponseDTO();

        try{
            responseDTO.setStatus(ResponseDTO.Status.SUCCESS);
            responseDTO.setData(typeclassificationBO.obtain(cdnTypeClassification));
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
    public ResponseDTO delete(Long cdnTypeClassification) {
        ResponseDTO responseDTO = new ResponseDTO();

        try{
            responseDTO.setStatus(ResponseDTO.Status.SUCCESS);
            typeclassificationBO.delete(cdnTypeClassification);
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
    public ResponseDTO<Page<TypeClassificationDTO>> pagination(Integer page, Integer pageSize, String sortBy, String direction, Long filter) {
        ResponseDTO responseDTO = new ResponseDTO();

        try{
            responseDTO.setStatus(ResponseDTO.Status.SUCCESS);
            responseDTO.setData(typeclassificationBO.pagination(page, pageSize, sortBy, direction, filter));
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
    public ResponseDTO<List<TypeClassificationDTO>> listAll() {
        ResponseDTO responseDTO = new ResponseDTO();

        try{
            responseDTO.setStatus(ResponseDTO.Status.SUCCESS);
            responseDTO.setData(typeclassificationBO.listAll());
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
    public ResponseDTO<List<TypeClassificationDTO>> listExample(TypeClassificationDTO typeclassificationDTO) {
        ResponseDTO responseDTO = new ResponseDTO();

        try{
            responseDTO.setStatus(ResponseDTO.Status.SUCCESS);
            responseDTO.setData(typeclassificationBO.listExample(typeclassificationDTO));
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
    public ResponseDTO<Page<TypeClassificationDTO>> paginationFull(Integer page, Integer pageSize, String sortBy, String direction, Map<String, Object> filterMap) {
        ResponseDTO responseDTO = new ResponseDTO();

        try{
            responseDTO.setStatus(ResponseDTO.Status.SUCCESS);
            responseDTO.setData(typeclassificationBO.paginationFull(page, pageSize, sortBy, direction, filterMap));
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
