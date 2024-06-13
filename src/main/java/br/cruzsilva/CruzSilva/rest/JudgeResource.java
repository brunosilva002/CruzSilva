package br.cruzsilva.CruzSilva.rest;

import br.cruzsilva.CruzSilva.dto.JudgeDTO;
import br.cruzsilva.CruzSilva.dto.ResponseDTO;
import br.cruzsilva.CruzSilva.service.JudgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/judge")
public class JudgeResource extends BaseResource {

    @Autowired
    JudgeService judgeService;

    @PostMapping("/save")
    public ResponseEntity<ResponseDTO<JudgeDTO>> save (@RequestBody JudgeDTO judgeDTO){
        return (ResponseEntity<ResponseDTO<JudgeDTO>>) findCodeReturn(judgeService.save(judgeDTO));
    }

    @GetMapping("/obtain")
    public ResponseEntity<ResponseDTO<JudgeDTO>> obtain (@RequestParam Long cdnJudge){
        return (ResponseEntity<ResponseDTO<JudgeDTO>>) findCodeReturn(judgeService.obtain(cdnJudge));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> delete (@RequestParam Long cdnJudge){
        return (ResponseEntity<ResponseDTO>) findCodeReturn(judgeService.delete(cdnJudge));
    }

    @GetMapping("/pagination")
    ResponseEntity<ResponseDTO<Page<JudgeDTO>>> pagination(@RequestParam(name= "page", defaultValue = "0") Integer page,
                               @RequestParam(name= "pageSize", defaultValue = "10") Integer pageSize,
                               @RequestParam(name= "sortBy", defaultValue = "cdnJudge") String sortBy,
                               @RequestParam(name= "direction", defaultValue = "DESC") String direction,
                               @RequestParam(name = "filter",required = false) Long filter) {
        return (ResponseEntity<ResponseDTO<Page<JudgeDTO>>>) findCodeReturn(judgeService.pagination(page,pageSize,sortBy,direction,filter));
    }

    @PostMapping("/paginationFull")
    ResponseEntity<ResponseDTO<Page<JudgeDTO>>> paginationFull(   @RequestParam(name= "page", defaultValue = "0") Integer page,
                                                                    @RequestParam(name= "pageSize", defaultValue = "10") Integer pageSize,
                                                                    @RequestParam(name= "sortBy", defaultValue = "cdnJudge") String sortBy,
                                                                    @RequestParam(name= "direction", defaultValue = "DESC") String direction,
                                                                    @RequestBody Map<String, Object> filterMap) {
        return (ResponseEntity<ResponseDTO<Page<JudgeDTO>>>) findCodeReturn(judgeService.paginationFull(page,pageSize,sortBy,direction,filterMap));
    }

    @PostMapping("/listAll")
    public ResponseEntity<ResponseDTO<List<JudgeDTO>>> listAll (){
        return (ResponseEntity<ResponseDTO<List<JudgeDTO>>>) findCodeReturn(judgeService.listAll());
    }

    @PostMapping("/listExample")
    public ResponseEntity<ResponseDTO<List<JudgeDTO>>> listExample (@RequestBody JudgeDTO judgeDTO){
        return (ResponseEntity<ResponseDTO<List<JudgeDTO>>>) findCodeReturn(judgeService.listExample(judgeDTO));
    }

}
