package br.cruzsilva.CruzSilva.rest;

import br.cruzsilva.CruzSilva.dto.RopingProductDTO;
import br.cruzsilva.CruzSilva.dto.ResponseDTO;
import br.cruzsilva.CruzSilva.service.RopingProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/ropingproduct")
public class RopingProductResource extends BaseResource {

    @Autowired
    RopingProductService ropingproductService;

    @PostMapping("/save")
    public ResponseEntity<ResponseDTO<RopingProductDTO>> save (@RequestBody RopingProductDTO ropingproductDTO){
        return (ResponseEntity<ResponseDTO<RopingProductDTO>>) findCodeReturn(ropingproductService.save(ropingproductDTO));
    }

    @GetMapping("/obtain")
    public ResponseEntity<ResponseDTO<RopingProductDTO>> obtain (@RequestParam Long cdnRopingProduct){
        return (ResponseEntity<ResponseDTO<RopingProductDTO>>) findCodeReturn(ropingproductService.obtain(cdnRopingProduct));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> delete (@RequestParam Long cdnRopingProduct){
        return (ResponseEntity<ResponseDTO>) findCodeReturn(ropingproductService.delete(cdnRopingProduct));
    }

    @GetMapping("/pagination")
    ResponseEntity<ResponseDTO<Page<RopingProductDTO>>> pagination(@RequestParam(name= "page", defaultValue = "0") Integer page,
                               @RequestParam(name= "pageSize", defaultValue = "10") Integer pageSize,
                               @RequestParam(name= "sortBy", defaultValue = "cdnRopingProduct") String sortBy,
                               @RequestParam(name= "direction", defaultValue = "DESC") String direction,
                               @RequestParam(name = "filter",required = false) Long filter) {
        return (ResponseEntity<ResponseDTO<Page<RopingProductDTO>>>) findCodeReturn(ropingproductService.pagination(page,pageSize,sortBy,direction,filter));
    }

    @PostMapping("/paginationFull")
    ResponseEntity<ResponseDTO<Page<RopingProductDTO>>> paginationFull(   @RequestParam(name= "page", defaultValue = "0") Integer page,
                                                                    @RequestParam(name= "pageSize", defaultValue = "10") Integer pageSize,
                                                                    @RequestParam(name= "sortBy", defaultValue = "cdnRopingProduct") String sortBy,
                                                                    @RequestParam(name= "direction", defaultValue = "DESC") String direction,
                                                                    @RequestBody Map<String, Object> filterMap) {
        return (ResponseEntity<ResponseDTO<Page<RopingProductDTO>>>) findCodeReturn(ropingproductService.paginationFull(page,pageSize,sortBy,direction,filterMap));
    }

    @PostMapping("/listAll")
    public ResponseEntity<ResponseDTO<List<RopingProductDTO>>> listAll (){
        return (ResponseEntity<ResponseDTO<List<RopingProductDTO>>>) findCodeReturn(ropingproductService.listAll());
    }

    @PostMapping("/listExample")
    public ResponseEntity<ResponseDTO<List<RopingProductDTO>>> listExample (@RequestBody RopingProductDTO ropingproductDTO){
        return (ResponseEntity<ResponseDTO<List<RopingProductDTO>>>) findCodeReturn(ropingproductService.listExample(ropingproductDTO));
    }

}
