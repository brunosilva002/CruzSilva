package br.cruzsilva.CruzSilva.rest;

import br.cruzsilva.CruzSilva.dto.TypeClassificationTimeDTO;
import br.cruzsilva.CruzSilva.dto.ResponseDTO;
import br.cruzsilva.CruzSilva.service.TypeClassificationTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/typeclassificationtime")
public class TypeClassificationTimeResource extends BaseResource {

    @Autowired
    TypeClassificationTimeService typeclassificationtimeService;

    @PostMapping("/save")
    public ResponseEntity<ResponseDTO<TypeClassificationTimeDTO>> save (@RequestBody TypeClassificationTimeDTO typeclassificationtimeDTO){
        return (ResponseEntity<ResponseDTO<TypeClassificationTimeDTO>>) findCodeReturn(typeclassificationtimeService.save(typeclassificationtimeDTO));
    }

    @GetMapping("/obtain")
    public ResponseEntity<ResponseDTO<TypeClassificationTimeDTO>> obtain (@RequestParam Long cdnTypeClassificationTime){
        return (ResponseEntity<ResponseDTO<TypeClassificationTimeDTO>>) findCodeReturn(typeclassificationtimeService.obtain(cdnTypeClassificationTime));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> delete (@RequestParam Long cdnTypeClassificationTime){
        return (ResponseEntity<ResponseDTO>) findCodeReturn(typeclassificationtimeService.delete(cdnTypeClassificationTime));
    }

    @GetMapping("/pagination")
    ResponseEntity<ResponseDTO<Page<TypeClassificationTimeDTO>>> pagination(@RequestParam(name= "page", defaultValue = "0") Integer page,
                               @RequestParam(name= "pageSize", defaultValue = "10") Integer pageSize,
                               @RequestParam(name= "sortBy", defaultValue = "cdnTypeClassificationTime") String sortBy,
                               @RequestParam(name= "direction", defaultValue = "DESC") String direction,
                               @RequestParam(name = "filter",required = false) Long filter) {
        return (ResponseEntity<ResponseDTO<Page<TypeClassificationTimeDTO>>>) findCodeReturn(typeclassificationtimeService.pagination(page,pageSize,sortBy,direction,filter));
    }

    @PostMapping("/paginationFull")
    ResponseEntity<ResponseDTO<Page<TypeClassificationTimeDTO>>> paginationFull(   @RequestParam(name= "page", defaultValue = "0") Integer page,
                                                                    @RequestParam(name= "pageSize", defaultValue = "10") Integer pageSize,
                                                                    @RequestParam(name= "sortBy", defaultValue = "cdnTypeClassificationTime") String sortBy,
                                                                    @RequestParam(name= "direction", defaultValue = "DESC") String direction,
                                                                    @RequestBody Map<String, Object> filterMap) {
        return (ResponseEntity<ResponseDTO<Page<TypeClassificationTimeDTO>>>) findCodeReturn(typeclassificationtimeService.paginationFull(page,pageSize,sortBy,direction,filterMap));
    }

    @PostMapping("/listAll")
    public ResponseEntity<ResponseDTO<List<TypeClassificationTimeDTO>>> listAll (){
        return (ResponseEntity<ResponseDTO<List<TypeClassificationTimeDTO>>>) findCodeReturn(typeclassificationtimeService.listAll());
    }

    @PostMapping("/listExample")
    public ResponseEntity<ResponseDTO<List<TypeClassificationTimeDTO>>> listExample (@RequestBody TypeClassificationTimeDTO typeclassificationtimeDTO){
        return (ResponseEntity<ResponseDTO<List<TypeClassificationTimeDTO>>>) findCodeReturn(typeclassificationtimeService.listExample(typeclassificationtimeDTO));
    }

}
