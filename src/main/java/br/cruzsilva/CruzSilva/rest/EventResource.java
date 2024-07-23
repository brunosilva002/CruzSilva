package br.cruzsilva.CruzSilva.rest;

import br.cruzsilva.CruzSilva.dto.EventDTO;
import br.cruzsilva.CruzSilva.dto.ResponseDTO;
import br.cruzsilva.CruzSilva.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/event")
public class EventResource extends BaseResource {

    @Autowired
    EventService eventService;

    @PostMapping("/save")
    public ResponseEntity<ResponseDTO<EventDTO>> save (@RequestBody EventDTO eventDTO){
        return (ResponseEntity<ResponseDTO<EventDTO>>) findCodeReturn(eventService.save(eventDTO));
    }

    @GetMapping("/obtain")
    public ResponseEntity<ResponseDTO<EventDTO>> obtain (@RequestParam Long cdnEvent){
        return (ResponseEntity<ResponseDTO<EventDTO>>) findCodeReturn(eventService.obtain(cdnEvent));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> delete (@RequestParam Long cdnEvent){
        return (ResponseEntity<ResponseDTO>) findCodeReturn(eventService.delete(cdnEvent));
    }

    @GetMapping("/pagination")
    ResponseEntity<ResponseDTO<Page<EventDTO>>> pagination(@RequestParam(name= "page", defaultValue = "0") Integer page,
                               @RequestParam(name= "pageSize", defaultValue = "10") Integer pageSize,
                               @RequestParam(name= "sortBy", defaultValue = "cdnEvent") String sortBy,
                               @RequestParam(name= "direction", defaultValue = "DESC") String direction,
                               @RequestParam(name = "filter",required = false) Long filter) {
        return (ResponseEntity<ResponseDTO<Page<EventDTO>>>) findCodeReturn(eventService.pagination(page,pageSize,sortBy,direction,filter));
    }

    @PostMapping("/paginationFull")
    ResponseEntity<ResponseDTO<Page<EventDTO>>> paginationFull(   @RequestParam(name= "page", defaultValue = "0") Integer page,
                                                                    @RequestParam(name= "pageSize", defaultValue = "10") Integer pageSize,
                                                                    @RequestParam(name= "sortBy", defaultValue = "cdnEvent") String sortBy,
                                                                    @RequestParam(name= "direction", defaultValue = "DESC") String direction,
                                                                    @RequestBody Map<String, Object> filterMap) {
        return (ResponseEntity<ResponseDTO<Page<EventDTO>>>) findCodeReturn(eventService.paginationFull(page,pageSize,sortBy,direction,filterMap));
    }

    @PostMapping("/listAll")
    public ResponseEntity<ResponseDTO<List<EventDTO>>> listAll (){
        return (ResponseEntity<ResponseDTO<List<EventDTO>>>) findCodeReturn(eventService.listAll());
    }

    @PostMapping("/listExample")
    public ResponseEntity<ResponseDTO<List<EventDTO>>> listExample (@RequestBody EventDTO eventDTO){
        return (ResponseEntity<ResponseDTO<List<EventDTO>>>) findCodeReturn(eventService.listExample(eventDTO));
    }

}
