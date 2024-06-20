package br.cruzsilva.CruzSilva.rest;

import br.cruzsilva.CruzSilva.dto.GenderDTO;
import br.cruzsilva.CruzSilva.dto.ResponseDTO;
import br.cruzsilva.CruzSilva.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/gender")
public class GenderResource extends BaseResource {

    @Autowired
    GenderService genderService;

    @PostMapping("/save")
    public ResponseEntity<ResponseDTO<GenderDTO>> save (@RequestBody GenderDTO genderDTO){
        return (ResponseEntity<ResponseDTO<GenderDTO>>) findCodeReturn(genderService.save(genderDTO));
    }

    @GetMapping("/obtain")
    public ResponseEntity<ResponseDTO<GenderDTO>> obtain (@RequestParam Long cdnGender){
        return (ResponseEntity<ResponseDTO<GenderDTO>>) findCodeReturn(genderService.obtain(cdnGender));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> delete (@RequestParam Long cdnGender){
        return (ResponseEntity<ResponseDTO>) findCodeReturn(genderService.delete(cdnGender));
    }

    @GetMapping("/pagination")
    ResponseEntity<ResponseDTO<Page<GenderDTO>>> pagination(@RequestParam(name= "page", defaultValue = "0") Integer page,
                               @RequestParam(name= "pageSize", defaultValue = "10") Integer pageSize,
                               @RequestParam(name= "sortBy", defaultValue = "cdnGender") String sortBy,
                               @RequestParam(name= "direction", defaultValue = "DESC") String direction,
                               @RequestParam(name = "filter",required = false) Long filter) {
        return (ResponseEntity<ResponseDTO<Page<GenderDTO>>>) findCodeReturn(genderService.pagination(page,pageSize,sortBy,direction,filter));
    }

    @PostMapping("/paginationFull")
    ResponseEntity<ResponseDTO<Page<GenderDTO>>> paginationFull(   @RequestParam(name= "page", defaultValue = "0") Integer page,
                                                                    @RequestParam(name= "pageSize", defaultValue = "10") Integer pageSize,
                                                                    @RequestParam(name= "sortBy", defaultValue = "cdnGender") String sortBy,
                                                                    @RequestParam(name= "direction", defaultValue = "DESC") String direction,
                                                                    @RequestBody Map<String, Object> filterMap) {
        return (ResponseEntity<ResponseDTO<Page<GenderDTO>>>) findCodeReturn(genderService.paginationFull(page,pageSize,sortBy,direction,filterMap));
    }

    @PostMapping("/listAll")
    public ResponseEntity<ResponseDTO<List<GenderDTO>>> listAll (){
        return (ResponseEntity<ResponseDTO<List<GenderDTO>>>) findCodeReturn(genderService.listAll());
    }

    @PostMapping("/listExample")
    public ResponseEntity<ResponseDTO<List<GenderDTO>>> listExample (@RequestBody GenderDTO genderDTO){
        return (ResponseEntity<ResponseDTO<List<GenderDTO>>>) findCodeReturn(genderService.listExample(genderDTO));
    }

}
