package br.cruzsilva.CruzSilva.rest;

import br.cruzsilva.CruzSilva.dto.RopingDivisionRankDTO;
import br.cruzsilva.CruzSilva.dto.ResponseDTO;
import br.cruzsilva.CruzSilva.service.RopingDivisionRankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/ropingdivisionrank")
public class RopingDivisionRankResource extends BaseResource {

    @Autowired
    RopingDivisionRankService ropingdivisionrankService;

    @PostMapping("/save")
    public ResponseEntity<ResponseDTO<RopingDivisionRankDTO>> save (@RequestBody RopingDivisionRankDTO ropingdivisionrankDTO){
        return (ResponseEntity<ResponseDTO<RopingDivisionRankDTO>>) findCodeReturn(ropingdivisionrankService.save(ropingdivisionrankDTO));
    }

    @GetMapping("/obtain")
    public ResponseEntity<ResponseDTO<RopingDivisionRankDTO>> obtain (@RequestParam Long cdnRopingDivisionRank){
        return (ResponseEntity<ResponseDTO<RopingDivisionRankDTO>>) findCodeReturn(ropingdivisionrankService.obtain(cdnRopingDivisionRank));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> delete (@RequestParam Long cdnRopingDivisionRank){
        return (ResponseEntity<ResponseDTO>) findCodeReturn(ropingdivisionrankService.delete(cdnRopingDivisionRank));
    }

    @GetMapping("/pagination")
    ResponseEntity<ResponseDTO<Page<RopingDivisionRankDTO>>> pagination(@RequestParam(name= "page", defaultValue = "0") Integer page,
                               @RequestParam(name= "pageSize", defaultValue = "10") Integer pageSize,
                               @RequestParam(name= "sortBy", defaultValue = "cdnRopingDivisionRank") String sortBy,
                               @RequestParam(name= "direction", defaultValue = "DESC") String direction,
                               @RequestParam(name = "filter",required = false) Long filter) {
        return (ResponseEntity<ResponseDTO<Page<RopingDivisionRankDTO>>>) findCodeReturn(ropingdivisionrankService.pagination(page,pageSize,sortBy,direction,filter));
    }

    @PostMapping("/paginationFull")
    ResponseEntity<ResponseDTO<Page<RopingDivisionRankDTO>>> paginationFull(   @RequestParam(name= "page", defaultValue = "0") Integer page,
                                                                    @RequestParam(name= "pageSize", defaultValue = "10") Integer pageSize,
                                                                    @RequestParam(name= "sortBy", defaultValue = "cdnRopingDivisionRank") String sortBy,
                                                                    @RequestParam(name= "direction", defaultValue = "DESC") String direction,
                                                                    @RequestBody Map<String, Object> filterMap) {
        return (ResponseEntity<ResponseDTO<Page<RopingDivisionRankDTO>>>) findCodeReturn(ropingdivisionrankService.paginationFull(page,pageSize,sortBy,direction,filterMap));
    }

    @PostMapping("/listAll")
    public ResponseEntity<ResponseDTO<List<RopingDivisionRankDTO>>> listAll (){
        return (ResponseEntity<ResponseDTO<List<RopingDivisionRankDTO>>>) findCodeReturn(ropingdivisionrankService.listAll());
    }

    @PostMapping("/listExample")
    public ResponseEntity<ResponseDTO<List<RopingDivisionRankDTO>>> listExample (@RequestBody RopingDivisionRankDTO ropingdivisionrankDTO){
        return (ResponseEntity<ResponseDTO<List<RopingDivisionRankDTO>>>) findCodeReturn(ropingdivisionrankService.listExample(ropingdivisionrankDTO));
    }

}
