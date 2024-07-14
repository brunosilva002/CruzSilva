package br.cruzsilva.CruzSilva.rest;

import br.cruzsilva.CruzSilva.dto.PaymentTypeDTO;
import br.cruzsilva.CruzSilva.dto.ResponseDTO;
import br.cruzsilva.CruzSilva.service.PaymentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/paymenttype")
public class PaymentTypeResource extends BaseResource {

    @Autowired
    PaymentTypeService paymenttypeService;

    @PostMapping("/save")
    public ResponseEntity<ResponseDTO<PaymentTypeDTO>> save (@RequestBody PaymentTypeDTO paymenttypeDTO){
        return (ResponseEntity<ResponseDTO<PaymentTypeDTO>>) findCodeReturn(paymenttypeService.save(paymenttypeDTO));
    }

    @GetMapping("/obtain")
    public ResponseEntity<ResponseDTO<PaymentTypeDTO>> obtain (@RequestParam Long cdnPaymentType){
        return (ResponseEntity<ResponseDTO<PaymentTypeDTO>>) findCodeReturn(paymenttypeService.obtain(cdnPaymentType));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> delete (@RequestParam Long cdnPaymentType){
        return (ResponseEntity<ResponseDTO>) findCodeReturn(paymenttypeService.delete(cdnPaymentType));
    }

    @GetMapping("/pagination")
    ResponseEntity<ResponseDTO<Page<PaymentTypeDTO>>> pagination(@RequestParam(name= "page", defaultValue = "0") Integer page,
                               @RequestParam(name= "pageSize", defaultValue = "10") Integer pageSize,
                               @RequestParam(name= "sortBy", defaultValue = "cdnPaymentType") String sortBy,
                               @RequestParam(name= "direction", defaultValue = "DESC") String direction,
                               @RequestParam(name = "filter",required = false) Long filter) {
        return (ResponseEntity<ResponseDTO<Page<PaymentTypeDTO>>>) findCodeReturn(paymenttypeService.pagination(page,pageSize,sortBy,direction,filter));
    }

    @PostMapping("/paginationFull")
    ResponseEntity<ResponseDTO<Page<PaymentTypeDTO>>> paginationFull(   @RequestParam(name= "page", defaultValue = "0") Integer page,
                                                                    @RequestParam(name= "pageSize", defaultValue = "10") Integer pageSize,
                                                                    @RequestParam(name= "sortBy", defaultValue = "cdnPaymentType") String sortBy,
                                                                    @RequestParam(name= "direction", defaultValue = "DESC") String direction,
                                                                    @RequestBody Map<String, Object> filterMap) {
        return (ResponseEntity<ResponseDTO<Page<PaymentTypeDTO>>>) findCodeReturn(paymenttypeService.paginationFull(page,pageSize,sortBy,direction,filterMap));
    }

    @PostMapping("/listAll")
    public ResponseEntity<ResponseDTO<List<PaymentTypeDTO>>> listAll (){
        return (ResponseEntity<ResponseDTO<List<PaymentTypeDTO>>>) findCodeReturn(paymenttypeService.listAll());
    }

    @PostMapping("/listExample")
    public ResponseEntity<ResponseDTO<List<PaymentTypeDTO>>> listExample (@RequestBody PaymentTypeDTO paymenttypeDTO){
        return (ResponseEntity<ResponseDTO<List<PaymentTypeDTO>>>) findCodeReturn(paymenttypeService.listExample(paymenttypeDTO));
    }

}
