package br.cruzsilva.CruzSilva.service;

import br.cruzsilva.CruzSilva.dto.RewardKindDTO;
import br.cruzsilva.CruzSilva.dto.ResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Map;

import java.util.List;

@Component
public interface RewardKindService {
    ResponseDTO<RewardKindDTO> save(RewardKindDTO rewardkindDTO);

    ResponseDTO<RewardKindDTO> obtain(Long cdnRewardKind);

    ResponseDTO<Page<RewardKindDTO>> pagination(Integer page, Integer pageSize, String sortBy, String direction, Long filter);

    ResponseDTO<List<RewardKindDTO>> listAll();

    ResponseDTO<List<RewardKindDTO>> listExample(RewardKindDTO rewardkindDTO);

    ResponseDTO delete(Long cdnRewardKind);

    ResponseDTO<Page<RewardKindDTO>> paginationFull(Integer page, Integer pageSize, String sortBy, String direction, Map<String, Object> filterMap);
}
