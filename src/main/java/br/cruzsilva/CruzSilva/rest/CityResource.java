package br.cruzsilva.CruzSilva.rest;

import br.cruzsilva.CruzSilva.dto.CityDTO;
import br.cruzsilva.CruzSilva.dto.ResponseDTO;
import br.cruzsilva.CruzSilva.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/city")
public class CityResource extends BaseResource {

    @Autowired
    CityService cityService;

    @PostMapping("/save")
    public ResponseEntity<ResponseDTO<CityDTO>> save (@RequestBody CityDTO cityDTO){
        return (ResponseEntity<ResponseDTO<CityDTO>>) findCodeReturn(cityService.save(cityDTO));
    }

    @GetMapping("/obtain")
    public ResponseEntity<ResponseDTO<CityDTO>> obtain (@RequestParam Long cdnCity){
        return (ResponseEntity<ResponseDTO<CityDTO>>) findCodeReturn(cityService.obtain(cdnCity));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> delete (@RequestParam Long cdnCity){
        return (ResponseEntity<ResponseDTO>) findCodeReturn(cityService.delete(cdnCity));
    }

    @GetMapping("/pagination")
    ResponseEntity<ResponseDTO<Page<CityDTO>>> pagination(@RequestParam(name= "page", defaultValue = "0") Integer page,
                               @RequestParam(name= "pageSize", defaultValue = "10") Integer pageSize,
                               @RequestParam(name= "sortBy", defaultValue = "cdnCity") String sortBy,
                               @RequestParam(name= "direction", defaultValue = "DESC") String direction,
                               @RequestParam(name = "filter",required = false) Long filter) {
        return (ResponseEntity<ResponseDTO<Page<CityDTO>>>) findCodeReturn(cityService.pagination(page,pageSize,sortBy,direction,filter));
    }

    @PostMapping("/paginationFull")
    ResponseEntity<ResponseDTO<Page<CityDTO>>> paginationFull(   @RequestParam(name= "page", defaultValue = "0") Integer page,
                                                                    @RequestParam(name= "pageSize", defaultValue = "10") Integer pageSize,
                                                                    @RequestParam(name= "sortBy", defaultValue = "cdnCity") String sortBy,
                                                                    @RequestParam(name= "direction", defaultValue = "DESC") String direction,
                                                                    @RequestBody Map<String, Object> filterMap) {
        return (ResponseEntity<ResponseDTO<Page<CityDTO>>>) findCodeReturn(cityService.paginationFull(page,pageSize,sortBy,direction,filterMap));
    }

    @PostMapping("/listAll")
    public ResponseEntity<ResponseDTO<List<CityDTO>>> listAll (){
        return (ResponseEntity<ResponseDTO<List<CityDTO>>>) findCodeReturn(cityService.listAll());
    }

    @PostMapping("/listExample")
    public ResponseEntity<ResponseDTO<List<CityDTO>>> listExample (@RequestBody CityDTO cityDTO){
        return (ResponseEntity<ResponseDTO<List<CityDTO>>>) findCodeReturn(cityService.listExample(cityDTO));
    }

}
