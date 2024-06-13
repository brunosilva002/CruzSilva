package br.cruzsilva.CruzSilva.rest;

import br.cruzsilva.CruzSilva.dto.RopingDivisionDTO;
import br.cruzsilva.CruzSilva.dto.ResponseDTO;
import br.cruzsilva.CruzSilva.service.RopingDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/ropingdivision")
public class RopingDivisionResource extends BaseResource {

    @Autowired
    RopingDivisionService ropingdivisionService;

    @PostMapping("/save")
    public ResponseEntity<ResponseDTO<RopingDivisionDTO>> save (@RequestBody RopingDivisionDTO ropingdivisionDTO){
        return (ResponseEntity<ResponseDTO<RopingDivisionDTO>>) findCodeReturn(ropingdivisionService.save(ropingdivisionDTO));
    }

    @GetMapping("/obtain")
    public ResponseEntity<ResponseDTO<RopingDivisionDTO>> obtain (@RequestParam Long cdnRopingDivision){
        return (ResponseEntity<ResponseDTO<RopingDivisionDTO>>) findCodeReturn(ropingdivisionService.obtain(cdnRopingDivision));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> delete (@RequestParam Long cdnRopingDivision){
        return (ResponseEntity<ResponseDTO>) findCodeReturn(ropingdivisionService.delete(cdnRopingDivision));
    }

    @GetMapping("/pagination")
    ResponseEntity<ResponseDTO<Page<RopingDivisionDTO>>> pagination(@RequestParam(name= "page", defaultValue = "0") Integer page,
                               @RequestParam(name= "pageSize", defaultValue = "10") Integer pageSize,
                               @RequestParam(name= "sortBy", defaultValue = "cdnRopingDivision") String sortBy,
                               @RequestParam(name= "direction", defaultValue = "DESC") String direction,
                               @RequestParam(name = "filter",required = false) Long filter) {
        return (ResponseEntity<ResponseDTO<Page<RopingDivisionDTO>>>) findCodeReturn(ropingdivisionService.pagination(page,pageSize,sortBy,direction,filter));
    }

    @PostMapping("/paginationFull")
    ResponseEntity<ResponseDTO<Page<RopingDivisionDTO>>> paginationFull(   @RequestParam(name= "page", defaultValue = "0") Integer page,
                                                                    @RequestParam(name= "pageSize", defaultValue = "10") Integer pageSize,
                                                                    @RequestParam(name= "sortBy", defaultValue = "cdnRopingDivision") String sortBy,
                                                                    @RequestParam(name= "direction", defaultValue = "DESC") String direction,
                                                                    @RequestBody Map<String, Object> filterMap) {
        return (ResponseEntity<ResponseDTO<Page<RopingDivisionDTO>>>) findCodeReturn(ropingdivisionService.paginationFull(page,pageSize,sortBy,direction,filterMap));
    }

    @PostMapping("/listAll")
    public ResponseEntity<ResponseDTO<List<RopingDivisionDTO>>> listAll (){
        return (ResponseEntity<ResponseDTO<List<RopingDivisionDTO>>>) findCodeReturn(ropingdivisionService.listAll());
    }

    @PostMapping("/listExample")
    public ResponseEntity<ResponseDTO<List<RopingDivisionDTO>>> listExample (@RequestBody RopingDivisionDTO ropingdivisionDTO){
        return (ResponseEntity<ResponseDTO<List<RopingDivisionDTO>>>) findCodeReturn(ropingdivisionService.listExample(ropingdivisionDTO));
    }

}
