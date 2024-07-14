package br.cruzsilva.CruzSilva.rest;

import br.cruzsilva.CruzSilva.dto.EntryFormDTO;
import br.cruzsilva.CruzSilva.dto.ResponseDTO;
import br.cruzsilva.CruzSilva.service.EntryFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/entryform")
public class EntryFormResource extends BaseResource {

    @Autowired
    EntryFormService entryformService;

    @PostMapping("/save")
    public ResponseEntity<ResponseDTO<EntryFormDTO>> save (@RequestBody EntryFormDTO entryformDTO){
        return (ResponseEntity<ResponseDTO<EntryFormDTO>>) findCodeReturn(entryformService.save(entryformDTO));
    }

    @GetMapping("/obtain")
    public ResponseEntity<ResponseDTO<EntryFormDTO>> obtain (@RequestParam Long cdnEntryForm){
        return (ResponseEntity<ResponseDTO<EntryFormDTO>>) findCodeReturn(entryformService.obtain(cdnEntryForm));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> delete (@RequestParam Long cdnEntryForm){
        return (ResponseEntity<ResponseDTO>) findCodeReturn(entryformService.delete(cdnEntryForm));
    }

    @GetMapping("/pagination")
    ResponseEntity<ResponseDTO<Page<EntryFormDTO>>> pagination(@RequestParam(name= "page", defaultValue = "0") Integer page,
                               @RequestParam(name= "pageSize", defaultValue = "10") Integer pageSize,
                               @RequestParam(name= "sortBy", defaultValue = "cdnEntryForm") String sortBy,
                               @RequestParam(name= "direction", defaultValue = "DESC") String direction,
                               @RequestParam(name = "filter",required = false) Long filter) {
        return (ResponseEntity<ResponseDTO<Page<EntryFormDTO>>>) findCodeReturn(entryformService.pagination(page,pageSize,sortBy,direction,filter));
    }

    @PostMapping("/paginationFull")
    ResponseEntity<ResponseDTO<Page<EntryFormDTO>>> paginationFull(   @RequestParam(name= "page", defaultValue = "0") Integer page,
                                                                    @RequestParam(name= "pageSize", defaultValue = "10") Integer pageSize,
                                                                    @RequestParam(name= "sortBy", defaultValue = "cdnEntryForm") String sortBy,
                                                                    @RequestParam(name= "direction", defaultValue = "DESC") String direction,
                                                                    @RequestBody Map<String, Object> filterMap) {
        return (ResponseEntity<ResponseDTO<Page<EntryFormDTO>>>) findCodeReturn(entryformService.paginationFull(page,pageSize,sortBy,direction,filterMap));
    }

    @PostMapping("/listAll")
    public ResponseEntity<ResponseDTO<List<EntryFormDTO>>> listAll (){
        return (ResponseEntity<ResponseDTO<List<EntryFormDTO>>>) findCodeReturn(entryformService.listAll());
    }

    @PostMapping("/listExample")
    public ResponseEntity<ResponseDTO<List<EntryFormDTO>>> listExample (@RequestBody EntryFormDTO entryformDTO){
        return (ResponseEntity<ResponseDTO<List<EntryFormDTO>>>) findCodeReturn(entryformService.listExample(entryformDTO));
    }

}
