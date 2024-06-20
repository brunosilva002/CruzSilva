package br.cruzsilva.CruzSilva.rest;

import br.cruzsilva.CruzSilva.dto.RewardKindDTO;
import br.cruzsilva.CruzSilva.dto.ResponseDTO;
import br.cruzsilva.CruzSilva.service.RewardKindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/rewardkind")
public class RewardKindResource extends BaseResource {

    @Autowired
    RewardKindService rewardkindService;

    @PostMapping("/save")
    public ResponseEntity<ResponseDTO<RewardKindDTO>> save (@RequestBody RewardKindDTO rewardkindDTO){
        return (ResponseEntity<ResponseDTO<RewardKindDTO>>) findCodeReturn(rewardkindService.save(rewardkindDTO));
    }

    @GetMapping("/obtain")
    public ResponseEntity<ResponseDTO<RewardKindDTO>> obtain (@RequestParam Long cdnRewardKind){
        return (ResponseEntity<ResponseDTO<RewardKindDTO>>) findCodeReturn(rewardkindService.obtain(cdnRewardKind));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> delete (@RequestParam Long cdnRewardKind){
        return (ResponseEntity<ResponseDTO>) findCodeReturn(rewardkindService.delete(cdnRewardKind));
    }

    @GetMapping("/pagination")
    ResponseEntity<ResponseDTO<Page<RewardKindDTO>>> pagination(@RequestParam(name= "page", defaultValue = "0") Integer page,
                               @RequestParam(name= "pageSize", defaultValue = "10") Integer pageSize,
                               @RequestParam(name= "sortBy", defaultValue = "cdnRewardKind") String sortBy,
                               @RequestParam(name= "direction", defaultValue = "DESC") String direction,
                               @RequestParam(name = "filter",required = false) Long filter) {
        return (ResponseEntity<ResponseDTO<Page<RewardKindDTO>>>) findCodeReturn(rewardkindService.pagination(page,pageSize,sortBy,direction,filter));
    }

    @PostMapping("/paginationFull")
    ResponseEntity<ResponseDTO<Page<RewardKindDTO>>> paginationFull(   @RequestParam(name= "page", defaultValue = "0") Integer page,
                                                                    @RequestParam(name= "pageSize", defaultValue = "10") Integer pageSize,
                                                                    @RequestParam(name= "sortBy", defaultValue = "cdnRewardKind") String sortBy,
                                                                    @RequestParam(name= "direction", defaultValue = "DESC") String direction,
                                                                    @RequestBody Map<String, Object> filterMap) {
        return (ResponseEntity<ResponseDTO<Page<RewardKindDTO>>>) findCodeReturn(rewardkindService.paginationFull(page,pageSize,sortBy,direction,filterMap));
    }

    @PostMapping("/listAll")
    public ResponseEntity<ResponseDTO<List<RewardKindDTO>>> listAll (){
        return (ResponseEntity<ResponseDTO<List<RewardKindDTO>>>) findCodeReturn(rewardkindService.listAll());
    }

    @PostMapping("/listExample")
    public ResponseEntity<ResponseDTO<List<RewardKindDTO>>> listExample (@RequestBody RewardKindDTO rewardkindDTO){
        return (ResponseEntity<ResponseDTO<List<RewardKindDTO>>>) findCodeReturn(rewardkindService.listExample(rewardkindDTO));
    }

}
