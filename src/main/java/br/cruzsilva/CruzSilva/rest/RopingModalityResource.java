package br.cruzsilva.CruzSilva.rest;

import br.cruzsilva.CruzSilva.dto.RopingModalityDTO;
import br.cruzsilva.CruzSilva.dto.ResponseDTO;
import br.cruzsilva.CruzSilva.service.RopingModalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/ropingmodality")
public class RopingModalityResource extends BaseResource {

    @Autowired
    RopingModalityService ropingmodalityService;

    @PostMapping("/save")
    public ResponseEntity<ResponseDTO<RopingModalityDTO>> save (@RequestBody RopingModalityDTO ropingmodalityDTO){
        return (ResponseEntity<ResponseDTO<RopingModalityDTO>>) findCodeReturn(ropingmodalityService.save(ropingmodalityDTO));
    }

    @GetMapping("/obtain")
    public ResponseEntity<ResponseDTO<RopingModalityDTO>> obtain (@RequestParam Long cdnRopingModality){
        return (ResponseEntity<ResponseDTO<RopingModalityDTO>>) findCodeReturn(ropingmodalityService.obtain(cdnRopingModality));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> delete (@RequestParam Long cdnRopingModality){
        return (ResponseEntity<ResponseDTO>) findCodeReturn(ropingmodalityService.delete(cdnRopingModality));
    }

    @GetMapping("/pagination")
    ResponseEntity<ResponseDTO<Page<RopingModalityDTO>>> pagination(@RequestParam(name= "page", defaultValue = "0") Integer page,
                               @RequestParam(name= "pageSize", defaultValue = "10") Integer pageSize,
                               @RequestParam(name= "sortBy", defaultValue = "cdnRopingModality") String sortBy,
                               @RequestParam(name= "direction", defaultValue = "DESC") String direction,
                               @RequestParam(name = "filter",required = false) Long filter) {
        return (ResponseEntity<ResponseDTO<Page<RopingModalityDTO>>>) findCodeReturn(ropingmodalityService.pagination(page,pageSize,sortBy,direction,filter));
    }

    @PostMapping("/paginationFull")
    ResponseEntity<ResponseDTO<Page<RopingModalityDTO>>> paginationFull(   @RequestParam(name= "page", defaultValue = "0") Integer page,
                                                                    @RequestParam(name= "pageSize", defaultValue = "10") Integer pageSize,
                                                                    @RequestParam(name= "sortBy", defaultValue = "cdnRopingModality") String sortBy,
                                                                    @RequestParam(name= "direction", defaultValue = "DESC") String direction,
                                                                    @RequestBody Map<String, Object> filterMap) {
        return (ResponseEntity<ResponseDTO<Page<RopingModalityDTO>>>) findCodeReturn(ropingmodalityService.paginationFull(page,pageSize,sortBy,direction,filterMap));
    }

    @PostMapping("/listAll")
    public ResponseEntity<ResponseDTO<List<RopingModalityDTO>>> listAll (){
        return (ResponseEntity<ResponseDTO<List<RopingModalityDTO>>>) findCodeReturn(ropingmodalityService.listAll());
    }

    @PostMapping("/listExample")
    public ResponseEntity<ResponseDTO<List<RopingModalityDTO>>> listExample (@RequestBody RopingModalityDTO ropingmodalityDTO){
        return (ResponseEntity<ResponseDTO<List<RopingModalityDTO>>>) findCodeReturn(ropingmodalityService.listExample(ropingmodalityDTO));
    }

}
