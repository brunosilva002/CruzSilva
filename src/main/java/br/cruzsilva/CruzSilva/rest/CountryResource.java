package br.cruzsilva.CruzSilva.rest;

import br.cruzsilva.CruzSilva.dto.CountryDTO;
import br.cruzsilva.CruzSilva.dto.ResponseDTO;
import br.cruzsilva.CruzSilva.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/country")
public class CountryResource extends BaseResource {

    @Autowired
    CountryService countryService;

    @PostMapping("/save")
    public ResponseEntity<ResponseDTO<CountryDTO>> save (@RequestBody CountryDTO countryDTO){
        return (ResponseEntity<ResponseDTO<CountryDTO>>) findCodeReturn(countryService.save(countryDTO));
    }

    @GetMapping("/obtain")
    public ResponseEntity<ResponseDTO<CountryDTO>> obtain (@RequestParam Long cdnCountry){
        return (ResponseEntity<ResponseDTO<CountryDTO>>) findCodeReturn(countryService.obtain(cdnCountry));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> delete (@RequestParam Long cdnCountry){
        return (ResponseEntity<ResponseDTO>) findCodeReturn(countryService.delete(cdnCountry));
    }

    @GetMapping("/pagination")
    ResponseEntity<ResponseDTO<Page<CountryDTO>>> pagination(@RequestParam(name= "page", defaultValue = "0") Integer page,
                               @RequestParam(name= "pageSize", defaultValue = "10") Integer pageSize,
                               @RequestParam(name= "sortBy", defaultValue = "cdnCountry") String sortBy,
                               @RequestParam(name= "direction", defaultValue = "DESC") String direction,
                               @RequestParam(name = "filter",required = false) Long filter) {
        return (ResponseEntity<ResponseDTO<Page<CountryDTO>>>) findCodeReturn(countryService.pagination(page,pageSize,sortBy,direction,filter));
    }

    @PostMapping("/paginationFull")
    ResponseEntity<ResponseDTO<Page<CountryDTO>>> paginationFull(   @RequestParam(name= "page", defaultValue = "0") Integer page,
                                                                    @RequestParam(name= "pageSize", defaultValue = "10") Integer pageSize,
                                                                    @RequestParam(name= "sortBy", defaultValue = "cdnCountry") String sortBy,
                                                                    @RequestParam(name= "direction", defaultValue = "DESC") String direction,
                                                                    @RequestBody Map<String, Object> filterMap) {
        return (ResponseEntity<ResponseDTO<Page<CountryDTO>>>) findCodeReturn(countryService.paginationFull(page,pageSize,sortBy,direction,filterMap));
    }

    @PostMapping("/listAll")
    public ResponseEntity<ResponseDTO<List<CountryDTO>>> listAll (){
        return (ResponseEntity<ResponseDTO<List<CountryDTO>>>) findCodeReturn(countryService.listAll());
    }

    @PostMapping("/listExample")
    public ResponseEntity<ResponseDTO<List<CountryDTO>>> listExample (@RequestBody CountryDTO countryDTO){
        return (ResponseEntity<ResponseDTO<List<CountryDTO>>>) findCodeReturn(countryService.listExample(countryDTO));
    }

}
