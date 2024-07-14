package br.cruzsilva.CruzSilva.rest;

import br.cruzsilva.CruzSilva.dto.ChampionshipDTO;
import br.cruzsilva.CruzSilva.dto.ResponseDTO;
import br.cruzsilva.CruzSilva.service.ChampionshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/championship")
public class ChampionshipResource extends BaseResource {

    @Autowired
    ChampionshipService championshipService;

    @PostMapping("/save")
    public ResponseEntity<ResponseDTO<ChampionshipDTO>> save (@RequestBody ChampionshipDTO championshipDTO){
        return (ResponseEntity<ResponseDTO<ChampionshipDTO>>) findCodeReturn(championshipService.save(championshipDTO));
    }

    @GetMapping("/obtain")
    public ResponseEntity<ResponseDTO<ChampionshipDTO>> obtain (@RequestParam Long cdnChampionship){
        return (ResponseEntity<ResponseDTO<ChampionshipDTO>>) findCodeReturn(championshipService.obtain(cdnChampionship));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> delete (@RequestParam Long cdnChampionship){
        return (ResponseEntity<ResponseDTO>) findCodeReturn(championshipService.delete(cdnChampionship));
    }

    @GetMapping("/pagination")
    ResponseEntity<ResponseDTO<Page<ChampionshipDTO>>> pagination(@RequestParam(name= "page", defaultValue = "0") Integer page,
                               @RequestParam(name= "pageSize", defaultValue = "10") Integer pageSize,
                               @RequestParam(name= "sortBy", defaultValue = "cdnChampionship") String sortBy,
                               @RequestParam(name= "direction", defaultValue = "DESC") String direction,
                               @RequestParam(name = "filter",required = false) Long filter) {
        return (ResponseEntity<ResponseDTO<Page<ChampionshipDTO>>>) findCodeReturn(championshipService.pagination(page,pageSize,sortBy,direction,filter));
    }

    @PostMapping("/paginationFull")
    ResponseEntity<ResponseDTO<Page<ChampionshipDTO>>> paginationFull(   @RequestParam(name= "page", defaultValue = "0") Integer page,
                                                                    @RequestParam(name= "pageSize", defaultValue = "10") Integer pageSize,
                                                                    @RequestParam(name= "sortBy", defaultValue = "cdnChampionship") String sortBy,
                                                                    @RequestParam(name= "direction", defaultValue = "DESC") String direction,
                                                                    @RequestBody Map<String, Object> filterMap) {
        return (ResponseEntity<ResponseDTO<Page<ChampionshipDTO>>>) findCodeReturn(championshipService.paginationFull(page,pageSize,sortBy,direction,filterMap));
    }

    @PostMapping("/listAll")
    public ResponseEntity<ResponseDTO<List<ChampionshipDTO>>> listAll (){
        return (ResponseEntity<ResponseDTO<List<ChampionshipDTO>>>) findCodeReturn(championshipService.listAll());
    }

    @PostMapping("/listExample")
    public ResponseEntity<ResponseDTO<List<ChampionshipDTO>>> listExample (@RequestBody ChampionshipDTO championshipDTO){
        return (ResponseEntity<ResponseDTO<List<ChampionshipDTO>>>) findCodeReturn(championshipService.listExample(championshipDTO));
    }

}
