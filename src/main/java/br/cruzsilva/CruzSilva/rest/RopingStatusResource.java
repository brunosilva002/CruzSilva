package br.cruzsilva.CruzSilva.rest;

import br.cruzsilva.CruzSilva.dto.RopingStatusDTO;
import br.cruzsilva.CruzSilva.dto.ResponseDTO;
import br.cruzsilva.CruzSilva.service.RopingStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/ropingstatus")
public class RopingStatusResource extends BaseResource {

    @Autowired
    RopingStatusService ropingstatusService;

    @PostMapping("/save")
    public ResponseEntity<ResponseDTO<RopingStatusDTO>> save (@RequestBody RopingStatusDTO ropingstatusDTO){
        return (ResponseEntity<ResponseDTO<RopingStatusDTO>>) findCodeReturn(ropingstatusService.save(ropingstatusDTO));
    }

    @GetMapping("/obtain")
    public ResponseEntity<ResponseDTO<RopingStatusDTO>> obtain (@RequestParam Long cdnRopingStatus){
        return (ResponseEntity<ResponseDTO<RopingStatusDTO>>) findCodeReturn(ropingstatusService.obtain(cdnRopingStatus));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> delete (@RequestParam Long cdnRopingStatus){
        return (ResponseEntity<ResponseDTO>) findCodeReturn(ropingstatusService.delete(cdnRopingStatus));
    }

    @GetMapping("/pagination")
    ResponseEntity<ResponseDTO<Page<RopingStatusDTO>>> pagination(@RequestParam(name= "page", defaultValue = "0") Integer page,
                               @RequestParam(name= "pageSize", defaultValue = "10") Integer pageSize,
                               @RequestParam(name= "sortBy", defaultValue = "cdnRopingStatus") String sortBy,
                               @RequestParam(name= "direction", defaultValue = "DESC") String direction,
                               @RequestParam(name = "filter",required = false) Long filter) {
        return (ResponseEntity<ResponseDTO<Page<RopingStatusDTO>>>) findCodeReturn(ropingstatusService.pagination(page,pageSize,sortBy,direction,filter));
    }

    @PostMapping("/paginationFull")
    ResponseEntity<ResponseDTO<Page<RopingStatusDTO>>> paginationFull(   @RequestParam(name= "page", defaultValue = "0") Integer page,
                                                                    @RequestParam(name= "pageSize", defaultValue = "10") Integer pageSize,
                                                                    @RequestParam(name= "sortBy", defaultValue = "cdnRopingStatus") String sortBy,
                                                                    @RequestParam(name= "direction", defaultValue = "DESC") String direction,
                                                                    @RequestBody Map<String, Object> filterMap) {
        return (ResponseEntity<ResponseDTO<Page<RopingStatusDTO>>>) findCodeReturn(ropingstatusService.paginationFull(page,pageSize,sortBy,direction,filterMap));
    }

    @PostMapping("/listAll")
    public ResponseEntity<ResponseDTO<List<RopingStatusDTO>>> listAll (){
        return (ResponseEntity<ResponseDTO<List<RopingStatusDTO>>>) findCodeReturn(ropingstatusService.listAll());
    }

    @PostMapping("/listExample")
    public ResponseEntity<ResponseDTO<List<RopingStatusDTO>>> listExample (@RequestBody RopingStatusDTO ropingstatusDTO){
        return (ResponseEntity<ResponseDTO<List<RopingStatusDTO>>>) findCodeReturn(ropingstatusService.listExample(ropingstatusDTO));
    }

}
