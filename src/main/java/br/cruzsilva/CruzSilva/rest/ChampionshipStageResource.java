package br.cruzsilva.CruzSilva.rest;

import br.cruzsilva.CruzSilva.dto.ChampionshipStageDTO;
import br.cruzsilva.CruzSilva.dto.ResponseDTO;
import br.cruzsilva.CruzSilva.service.ChampionshipStageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/championshipstage")
public class ChampionshipStageResource extends BaseResource {

    @Autowired
    ChampionshipStageService championshipstageService;

    @PostMapping("/save")
    public ResponseEntity<ResponseDTO<ChampionshipStageDTO>> save (@RequestBody ChampionshipStageDTO championshipstageDTO){
        return (ResponseEntity<ResponseDTO<ChampionshipStageDTO>>) findCodeReturn(championshipstageService.save(championshipstageDTO));
    }

    @GetMapping("/obtain")
    public ResponseEntity<ResponseDTO<ChampionshipStageDTO>> obtain (@RequestParam Long cdnChampionshipStage){
        return (ResponseEntity<ResponseDTO<ChampionshipStageDTO>>) findCodeReturn(championshipstageService.obtain(cdnChampionshipStage));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> delete (@RequestParam Long cdnChampionshipStage){
        return (ResponseEntity<ResponseDTO>) findCodeReturn(championshipstageService.delete(cdnChampionshipStage));
    }

    @GetMapping("/pagination")
    ResponseEntity<ResponseDTO<Page<ChampionshipStageDTO>>> pagination(@RequestParam(name= "page", defaultValue = "0") Integer page,
                               @RequestParam(name= "pageSize", defaultValue = "10") Integer pageSize,
                               @RequestParam(name= "sortBy", defaultValue = "cdnChampionshipStage") String sortBy,
                               @RequestParam(name= "direction", defaultValue = "DESC") String direction,
                               @RequestParam(name = "filter",required = false) Long filter) {
        return (ResponseEntity<ResponseDTO<Page<ChampionshipStageDTO>>>) findCodeReturn(championshipstageService.pagination(page,pageSize,sortBy,direction,filter));
    }

    @PostMapping("/paginationFull")
    ResponseEntity<ResponseDTO<Page<ChampionshipStageDTO>>> paginationFull(   @RequestParam(name= "page", defaultValue = "0") Integer page,
                                                                    @RequestParam(name= "pageSize", defaultValue = "10") Integer pageSize,
                                                                    @RequestParam(name= "sortBy", defaultValue = "cdnChampionshipStage") String sortBy,
                                                                    @RequestParam(name= "direction", defaultValue = "DESC") String direction,
                                                                    @RequestBody Map<String, Object> filterMap) {
        return (ResponseEntity<ResponseDTO<Page<ChampionshipStageDTO>>>) findCodeReturn(championshipstageService.paginationFull(page,pageSize,sortBy,direction,filterMap));
    }

    @PostMapping("/listAll")
    public ResponseEntity<ResponseDTO<List<ChampionshipStageDTO>>> listAll (){
        return (ResponseEntity<ResponseDTO<List<ChampionshipStageDTO>>>) findCodeReturn(championshipstageService.listAll());
    }

    @PostMapping("/listExample")
    public ResponseEntity<ResponseDTO<List<ChampionshipStageDTO>>> listExample (@RequestBody ChampionshipStageDTO championshipstageDTO){
        return (ResponseEntity<ResponseDTO<List<ChampionshipStageDTO>>>) findCodeReturn(championshipstageService.listExample(championshipstageDTO));
    }

}
