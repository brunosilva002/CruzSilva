package br.cruzsilva.CruzSilva.rest;

import br.cruzsilva.CruzSilva.dto.AnimalDTO;
import br.cruzsilva.CruzSilva.dto.ResponseDTO;
import br.cruzsilva.CruzSilva.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/animal")
public class AnimalResource extends BaseResource {

    @Autowired
    AnimalService animalService;

    @PostMapping("/save")
    public ResponseEntity<ResponseDTO<AnimalDTO>> save (@RequestBody AnimalDTO animalDTO){
        return (ResponseEntity<ResponseDTO<AnimalDTO>>) findCodeReturn(animalService.save(animalDTO));
    }

    @GetMapping("/obtain")
    public ResponseEntity<ResponseDTO<AnimalDTO>> obtain (@RequestParam Long cdnAnimal){
        return (ResponseEntity<ResponseDTO<AnimalDTO>>) findCodeReturn(animalService.obtain(cdnAnimal));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> delete (@RequestParam Long cdnAnimal){
        return (ResponseEntity<ResponseDTO>) findCodeReturn(animalService.delete(cdnAnimal));
    }

    @GetMapping("/pagination")
    ResponseEntity<ResponseDTO<Page<AnimalDTO>>> pagination(@RequestParam(name= "page", defaultValue = "0") Integer page,
                                                            @RequestParam(name= "pageSize", defaultValue = "10") Integer pageSize,
                                                            @RequestParam(name= "sortBy", defaultValue = "cdnAnimal") String sortBy,
                                                            @RequestParam(name= "direction", defaultValue = "DESC") String direction,
                                                            @RequestParam(name = "filter",required = false) Long filter) {
        return (ResponseEntity<ResponseDTO<Page<AnimalDTO>>>) findCodeReturn(animalService.pagination(page,pageSize,sortBy,direction,filter));
    }

    @PostMapping("/paginationFull")
    ResponseEntity<ResponseDTO<Page<AnimalDTO>>> paginationFull(@RequestParam(name= "page", defaultValue = "0") Integer page,
                                                                @RequestParam(name= "pageSize", defaultValue = "10") Integer pageSize,
                                                                @RequestParam(name= "sortBy", defaultValue = "cdnAnimal") String sortBy,
                                                                @RequestParam(name= "direction", defaultValue = "DESC") String direction,
                                                                @RequestBody Map<String, Object> filterMap) {
        return (ResponseEntity<ResponseDTO<Page<AnimalDTO>>>) findCodeReturn(animalService.paginationFull(page,pageSize,sortBy,direction,filterMap));
    }

    @PostMapping("/listAll")
    public ResponseEntity<ResponseDTO<List<AnimalDTO>>> listAll (){
        return (ResponseEntity<ResponseDTO<List<AnimalDTO>>>) findCodeReturn(animalService.listAll());
    }

    @PostMapping("/listExample")
    public ResponseEntity<ResponseDTO<List<AnimalDTO>>> listExample (@RequestBody AnimalDTO animalDTO){
        return (ResponseEntity<ResponseDTO<List<AnimalDTO>>>) findCodeReturn(animalService.listExample(animalDTO));
    }

}
