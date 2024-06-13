package br.cruzsilva.CruzSilva.rest;

import br.cruzsilva.CruzSilva.dto.AnimalsDTO;
import br.cruzsilva.CruzSilva.dto.ResponseDTO;
import br.cruzsilva.CruzSilva.service.AnimalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/animals")
public class AnimalsResource extends BaseResource {

    @Autowired
    AnimalsService animalsService;

    @PostMapping("/save")
    public ResponseEntity<ResponseDTO<AnimalsDTO>> save (@RequestBody AnimalsDTO animalsDTO){
        return (ResponseEntity<ResponseDTO<AnimalsDTO>>) findCodeReturn(animalsService.save(animalsDTO));
    }

    @GetMapping("/obtain")
    public ResponseEntity<ResponseDTO<AnimalsDTO>> obtain (@RequestParam Long cdnAnimals){
        return (ResponseEntity<ResponseDTO<AnimalsDTO>>) findCodeReturn(animalsService.obtain(cdnAnimals));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> delete (@RequestParam Long cdnAnimals){
        return (ResponseEntity<ResponseDTO>) findCodeReturn(animalsService.delete(cdnAnimals));
    }

    @GetMapping("/pagination")
    ResponseEntity<ResponseDTO<Page<AnimalsDTO>>> pagination(@RequestParam(name= "page", defaultValue = "0") Integer page,
                               @RequestParam(name= "pageSize", defaultValue = "10") Integer pageSize,
                               @RequestParam(name= "sortBy", defaultValue = "cdnAnimals") String sortBy,
                               @RequestParam(name= "direction", defaultValue = "DESC") String direction,
                               @RequestParam(name = "filter",required = false) Long filter) {
        return (ResponseEntity<ResponseDTO<Page<AnimalsDTO>>>) findCodeReturn(animalsService.pagination(page,pageSize,sortBy,direction,filter));
    }

    @PostMapping("/paginationFull")
    ResponseEntity<ResponseDTO<Page<AnimalsDTO>>> paginationFull(   @RequestParam(name= "page", defaultValue = "0") Integer page,
                                                                    @RequestParam(name= "pageSize", defaultValue = "10") Integer pageSize,
                                                                    @RequestParam(name= "sortBy", defaultValue = "cdnAnimals") String sortBy,
                                                                    @RequestParam(name= "direction", defaultValue = "DESC") String direction,
                                                                    @RequestBody Map<String, Object> filterMap) {
        return (ResponseEntity<ResponseDTO<Page<AnimalsDTO>>>) findCodeReturn(animalsService.paginationFull(page,pageSize,sortBy,direction,filterMap));
    }

    @PostMapping("/listAll")
    public ResponseEntity<ResponseDTO<List<AnimalsDTO>>> listAll (){
        return (ResponseEntity<ResponseDTO<List<AnimalsDTO>>>) findCodeReturn(animalsService.listAll());
    }

    @PostMapping("/listExample")
    public ResponseEntity<ResponseDTO<List<AnimalsDTO>>> listExample (@RequestBody AnimalsDTO animalsDTO){
        return (ResponseEntity<ResponseDTO<List<AnimalsDTO>>>) findCodeReturn(animalsService.listExample(animalsDTO));
    }

}
