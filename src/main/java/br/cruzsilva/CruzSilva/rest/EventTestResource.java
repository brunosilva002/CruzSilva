package br.cruzsilva.CruzSilva.rest;

import br.cruzsilva.CruzSilva.dto.EventTestDTO;
import br.cruzsilva.CruzSilva.dto.ResponseDTO;
import br.cruzsilva.CruzSilva.service.EventTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/eventtest")
public class EventTestResource extends BaseResource {

    @Autowired
    EventTestService eventtestService;

    @PostMapping("/save")
    public ResponseEntity<ResponseDTO<EventTestDTO>> save (@RequestBody EventTestDTO eventtestDTO){
        return (ResponseEntity<ResponseDTO<EventTestDTO>>) findCodeReturn(eventtestService.save(eventtestDTO));
    }

    @GetMapping("/obtain")
    public ResponseEntity<ResponseDTO<EventTestDTO>> obtain (@RequestParam Long cdnEventTest){
        return (ResponseEntity<ResponseDTO<EventTestDTO>>) findCodeReturn(eventtestService.obtain(cdnEventTest));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> delete (@RequestParam Long cdnEventTest){
        return (ResponseEntity<ResponseDTO>) findCodeReturn(eventtestService.delete(cdnEventTest));
    }

    @GetMapping("/pagination")
    ResponseEntity<ResponseDTO<Page<EventTestDTO>>> pagination(@RequestParam(name= "page", defaultValue = "0") Integer page,
                               @RequestParam(name= "pageSize", defaultValue = "10") Integer pageSize,
                               @RequestParam(name= "sortBy", defaultValue = "cdnEventTest") String sortBy,
                               @RequestParam(name= "direction", defaultValue = "DESC") String direction,
                               @RequestParam(name = "filter",required = false) Long filter) {
        return (ResponseEntity<ResponseDTO<Page<EventTestDTO>>>) findCodeReturn(eventtestService.pagination(page,pageSize,sortBy,direction,filter));
    }

    @PostMapping("/paginationFull")
    ResponseEntity<ResponseDTO<Page<EventTestDTO>>> paginationFull(   @RequestParam(name= "page", defaultValue = "0") Integer page,
                                                                    @RequestParam(name= "pageSize", defaultValue = "10") Integer pageSize,
                                                                    @RequestParam(name= "sortBy", defaultValue = "cdnEventTest") String sortBy,
                                                                    @RequestParam(name= "direction", defaultValue = "DESC") String direction,
                                                                    @RequestBody Map<String, Object> filterMap) {
        return (ResponseEntity<ResponseDTO<Page<EventTestDTO>>>) findCodeReturn(eventtestService.paginationFull(page,pageSize,sortBy,direction,filterMap));
    }

    @PostMapping("/listAll")
    public ResponseEntity<ResponseDTO<List<EventTestDTO>>> listAll (){
        return (ResponseEntity<ResponseDTO<List<EventTestDTO>>>) findCodeReturn(eventtestService.listAll());
    }

    @PostMapping("/listExample")
    public ResponseEntity<ResponseDTO<List<EventTestDTO>>> listExample (@RequestBody EventTestDTO eventtestDTO){
        return (ResponseEntity<ResponseDTO<List<EventTestDTO>>>) findCodeReturn(eventtestService.listExample(eventtestDTO));
    }

}
