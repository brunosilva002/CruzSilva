package br.cruzsilva.CruzSilva.rest;

import br.cruzsilva.CruzSilva.dto.CustomerDTO;
import br.cruzsilva.CruzSilva.dto.ResponseDTO;
import br.cruzsilva.CruzSilva.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/customer")
public class CustomerResource extends BaseResource {

    @Autowired
    CustomerService customerService;

    @PostMapping("/save")
    public ResponseEntity<ResponseDTO<CustomerDTO>> save (@RequestBody CustomerDTO customerDTO){
        return (ResponseEntity<ResponseDTO<CustomerDTO>>) findCodeReturn(customerService.save(customerDTO));
    }

    @GetMapping("/obtain")
    public ResponseEntity<ResponseDTO<CustomerDTO>> obtain (@RequestParam Long cdnCustomer){
        return (ResponseEntity<ResponseDTO<CustomerDTO>>) findCodeReturn(customerService.obtain(cdnCustomer));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> delete (@RequestParam Long cdnCustomer){
        return (ResponseEntity<ResponseDTO>) findCodeReturn(customerService.delete(cdnCustomer));
    }

    @GetMapping("/pagination")
    ResponseEntity<ResponseDTO<Page<CustomerDTO>>> pagination(@RequestParam(name= "page", defaultValue = "0") Integer page,
                               @RequestParam(name= "pageSize", defaultValue = "10") Integer pageSize,
                               @RequestParam(name= "sortBy", defaultValue = "cdnCustomer") String sortBy,
                               @RequestParam(name= "direction", defaultValue = "DESC") String direction,
                               @RequestParam(name = "filter",required = false) Long filter) {
        return (ResponseEntity<ResponseDTO<Page<CustomerDTO>>>) findCodeReturn(customerService.pagination(page,pageSize,sortBy,direction,filter));
    }

    @PostMapping("/paginationFull")
    ResponseEntity<ResponseDTO<Page<CustomerDTO>>> paginationFull(   @RequestParam(name= "page", defaultValue = "0") Integer page,
                                                                    @RequestParam(name= "pageSize", defaultValue = "10") Integer pageSize,
                                                                    @RequestParam(name= "sortBy", defaultValue = "cdnCustomer") String sortBy,
                                                                    @RequestParam(name= "direction", defaultValue = "DESC") String direction,
                                                                    @RequestBody Map<String, Object> filterMap) {
        return (ResponseEntity<ResponseDTO<Page<CustomerDTO>>>) findCodeReturn(customerService.paginationFull(page,pageSize,sortBy,direction,filterMap));
    }

    @PostMapping("/listAll")
    public ResponseEntity<ResponseDTO<List<CustomerDTO>>> listAll (){
        return (ResponseEntity<ResponseDTO<List<CustomerDTO>>>) findCodeReturn(customerService.listAll());
    }

    @PostMapping("/listExample")
    public ResponseEntity<ResponseDTO<List<CustomerDTO>>> listExample (@RequestBody CustomerDTO customerDTO){
        return (ResponseEntity<ResponseDTO<List<CustomerDTO>>>) findCodeReturn(customerService.listExample(customerDTO));
    }

}
