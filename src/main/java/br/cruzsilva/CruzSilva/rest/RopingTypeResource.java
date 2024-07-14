package br.cruzsilva.CruzSilva.rest;

import br.cruzsilva.CruzSilva.dto.RopingTypeDTO;
import br.cruzsilva.CruzSilva.dto.ResponseDTO;
import br.cruzsilva.CruzSilva.service.RopingTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/ropingtype")
public class RopingTypeResource extends BaseResource {

    @Autowired
    RopingTypeService ropingtypeService;

    @PostMapping("/save")
    public ResponseEntity<ResponseDTO<RopingTypeDTO>> save (@RequestBody RopingTypeDTO ropingtypeDTO){
        return (ResponseEntity<ResponseDTO<RopingTypeDTO>>) findCodeReturn(ropingtypeService.save(ropingtypeDTO));
    }

    @GetMapping("/obtain")
    public ResponseEntity<ResponseDTO<RopingTypeDTO>> obtain (@RequestParam Long cdnRopingType){
        return (ResponseEntity<ResponseDTO<RopingTypeDTO>>) findCodeReturn(ropingtypeService.obtain(cdnRopingType));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> delete (@RequestParam Long cdnRopingType){
        return (ResponseEntity<ResponseDTO>) findCodeReturn(ropingtypeService.delete(cdnRopingType));
    }

    @GetMapping("/pagination")
    ResponseEntity<ResponseDTO<Page<RopingTypeDTO>>> pagination(@RequestParam(name= "page", defaultValue = "0") Integer page,
                               @RequestParam(name= "pageSize", defaultValue = "10") Integer pageSize,
                               @RequestParam(name= "sortBy", defaultValue = "cdnRopingType") String sortBy,
                               @RequestParam(name= "direction", defaultValue = "DESC") String direction,
                               @RequestParam(name = "filter",required = false) Long filter) {
        return (ResponseEntity<ResponseDTO<Page<RopingTypeDTO>>>) findCodeReturn(ropingtypeService.pagination(page,pageSize,sortBy,direction,filter));
    }

    @PostMapping("/paginationFull")
    ResponseEntity<ResponseDTO<Page<RopingTypeDTO>>> paginationFull(   @RequestParam(name= "page", defaultValue = "0") Integer page,
                                                                    @RequestParam(name= "pageSize", defaultValue = "10") Integer pageSize,
                                                                    @RequestParam(name= "sortBy", defaultValue = "cdnRopingType") String sortBy,
                                                                    @RequestParam(name= "direction", defaultValue = "DESC") String direction,
                                                                    @RequestBody Map<String, Object> filterMap) {
        return (ResponseEntity<ResponseDTO<Page<RopingTypeDTO>>>) findCodeReturn(ropingtypeService.paginationFull(page,pageSize,sortBy,direction,filterMap));
    }

    @PostMapping("/listAll")
    public ResponseEntity<ResponseDTO<List<RopingTypeDTO>>> listAll (){
        return (ResponseEntity<ResponseDTO<List<RopingTypeDTO>>>) findCodeReturn(ropingtypeService.listAll());
    }

    @PostMapping("/listExample")
    public ResponseEntity<ResponseDTO<List<RopingTypeDTO>>> listExample (@RequestBody RopingTypeDTO ropingtypeDTO){
        return (ResponseEntity<ResponseDTO<List<RopingTypeDTO>>>) findCodeReturn(ropingtypeService.listExample(ropingtypeDTO));
    }

}
