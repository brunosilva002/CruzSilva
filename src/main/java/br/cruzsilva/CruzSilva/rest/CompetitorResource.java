package br.cruzsilva.CruzSilva.rest;

import br.cruzsilva.CruzSilva.dto.CompetitorDTO;
import br.cruzsilva.CruzSilva.dto.ResponseDTO;
import br.cruzsilva.CruzSilva.service.CompetitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/competitor")
public class CompetitorResource extends BaseResource {

    @Autowired
    CompetitorService competitorService;

    @PostMapping("/save")
    public ResponseEntity<ResponseDTO<CompetitorDTO>> save (@RequestBody CompetitorDTO competitorDTO){
        return (ResponseEntity<ResponseDTO<CompetitorDTO>>) findCodeReturn(competitorService.save(competitorDTO));
    }

    @GetMapping("/obtain")
    public ResponseEntity<ResponseDTO<CompetitorDTO>> obtain (@RequestParam Long cdnCompetitor){
        return (ResponseEntity<ResponseDTO<CompetitorDTO>>) findCodeReturn(competitorService.obtain(cdnCompetitor));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> delete (@RequestParam Long cdnCompetitor){
        return (ResponseEntity<ResponseDTO>) findCodeReturn(competitorService.delete(cdnCompetitor));
    }

    @GetMapping("/pagination")
    ResponseEntity<ResponseDTO<Page<CompetitorDTO>>> pagination(@RequestParam(name= "page", defaultValue = "0") Integer page,
                               @RequestParam(name= "pageSize", defaultValue = "10") Integer pageSize,
                               @RequestParam(name= "sortBy", defaultValue = "cdnCompetitor") String sortBy,
                               @RequestParam(name= "direction", defaultValue = "DESC") String direction,
                               @RequestParam(name = "filter",required = false) Long filter) {
        return (ResponseEntity<ResponseDTO<Page<CompetitorDTO>>>) findCodeReturn(competitorService.pagination(page,pageSize,sortBy,direction,filter));
    }

    @PostMapping("/paginationFull")
    ResponseEntity<ResponseDTO<Page<CompetitorDTO>>> paginationFull(   @RequestParam(name= "page", defaultValue = "0") Integer page,
                                                                    @RequestParam(name= "pageSize", defaultValue = "10") Integer pageSize,
                                                                    @RequestParam(name= "sortBy", defaultValue = "cdnCompetitor") String sortBy,
                                                                    @RequestParam(name= "direction", defaultValue = "DESC") String direction,
                                                                    @RequestBody Map<String, Object> filterMap) {
        return (ResponseEntity<ResponseDTO<Page<CompetitorDTO>>>) findCodeReturn(competitorService.paginationFull(page,pageSize,sortBy,direction,filterMap));
    }

    @PostMapping("/listAll")
    public ResponseEntity<ResponseDTO<List<CompetitorDTO>>> listAll (){
        return (ResponseEntity<ResponseDTO<List<CompetitorDTO>>>) findCodeReturn(competitorService.listAll());
    }

    @PostMapping("/listExample")
    public ResponseEntity<ResponseDTO<List<CompetitorDTO>>> listExample (@RequestBody CompetitorDTO competitorDTO){
        return (ResponseEntity<ResponseDTO<List<CompetitorDTO>>>) findCodeReturn(competitorService.listExample(competitorDTO));
    }

}
