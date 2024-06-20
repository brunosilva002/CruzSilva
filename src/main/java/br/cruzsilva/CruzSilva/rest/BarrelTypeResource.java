package br.cruzsilva.CruzSilva.rest;

import br.cruzsilva.CruzSilva.dto.BarrelTypeDTO;
import br.cruzsilva.CruzSilva.dto.ResponseDTO;
import br.cruzsilva.CruzSilva.service.BarrelTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/barreltype")
public class BarrelTypeResource extends BaseResource {

    @Autowired
    BarrelTypeService barreltypeService;

    @PostMapping("/save")
    public ResponseEntity<ResponseDTO<BarrelTypeDTO>> save (@RequestBody BarrelTypeDTO barreltypeDTO){
        return (ResponseEntity<ResponseDTO<BarrelTypeDTO>>) findCodeReturn(barreltypeService.save(barreltypeDTO));
    }

    @GetMapping("/obtain")
    public ResponseEntity<ResponseDTO<BarrelTypeDTO>> obtain (@RequestParam Long cdnBarrelType){
        return (ResponseEntity<ResponseDTO<BarrelTypeDTO>>) findCodeReturn(barreltypeService.obtain(cdnBarrelType));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> delete (@RequestParam Long cdnBarrelType){
        return (ResponseEntity<ResponseDTO>) findCodeReturn(barreltypeService.delete(cdnBarrelType));
    }

    @GetMapping("/pagination")
    ResponseEntity<ResponseDTO<Page<BarrelTypeDTO>>> pagination(@RequestParam(name= "page", defaultValue = "0") Integer page,
                               @RequestParam(name= "pageSize", defaultValue = "10") Integer pageSize,
                               @RequestParam(name= "sortBy", defaultValue = "cdnBarrelType") String sortBy,
                               @RequestParam(name= "direction", defaultValue = "DESC") String direction,
                               @RequestParam(name = "filter",required = false) Long filter) {
        return (ResponseEntity<ResponseDTO<Page<BarrelTypeDTO>>>) findCodeReturn(barreltypeService.pagination(page,pageSize,sortBy,direction,filter));
    }

    @PostMapping("/paginationFull")
    ResponseEntity<ResponseDTO<Page<BarrelTypeDTO>>> paginationFull(   @RequestParam(name= "page", defaultValue = "0") Integer page,
                                                                    @RequestParam(name= "pageSize", defaultValue = "10") Integer pageSize,
                                                                    @RequestParam(name= "sortBy", defaultValue = "cdnBarrelType") String sortBy,
                                                                    @RequestParam(name= "direction", defaultValue = "DESC") String direction,
                                                                    @RequestBody Map<String, Object> filterMap) {
        return (ResponseEntity<ResponseDTO<Page<BarrelTypeDTO>>>) findCodeReturn(barreltypeService.paginationFull(page,pageSize,sortBy,direction,filterMap));
    }

    @PostMapping("/listAll")
    public ResponseEntity<ResponseDTO<List<BarrelTypeDTO>>> listAll (){
        return (ResponseEntity<ResponseDTO<List<BarrelTypeDTO>>>) findCodeReturn(barreltypeService.listAll());
    }

    @PostMapping("/listExample")
    public ResponseEntity<ResponseDTO<List<BarrelTypeDTO>>> listExample (@RequestBody BarrelTypeDTO barreltypeDTO){
        return (ResponseEntity<ResponseDTO<List<BarrelTypeDTO>>>) findCodeReturn(barreltypeService.listExample(barreltypeDTO));
    }

}
