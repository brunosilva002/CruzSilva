package br.cruzsilva.CruzSilva.rest;

import br.cruzsilva.CruzSilva.dto.RopingPaymentTypeDTO;
import br.cruzsilva.CruzSilva.dto.ResponseDTO;
import br.cruzsilva.CruzSilva.service.RopingPaymentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/ropingpaymenttype")
public class RopingPaymentTypeResource extends BaseResource {

    @Autowired
    RopingPaymentTypeService ropingpaymenttypeService;

    @PostMapping("/save")
    public ResponseEntity<ResponseDTO<RopingPaymentTypeDTO>> save (@RequestBody RopingPaymentTypeDTO ropingpaymenttypeDTO){
        return (ResponseEntity<ResponseDTO<RopingPaymentTypeDTO>>) findCodeReturn(ropingpaymenttypeService.save(ropingpaymenttypeDTO));
    }

    @GetMapping("/obtain")
    public ResponseEntity<ResponseDTO<RopingPaymentTypeDTO>> obtain (@RequestParam Long cdnRopingPaymentType){
        return (ResponseEntity<ResponseDTO<RopingPaymentTypeDTO>>) findCodeReturn(ropingpaymenttypeService.obtain(cdnRopingPaymentType));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> delete (@RequestParam Long cdnRopingPaymentType){
        return (ResponseEntity<ResponseDTO>) findCodeReturn(ropingpaymenttypeService.delete(cdnRopingPaymentType));
    }

    @GetMapping("/pagination")
    ResponseEntity<ResponseDTO<Page<RopingPaymentTypeDTO>>> pagination(@RequestParam(name= "page", defaultValue = "0") Integer page,
                               @RequestParam(name= "pageSize", defaultValue = "10") Integer pageSize,
                               @RequestParam(name= "sortBy", defaultValue = "cdnRopingPaymentType") String sortBy,
                               @RequestParam(name= "direction", defaultValue = "DESC") String direction,
                               @RequestParam(name = "filter",required = false) Long filter) {
        return (ResponseEntity<ResponseDTO<Page<RopingPaymentTypeDTO>>>) findCodeReturn(ropingpaymenttypeService.pagination(page,pageSize,sortBy,direction,filter));
    }

    @PostMapping("/paginationFull")
    ResponseEntity<ResponseDTO<Page<RopingPaymentTypeDTO>>> paginationFull(   @RequestParam(name= "page", defaultValue = "0") Integer page,
                                                                    @RequestParam(name= "pageSize", defaultValue = "10") Integer pageSize,
                                                                    @RequestParam(name= "sortBy", defaultValue = "cdnRopingPaymentType") String sortBy,
                                                                    @RequestParam(name= "direction", defaultValue = "DESC") String direction,
                                                                    @RequestBody Map<String, Object> filterMap) {
        return (ResponseEntity<ResponseDTO<Page<RopingPaymentTypeDTO>>>) findCodeReturn(ropingpaymenttypeService.paginationFull(page,pageSize,sortBy,direction,filterMap));
    }

    @PostMapping("/listAll")
    public ResponseEntity<ResponseDTO<List<RopingPaymentTypeDTO>>> listAll (){
        return (ResponseEntity<ResponseDTO<List<RopingPaymentTypeDTO>>>) findCodeReturn(ropingpaymenttypeService.listAll());
    }

    @PostMapping("/listExample")
    public ResponseEntity<ResponseDTO<List<RopingPaymentTypeDTO>>> listExample (@RequestBody RopingPaymentTypeDTO ropingpaymenttypeDTO){
        return (ResponseEntity<ResponseDTO<List<RopingPaymentTypeDTO>>>) findCodeReturn(ropingpaymenttypeService.listExample(ropingpaymenttypeDTO));
    }

}
