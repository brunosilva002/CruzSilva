package br.cruzsilva.CruzSilva.rest;

import br.cruzsilva.CruzSilva.dto.PessoaDTO;
import br.cruzsilva.CruzSilva.dto.ResponseDTO;
import br.cruzsilva.CruzSilva.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/pessoa")
public class PessoaResource extends BaseResource {

    @Autowired
    PessoaService pessoaService;

    @PostMapping("/save")
    public ResponseEntity<ResponseDTO<PessoaDTO>> save (@RequestBody PessoaDTO pessoaDTO){
        return (ResponseEntity<ResponseDTO<PessoaDTO>>) findCodeReturn(pessoaService.save(pessoaDTO));
    }

    @GetMapping("/obtain")
    public ResponseEntity<ResponseDTO<PessoaDTO>> obtain (@RequestParam Long cdnPessoa){
        return (ResponseEntity<ResponseDTO<PessoaDTO>>) findCodeReturn(pessoaService.obtain(cdnPessoa));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> delete (@RequestParam Long cdnPessoa){
        return (ResponseEntity<ResponseDTO>) findCodeReturn(pessoaService.delete(cdnPessoa));
    }

    @GetMapping("/pagination")
    ResponseEntity<ResponseDTO<Page<PessoaDTO>>> pagination(@RequestParam(name= "page", defaultValue = "0") Integer page,
                               @RequestParam(name= "pageSize", defaultValue = "10") Integer pageSize,
                               @RequestParam(name= "sortBy", defaultValue = "cdnPessoa") String sortBy,
                               @RequestParam(name= "direction", defaultValue = "DESC") String direction,
                               @RequestParam(name = "filter",required = false) Long filter) {
        return (ResponseEntity<ResponseDTO<Page<PessoaDTO>>>) findCodeReturn(pessoaService.pagination(page,pageSize,sortBy,direction,filter));
    }

    @PostMapping("/paginationFull")
    ResponseEntity<ResponseDTO<Page<PessoaDTO>>> paginationFull(   @RequestParam(name= "page", defaultValue = "0") Integer page,
                                                                    @RequestParam(name= "pageSize", defaultValue = "10") Integer pageSize,
                                                                    @RequestParam(name= "sortBy", defaultValue = "cdnPessoa") String sortBy,
                                                                    @RequestParam(name= "direction", defaultValue = "DESC") String direction,
                                                                    @RequestBody Map<String, Object> filterMap) {
        return (ResponseEntity<ResponseDTO<Page<PessoaDTO>>>) findCodeReturn(pessoaService.paginationFull(page,pageSize,sortBy,direction,filterMap));
    }

    @PostMapping("/listAll")
    public ResponseEntity<ResponseDTO<List<PessoaDTO>>> listAll (){
        return (ResponseEntity<ResponseDTO<List<PessoaDTO>>>) findCodeReturn(pessoaService.listAll());
    }

    @PostMapping("/listExample")
    public ResponseEntity<ResponseDTO<List<PessoaDTO>>> listExample (@RequestBody PessoaDTO pessoaDTO){
        return (ResponseEntity<ResponseDTO<List<PessoaDTO>>>) findCodeReturn(pessoaService.listExample(pessoaDTO));
    }

}
