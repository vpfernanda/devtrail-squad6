package devtrail.squad6.locadoraveiculos.controller;

import devtrail.squad6.locadoraveiculos.model.entity.Aluguel;
import devtrail.squad6.locadoraveiculos.service.AluguelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/alugueis")
public class AlugueisController {

    @Autowired
    private AluguelServiceImpl aluguelService;

    @GetMapping("/all")
    public ResponseEntity<List<Aluguel>> findAll(){
        List<Aluguel> alugueis = aluguelService.findAll();
        if(alugueis.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null)
        }

        return ResponseEntity.status(HttpStatus.OK).body(alugueis);
    }


}
