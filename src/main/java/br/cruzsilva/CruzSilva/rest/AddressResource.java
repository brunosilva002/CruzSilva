package br.cruzsilva.CruzSilva.rest;

import br.cruzsilva.CruzSilva.dto.AddressDTO;
import br.cruzsilva.CruzSilva.dto.ResponseDTO;
import br.cruzsilva.CruzSilva.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/address")
public class AddressResource extends BaseResource {

    @Autowired
    AddressService addressService;

    @PostMapping("/save")
    public ResponseEntity<ResponseDTO<AddressDTO>> save (@RequestBody AddressDTO addressDTO){
        return (ResponseEntity<ResponseDTO<AddressDTO>>) findCodeReturn(addressService.save(addressDTO));
    }

    @GetMapping("/obtain")
    public ResponseEntity<ResponseDTO<AddressDTO>> obtain (@RequestParam Long cdnAddress){
        return (ResponseEntity<ResponseDTO<AddressDTO>>) findCodeReturn(addressService.obtain(cdnAddress));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> delete (@RequestParam Long cdnAddress){
        return (ResponseEntity<ResponseDTO>) findCodeReturn(addressService.delete(cdnAddress));
    }

    @GetMapping("/pagination")
    ResponseEntity<ResponseDTO<Page<AddressDTO>>> pagination(@RequestParam(name= "page", defaultValue = "0") Integer page,
                               @RequestParam(name= "pageSize", defaultValue = "10") Integer pageSize,
                               @RequestParam(name= "sortBy", defaultValue = "cdnAddress") String sortBy,
                               @RequestParam(name= "direction", defaultValue = "DESC") String direction,
                               @RequestParam(name = "filter",required = false) Long filter) {
        return (ResponseEntity<ResponseDTO<Page<AddressDTO>>>) findCodeReturn(addressService.pagination(page,pageSize,sortBy,direction,filter));
    }

    @PostMapping("/paginationFull")
    ResponseEntity<ResponseDTO<Page<AddressDTO>>> paginationFull(   @RequestParam(name= "page", defaultValue = "0") Integer page,
                                                                    @RequestParam(name= "pageSize", defaultValue = "10") Integer pageSize,
                                                                    @RequestParam(name= "sortBy", defaultValue = "cdnAddress") String sortBy,
                                                                    @RequestParam(name= "direction", defaultValue = "DESC") String direction,
                                                                    @RequestBody Map<String, Object> filterMap) {
        return (ResponseEntity<ResponseDTO<Page<AddressDTO>>>) findCodeReturn(addressService.paginationFull(page,pageSize,sortBy,direction,filterMap));
    }

    @PostMapping("/listAll")
    public ResponseEntity<ResponseDTO<List<AddressDTO>>> listAll (){
        return (ResponseEntity<ResponseDTO<List<AddressDTO>>>) findCodeReturn(addressService.listAll());
    }

    @PostMapping("/listExample")
    public ResponseEntity<ResponseDTO<List<AddressDTO>>> listExample (@RequestBody AddressDTO addressDTO){
        return (ResponseEntity<ResponseDTO<List<AddressDTO>>>) findCodeReturn(addressService.listExample(addressDTO));
    }

}
