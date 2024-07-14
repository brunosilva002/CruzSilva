package br.cruzsilva.CruzSilva.rest;

import br.cruzsilva.CruzSilva.dto.DivisionDTO;
import br.cruzsilva.CruzSilva.dto.ResponseDTO;
import br.cruzsilva.CruzSilva.service.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/division")
public class DivisionResource extends BaseResource {

    @Autowired
    DivisionService divisionService;

    @PostMapping("/save")
    public ResponseEntity<ResponseDTO<DivisionDTO>> save (@RequestBody DivisionDTO divisionDTO){
        return (ResponseEntity<ResponseDTO<DivisionDTO>>) findCodeReturn(divisionService.save(divisionDTO));
    }

    @PostMapping("/saveList")
    public ResponseEntity<ResponseDTO<List<DivisionDTO>>> saveList (@RequestBody List<DivisionDTO> divisionDTO){
        return (ResponseEntity<ResponseDTO<List<DivisionDTO>>>) findCodeReturn(divisionService.saveList(divisionDTO));
    }

    @GetMapping("/obtain")
    public ResponseEntity<ResponseDTO<DivisionDTO>> obtain (@RequestParam Long cdnDivision){
        return (ResponseEntity<ResponseDTO<DivisionDTO>>) findCodeReturn(divisionService.obtain(cdnDivision));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> delete (@RequestParam Long cdnDivision){
        return (ResponseEntity<ResponseDTO>) findCodeReturn(divisionService.delete(cdnDivision));
    }

    @GetMapping("/pagination")
    ResponseEntity<ResponseDTO<Page<DivisionDTO>>> pagination(@RequestParam(name= "page", defaultValue = "0") Integer page,
                               @RequestParam(name= "pageSize", defaultValue = "10") Integer pageSize,
                               @RequestParam(name= "sortBy", defaultValue = "cdnDivision") String sortBy,
                               @RequestParam(name= "direction", defaultValue = "DESC") String direction,
                               @RequestParam(name = "filter",required = false) Long filter) {
        return (ResponseEntity<ResponseDTO<Page<DivisionDTO>>>) findCodeReturn(divisionService.pagination(page,pageSize,sortBy,direction,filter));
    }

    @PostMapping("/paginationFull")
    ResponseEntity<ResponseDTO<Page<DivisionDTO>>> paginationFull(   @RequestParam(name= "page", defaultValue = "0") Integer page,
                                                                    @RequestParam(name= "pageSize", defaultValue = "10") Integer pageSize,
                                                                    @RequestParam(name= "sortBy", defaultValue = "cdnDivision") String sortBy,
                                                                    @RequestParam(name= "direction", defaultValue = "DESC") String direction,
                                                                    @RequestBody Map<String, Object> filterMap) {
        return (ResponseEntity<ResponseDTO<Page<DivisionDTO>>>) findCodeReturn(divisionService.paginationFull(page,pageSize,sortBy,direction,filterMap));
    }

    @PostMapping("/listAll")
    public ResponseEntity<ResponseDTO<List<DivisionDTO>>> listAll (){
        return (ResponseEntity<ResponseDTO<List<DivisionDTO>>>) findCodeReturn(divisionService.listAll());
    }

    @PostMapping("/listExample")
    public ResponseEntity<ResponseDTO<List<DivisionDTO>>> listExample (@RequestBody DivisionDTO divisionDTO){
        return (ResponseEntity<ResponseDTO<List<DivisionDTO>>>) findCodeReturn(divisionService.listExample(divisionDTO));
    }

}
