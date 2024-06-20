package br.cruzsilva.CruzSilva.rest;

import br.cruzsilva.CruzSilva.dto.TypeClassificationDTO;
import br.cruzsilva.CruzSilva.dto.ResponseDTO;
import br.cruzsilva.CruzSilva.service.TypeClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/typeclassification")
public class TypeClassificationResource extends BaseResource {

    @Autowired
    TypeClassificationService typeclassificationService;

    @PostMapping("/save")
    public ResponseEntity<ResponseDTO<TypeClassificationDTO>> save (@RequestBody TypeClassificationDTO typeclassificationDTO){
        return (ResponseEntity<ResponseDTO<TypeClassificationDTO>>) findCodeReturn(typeclassificationService.save(typeclassificationDTO));
    }

    @GetMapping("/obtain")
    public ResponseEntity<ResponseDTO<TypeClassificationDTO>> obtain (@RequestParam Long cdnTypeClassification){
        return (ResponseEntity<ResponseDTO<TypeClassificationDTO>>) findCodeReturn(typeclassificationService.obtain(cdnTypeClassification));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> delete (@RequestParam Long cdnTypeClassification){
        return (ResponseEntity<ResponseDTO>) findCodeReturn(typeclassificationService.delete(cdnTypeClassification));
    }

    @GetMapping("/pagination")
    ResponseEntity<ResponseDTO<Page<TypeClassificationDTO>>> pagination(@RequestParam(name= "page", defaultValue = "0") Integer page,
                               @RequestParam(name= "pageSize", defaultValue = "10") Integer pageSize,
                               @RequestParam(name= "sortBy", defaultValue = "cdnTypeClassification") String sortBy,
                               @RequestParam(name= "direction", defaultValue = "DESC") String direction,
                               @RequestParam(name = "filter",required = false) Long filter) {
        return (ResponseEntity<ResponseDTO<Page<TypeClassificationDTO>>>) findCodeReturn(typeclassificationService.pagination(page,pageSize,sortBy,direction,filter));
    }

    @PostMapping("/paginationFull")
    ResponseEntity<ResponseDTO<Page<TypeClassificationDTO>>> paginationFull(   @RequestParam(name= "page", defaultValue = "0") Integer page,
                                                                    @RequestParam(name= "pageSize", defaultValue = "10") Integer pageSize,
                                                                    @RequestParam(name= "sortBy", defaultValue = "cdnTypeClassification") String sortBy,
                                                                    @RequestParam(name= "direction", defaultValue = "DESC") String direction,
                                                                    @RequestBody Map<String, Object> filterMap) {
        return (ResponseEntity<ResponseDTO<Page<TypeClassificationDTO>>>) findCodeReturn(typeclassificationService.paginationFull(page,pageSize,sortBy,direction,filterMap));
    }

    @PostMapping("/listAll")
    public ResponseEntity<ResponseDTO<List<TypeClassificationDTO>>> listAll (){
        return (ResponseEntity<ResponseDTO<List<TypeClassificationDTO>>>) findCodeReturn(typeclassificationService.listAll());
    }

    @PostMapping("/listExample")
    public ResponseEntity<ResponseDTO<List<TypeClassificationDTO>>> listExample (@RequestBody TypeClassificationDTO typeclassificationDTO){
        return (ResponseEntity<ResponseDTO<List<TypeClassificationDTO>>>) findCodeReturn(typeclassificationService.listExample(typeclassificationDTO));
    }

}
