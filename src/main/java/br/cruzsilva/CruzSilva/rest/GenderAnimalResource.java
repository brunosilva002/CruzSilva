package br.cruzsilva.CruzSilva.rest;

import br.cruzsilva.CruzSilva.dto.GenderAnimalDTO;
import br.cruzsilva.CruzSilva.dto.ResponseDTO;
import br.cruzsilva.CruzSilva.service.GenderAnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/genderanimal")
public class GenderAnimalResource extends BaseResource {

    @Autowired
    GenderAnimalService genderanimalService;

    @PostMapping("/save")
    public ResponseEntity<ResponseDTO<GenderAnimalDTO>> save (@RequestBody GenderAnimalDTO genderanimalDTO){
        return (ResponseEntity<ResponseDTO<GenderAnimalDTO>>) findCodeReturn(genderanimalService.save(genderanimalDTO));
    }

    @GetMapping("/obtain")
    public ResponseEntity<ResponseDTO<GenderAnimalDTO>> obtain (@RequestParam Long cdnGenderAnimal){
        return (ResponseEntity<ResponseDTO<GenderAnimalDTO>>) findCodeReturn(genderanimalService.obtain(cdnGenderAnimal));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> delete (@RequestParam Long cdnGenderAnimal){
        return (ResponseEntity<ResponseDTO>) findCodeReturn(genderanimalService.delete(cdnGenderAnimal));
    }

    @GetMapping("/pagination")
    ResponseEntity<ResponseDTO<Page<GenderAnimalDTO>>> pagination(@RequestParam(name= "page", defaultValue = "0") Integer page,
                               @RequestParam(name= "pageSize", defaultValue = "10") Integer pageSize,
                               @RequestParam(name= "sortBy", defaultValue = "cdnGenderAnimal") String sortBy,
                               @RequestParam(name= "direction", defaultValue = "DESC") String direction,
                               @RequestParam(name = "filter",required = false) Long filter) {
        return (ResponseEntity<ResponseDTO<Page<GenderAnimalDTO>>>) findCodeReturn(genderanimalService.pagination(page,pageSize,sortBy,direction,filter));
    }

    @PostMapping("/paginationFull")
    ResponseEntity<ResponseDTO<Page<GenderAnimalDTO>>> paginationFull(   @RequestParam(name= "page", defaultValue = "0") Integer page,
                                                                    @RequestParam(name= "pageSize", defaultValue = "10") Integer pageSize,
                                                                    @RequestParam(name= "sortBy", defaultValue = "cdnGenderAnimal") String sortBy,
                                                                    @RequestParam(name= "direction", defaultValue = "DESC") String direction,
                                                                    @RequestBody Map<String, Object> filterMap) {
        return (ResponseEntity<ResponseDTO<Page<GenderAnimalDTO>>>) findCodeReturn(genderanimalService.paginationFull(page,pageSize,sortBy,direction,filterMap));
    }

    @PostMapping("/listAll")
    public ResponseEntity<ResponseDTO<List<GenderAnimalDTO>>> listAll (){
        return (ResponseEntity<ResponseDTO<List<GenderAnimalDTO>>>) findCodeReturn(genderanimalService.listAll());
    }

    @PostMapping("/listExample")
    public ResponseEntity<ResponseDTO<List<GenderAnimalDTO>>> listExample (@RequestBody GenderAnimalDTO genderanimalDTO){
        return (ResponseEntity<ResponseDTO<List<GenderAnimalDTO>>>) findCodeReturn(genderanimalService.listExample(genderanimalDTO));
    }

}
