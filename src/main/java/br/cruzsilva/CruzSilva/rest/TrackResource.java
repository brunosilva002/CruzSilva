package br.cruzsilva.CruzSilva.rest;

import br.cruzsilva.CruzSilva.dto.TrackDTO;
import br.cruzsilva.CruzSilva.dto.ResponseDTO;
import br.cruzsilva.CruzSilva.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/track")
public class TrackResource extends BaseResource {

    @Autowired
    TrackService trackService;

    @PostMapping("/save")
    public ResponseEntity<ResponseDTO<TrackDTO>> save (@RequestBody TrackDTO trackDTO){
        return (ResponseEntity<ResponseDTO<TrackDTO>>) findCodeReturn(trackService.save(trackDTO));
    }

    @GetMapping("/obtain")
    public ResponseEntity<ResponseDTO<TrackDTO>> obtain (@RequestParam Long cdnTrack){
        return (ResponseEntity<ResponseDTO<TrackDTO>>) findCodeReturn(trackService.obtain(cdnTrack));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> delete (@RequestParam Long cdnTrack){
        return (ResponseEntity<ResponseDTO>) findCodeReturn(trackService.delete(cdnTrack));
    }

    @GetMapping("/pagination")
    ResponseEntity<ResponseDTO<Page<TrackDTO>>> pagination(@RequestParam(name= "page", defaultValue = "0") Integer page,
                               @RequestParam(name= "pageSize", defaultValue = "10") Integer pageSize,
                               @RequestParam(name= "sortBy", defaultValue = "cdnTrack") String sortBy,
                               @RequestParam(name= "direction", defaultValue = "DESC") String direction,
                               @RequestParam(name = "filter",required = false) Long filter) {
        return (ResponseEntity<ResponseDTO<Page<TrackDTO>>>) findCodeReturn(trackService.pagination(page,pageSize,sortBy,direction,filter));
    }

    @PostMapping("/paginationFull")
    ResponseEntity<ResponseDTO<Page<TrackDTO>>> paginationFull(   @RequestParam(name= "page", defaultValue = "0") Integer page,
                                                                    @RequestParam(name= "pageSize", defaultValue = "10") Integer pageSize,
                                                                    @RequestParam(name= "sortBy", defaultValue = "cdnTrack") String sortBy,
                                                                    @RequestParam(name= "direction", defaultValue = "DESC") String direction,
                                                                    @RequestBody Map<String, Object> filterMap) {
        return (ResponseEntity<ResponseDTO<Page<TrackDTO>>>) findCodeReturn(trackService.paginationFull(page,pageSize,sortBy,direction,filterMap));
    }

    @PostMapping("/listAll")
    public ResponseEntity<ResponseDTO<List<TrackDTO>>> listAll (){
        return (ResponseEntity<ResponseDTO<List<TrackDTO>>>) findCodeReturn(trackService.listAll());
    }

    @PostMapping("/listExample")
    public ResponseEntity<ResponseDTO<List<TrackDTO>>> listExample (@RequestBody TrackDTO trackDTO){
        return (ResponseEntity<ResponseDTO<List<TrackDTO>>>) findCodeReturn(trackService.listExample(trackDTO));
    }

}
