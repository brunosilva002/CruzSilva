package br.cruzsilva.CruzSilva.service;

import br.cruzsilva.CruzSilva.dto.JudgeDTO;
import br.cruzsilva.CruzSilva.dto.ResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Map;

import java.util.List;

@Component
public interface JudgeService {
    ResponseDTO<JudgeDTO> save(JudgeDTO judgeDTO);

    ResponseDTO<JudgeDTO> obtain(Long cdnJudge);

    ResponseDTO<Page<JudgeDTO>> pagination(Integer page, Integer pageSize, String sortBy, String direction, Long filter);

    ResponseDTO<List<JudgeDTO>> listAll();

    ResponseDTO<List<JudgeDTO>> listExample(JudgeDTO judgeDTO);

    ResponseDTO delete(Long cdnJudge);

    ResponseDTO<Page<JudgeDTO>> paginationFull(Integer page, Integer pageSize, String sortBy, String direction, Map<String, Object> filterMap);
}
