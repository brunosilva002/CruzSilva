package br.cruzsilva.CruzSilva.rest;

import br.cruzsilva.CruzSilva.dto.RopingModalityTypeDTO;
import br.cruzsilva.CruzSilva.dto.ResponseDTO;
import br.cruzsilva.CruzSilva.service.RopingModalityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/ropingmodalitytype")
public class RopingModalityTypeResource extends BaseResource {

    @Autowired
    RopingModalityTypeService ropingmodalitytypeService;

    @PostMapping("/save")
    public ResponseEntity<ResponseDTO<RopingModalityTypeDTO>> save (@RequestBody RopingModalityTypeDTO ropingmodalitytypeDTO){
        return (ResponseEntity<ResponseDTO<RopingModalityTypeDTO>>) findCodeReturn(ropingmodalitytypeService.save(ropingmodalitytypeDTO));
    }

    @GetMapping("/obtain")
    public ResponseEntity<ResponseDTO<RopingModalityTypeDTO>> obtain (@RequestParam Long cdnRopingModalityType){
        return (ResponseEntity<ResponseDTO<RopingModalityTypeDTO>>) findCodeReturn(ropingmodalitytypeService.obtain(cdnRopingModalityType));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> delete (@RequestParam Long cdnRopingModalityType){
        return (ResponseEntity<ResponseDTO>) findCodeReturn(ropingmodalitytypeService.delete(cdnRopingModalityType));
    }

    @GetMapping("/pagination")
    ResponseEntity<ResponseDTO<Page<RopingModalityTypeDTO>>> pagination(@RequestParam(name= "page", defaultValue = "0") Integer page,
                               @RequestParam(name= "pageSize", defaultValue = "10") Integer pageSize,
                               @RequestParam(name= "sortBy", defaultValue = "cdnRopingModalityType") String sortBy,
                               @RequestParam(name= "direction", defaultValue = "DESC") String direction,
                               @RequestParam(name = "filter",required = false) Long filter) {
        return (ResponseEntity<ResponseDTO<Page<RopingModalityTypeDTO>>>) findCodeReturn(ropingmodalitytypeService.pagination(page,pageSize,sortBy,direction,filter));
    }

    @PostMapping("/paginationFull")
    ResponseEntity<ResponseDTO<Page<RopingModalityTypeDTO>>> paginationFull(   @RequestParam(name= "page", defaultValue = "0") Integer page,
                                                                    @RequestParam(name= "pageSize", defaultValue = "10") Integer pageSize,
                                                                    @RequestParam(name= "sortBy", defaultValue = "cdnRopingModalityType") String sortBy,
                                                                    @RequestParam(name= "direction", defaultValue = "DESC") String direction,
                                                                    @RequestBody Map<String, Object> filterMap) {
        return (ResponseEntity<ResponseDTO<Page<RopingModalityTypeDTO>>>) findCodeReturn(ropingmodalitytypeService.paginationFull(page,pageSize,sortBy,direction,filterMap));
    }

    @PostMapping("/listAll")
    public ResponseEntity<ResponseDTO<List<RopingModalityTypeDTO>>> listAll (){
        return (ResponseEntity<ResponseDTO<List<RopingModalityTypeDTO>>>) findCodeReturn(ropingmodalitytypeService.listAll());
    }

    @PostMapping("/listExample")
    public ResponseEntity<ResponseDTO<List<RopingModalityTypeDTO>>> listExample (@RequestBody RopingModalityTypeDTO ropingmodalitytypeDTO){
        return (ResponseEntity<ResponseDTO<List<RopingModalityTypeDTO>>>) findCodeReturn(ropingmodalitytypeService.listExample(ropingmodalitytypeDTO));
    }

}
