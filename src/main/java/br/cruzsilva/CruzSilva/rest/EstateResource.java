package br.cruzsilva.CruzSilva.rest;

import br.cruzsilva.CruzSilva.dto.EstateDTO;
import br.cruzsilva.CruzSilva.dto.ResponseDTO;
import br.cruzsilva.CruzSilva.service.EstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/estate")
public class EstateResource extends BaseResource {

    @Autowired
    EstateService estateService;

    @PostMapping("/save")
    public ResponseEntity<ResponseDTO<EstateDTO>> save (@RequestBody EstateDTO estateDTO){
        return (ResponseEntity<ResponseDTO<EstateDTO>>) findCodeReturn(estateService.save(estateDTO));
    }

    @GetMapping("/obtain")
    public ResponseEntity<ResponseDTO<EstateDTO>> obtain (@RequestParam Long cdnEstate){
        return (ResponseEntity<ResponseDTO<EstateDTO>>) findCodeReturn(estateService.obtain(cdnEstate));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> delete (@RequestParam Long cdnEstate){
        return (ResponseEntity<ResponseDTO>) findCodeReturn(estateService.delete(cdnEstate));
    }

    @GetMapping("/pagination")
    ResponseEntity<ResponseDTO<Page<EstateDTO>>> pagination(@RequestParam(name= "page", defaultValue = "0") Integer page,
                               @RequestParam(name= "pageSize", defaultValue = "10") Integer pageSize,
                               @RequestParam(name= "sortBy", defaultValue = "cdnEstate") String sortBy,
                               @RequestParam(name= "direction", defaultValue = "DESC") String direction,
                               @RequestParam(name = "filter",required = false) Long filter) {
        return (ResponseEntity<ResponseDTO<Page<EstateDTO>>>) findCodeReturn(estateService.pagination(page,pageSize,sortBy,direction,filter));
    }

    @PostMapping("/paginationFull")
    ResponseEntity<ResponseDTO<Page<EstateDTO>>> paginationFull(   @RequestParam(name= "page", defaultValue = "0") Integer page,
                                                                    @RequestParam(name= "pageSize", defaultValue = "10") Integer pageSize,
                                                                    @RequestParam(name= "sortBy", defaultValue = "cdnEstate") String sortBy,
                                                                    @RequestParam(name= "direction", defaultValue = "DESC") String direction,
                                                                    @RequestBody Map<String, Object> filterMap) {
        return (ResponseEntity<ResponseDTO<Page<EstateDTO>>>) findCodeReturn(estateService.paginationFull(page,pageSize,sortBy,direction,filterMap));
    }

    @PostMapping("/listAll")
    public ResponseEntity<ResponseDTO<List<EstateDTO>>> listAll (){
        return (ResponseEntity<ResponseDTO<List<EstateDTO>>>) findCodeReturn(estateService.listAll());
    }

    @PostMapping("/listExample")
    public ResponseEntity<ResponseDTO<List<EstateDTO>>> listExample (@RequestBody EstateDTO estateDTO){
        return (ResponseEntity<ResponseDTO<List<EstateDTO>>>) findCodeReturn(estateService.listExample(estateDTO));
    }

}
