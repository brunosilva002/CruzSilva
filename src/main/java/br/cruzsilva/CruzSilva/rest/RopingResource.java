package br.cruzsilva.CruzSilva.rest;

import br.cruzsilva.CruzSilva.dto.RopingDTO;
import br.cruzsilva.CruzSilva.dto.ResponseDTO;
import br.cruzsilva.CruzSilva.service.RopingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/roping")
public class RopingResource extends BaseResource {

    @Autowired
    RopingService ropingService;

    @PostMapping("/save")
    public ResponseEntity<ResponseDTO<RopingDTO>> save (@RequestBody RopingDTO ropingDTO){
        return (ResponseEntity<ResponseDTO<RopingDTO>>) findCodeReturn(ropingService.save(ropingDTO));
    }

    @GetMapping("/obtain")
    public ResponseEntity<ResponseDTO<RopingDTO>> obtain (@RequestParam Long cdnRoping){
        return (ResponseEntity<ResponseDTO<RopingDTO>>) findCodeReturn(ropingService.obtain(cdnRoping));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> delete (@RequestParam Long cdnRoping){
        return (ResponseEntity<ResponseDTO>) findCodeReturn(ropingService.delete(cdnRoping));
    }

    @GetMapping("/pagination")
    ResponseEntity<ResponseDTO<Page<RopingDTO>>> pagination(@RequestParam(name= "page", defaultValue = "0") Integer page,
                               @RequestParam(name= "pageSize", defaultValue = "10") Integer pageSize,
                               @RequestParam(name= "sortBy", defaultValue = "cdnRoping") String sortBy,
                               @RequestParam(name= "direction", defaultValue = "DESC") String direction,
                               @RequestParam(name = "filter",required = false) Long filter) {
        return (ResponseEntity<ResponseDTO<Page<RopingDTO>>>) findCodeReturn(ropingService.pagination(page,pageSize,sortBy,direction,filter));
    }

    @PostMapping("/paginationFull")
    ResponseEntity<ResponseDTO<Page<RopingDTO>>> paginationFull(   @RequestParam(name= "page", defaultValue = "0") Integer page,
                                                                    @RequestParam(name= "pageSize", defaultValue = "10") Integer pageSize,
                                                                    @RequestParam(name= "sortBy", defaultValue = "cdnRoping") String sortBy,
                                                                    @RequestParam(name= "direction", defaultValue = "DESC") String direction,
                                                                    @RequestBody Map<String, Object> filterMap) {
        return (ResponseEntity<ResponseDTO<Page<RopingDTO>>>) findCodeReturn(ropingService.paginationFull(page,pageSize,sortBy,direction,filterMap));
    }

    @PostMapping("/listAll")
    public ResponseEntity<ResponseDTO<List<RopingDTO>>> listAll (){
        return (ResponseEntity<ResponseDTO<List<RopingDTO>>>) findCodeReturn(ropingService.listAll());
    }

    @PostMapping("/listExample")
    public ResponseEntity<ResponseDTO<List<RopingDTO>>> listExample (@RequestBody RopingDTO ropingDTO){
        return (ResponseEntity<ResponseDTO<List<RopingDTO>>>) findCodeReturn(ropingService.listExample(ropingDTO));
    }

}
