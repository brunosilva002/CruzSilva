package br.cruzsilva.CruzSilva.rest;

import br.cruzsilva.CruzSilva.dto.PaymentDTO;
import br.cruzsilva.CruzSilva.dto.ResponseDTO;
import br.cruzsilva.CruzSilva.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/payment")
public class PaymentResource extends BaseResource {

    @Autowired
    PaymentService paymentService;

    @PostMapping("/save")
    public ResponseEntity<ResponseDTO<PaymentDTO>> save (@RequestBody PaymentDTO paymentDTO){
        return (ResponseEntity<ResponseDTO<PaymentDTO>>) findCodeReturn(paymentService.save(paymentDTO));
    }

    @GetMapping("/obtain")
    public ResponseEntity<ResponseDTO<PaymentDTO>> obtain (@RequestParam Long cdnPayment){
        return (ResponseEntity<ResponseDTO<PaymentDTO>>) findCodeReturn(paymentService.obtain(cdnPayment));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> delete (@RequestParam Long cdnPayment){
        return (ResponseEntity<ResponseDTO>) findCodeReturn(paymentService.delete(cdnPayment));
    }

    @GetMapping("/pagination")
    ResponseEntity<ResponseDTO<Page<PaymentDTO>>> pagination(@RequestParam(name= "page", defaultValue = "0") Integer page,
                               @RequestParam(name= "pageSize", defaultValue = "10") Integer pageSize,
                               @RequestParam(name= "sortBy", defaultValue = "cdnPayment") String sortBy,
                               @RequestParam(name= "direction", defaultValue = "DESC") String direction,
                               @RequestParam(name = "filter",required = false) Long filter) {
        return (ResponseEntity<ResponseDTO<Page<PaymentDTO>>>) findCodeReturn(paymentService.pagination(page,pageSize,sortBy,direction,filter));
    }

    @PostMapping("/paginationFull")
    ResponseEntity<ResponseDTO<Page<PaymentDTO>>> paginationFull(   @RequestParam(name= "page", defaultValue = "0") Integer page,
                                                                    @RequestParam(name= "pageSize", defaultValue = "10") Integer pageSize,
                                                                    @RequestParam(name= "sortBy", defaultValue = "cdnPayment") String sortBy,
                                                                    @RequestParam(name= "direction", defaultValue = "DESC") String direction,
                                                                    @RequestBody Map<String, Object> filterMap) {
        return (ResponseEntity<ResponseDTO<Page<PaymentDTO>>>) findCodeReturn(paymentService.paginationFull(page,pageSize,sortBy,direction,filterMap));
    }

    @PostMapping("/listAll")
    public ResponseEntity<ResponseDTO<List<PaymentDTO>>> listAll (){
        return (ResponseEntity<ResponseDTO<List<PaymentDTO>>>) findCodeReturn(paymentService.listAll());
    }

    @PostMapping("/listExample")
    public ResponseEntity<ResponseDTO<List<PaymentDTO>>> listExample (@RequestBody PaymentDTO paymentDTO){
        return (ResponseEntity<ResponseDTO<List<PaymentDTO>>>) findCodeReturn(paymentService.listExample(paymentDTO));
    }

}
