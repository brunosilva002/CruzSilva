package br.cruzsilva.CruzSilva.rest;

import br.cruzsilva.CruzSilva.dto.TrackStatusDTO;
import br.cruzsilva.CruzSilva.dto.ResponseDTO;
import br.cruzsilva.CruzSilva.service.TrackStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/trackstatus")
public class TrackStatusResource extends BaseResource {

    @Autowired
    TrackStatusService trackstatusService;

    @PostMapping("/save")
    public ResponseEntity<ResponseDTO<TrackStatusDTO>> save (@RequestBody TrackStatusDTO trackstatusDTO){
        return (ResponseEntity<ResponseDTO<TrackStatusDTO>>) findCodeReturn(trackstatusService.save(trackstatusDTO));
    }

    @GetMapping("/obtain")
    public ResponseEntity<ResponseDTO<TrackStatusDTO>> obtain (@RequestParam Long cdnTrackStatus){
        return (ResponseEntity<ResponseDTO<TrackStatusDTO>>) findCodeReturn(trackstatusService.obtain(cdnTrackStatus));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> delete (@RequestParam Long cdnTrackStatus){
        return (ResponseEntity<ResponseDTO>) findCodeReturn(trackstatusService.delete(cdnTrackStatus));
    }

    @GetMapping("/pagination")
    ResponseEntity<ResponseDTO<Page<TrackStatusDTO>>> pagination(@RequestParam(name= "page", defaultValue = "0") Integer page,
                               @RequestParam(name= "pageSize", defaultValue = "10") Integer pageSize,
                               @RequestParam(name= "sortBy", defaultValue = "cdnTrackStatus") String sortBy,
                               @RequestParam(name= "direction", defaultValue = "DESC") String direction,
                               @RequestParam(name = "filter",required = false) Long filter) {
        return (ResponseEntity<ResponseDTO<Page<TrackStatusDTO>>>) findCodeReturn(trackstatusService.pagination(page,pageSize,sortBy,direction,filter));
    }

    @PostMapping("/paginationFull")
    ResponseEntity<ResponseDTO<Page<TrackStatusDTO>>> paginationFull(   @RequestParam(name= "page", defaultValue = "0") Integer page,
                                                                    @RequestParam(name= "pageSize", defaultValue = "10") Integer pageSize,
                                                                    @RequestParam(name= "sortBy", defaultValue = "cdnTrackStatus") String sortBy,
                                                                    @RequestParam(name= "direction", defaultValue = "DESC") String direction,
                                                                    @RequestBody Map<String, Object> filterMap) {
        return (ResponseEntity<ResponseDTO<Page<TrackStatusDTO>>>) findCodeReturn(trackstatusService.paginationFull(page,pageSize,sortBy,direction,filterMap));
    }

    @PostMapping("/listAll")
    public ResponseEntity<ResponseDTO<List<TrackStatusDTO>>> listAll (){
        return (ResponseEntity<ResponseDTO<List<TrackStatusDTO>>>) findCodeReturn(trackstatusService.listAll());
    }

    @PostMapping("/listExample")
    public ResponseEntity<ResponseDTO<List<TrackStatusDTO>>> listExample (@RequestBody TrackStatusDTO trackstatusDTO){
        return (ResponseEntity<ResponseDTO<List<TrackStatusDTO>>>) findCodeReturn(trackstatusService.listExample(trackstatusDTO));
    }

}
