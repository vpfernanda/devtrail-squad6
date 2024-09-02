package devtrail.squad6.locadoraveiculos.controller;

import devtrail.squad6.locadoraveiculos.model.entity.Aluguel;
import devtrail.squad6.locadoraveiculos.model.entity.Motorista;
import devtrail.squad6.locadoraveiculos.service.AluguelServiceImpl;
import devtrail.squad6.locadoraveiculos.service.MotoristaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/alugueis")
public class AlugueisController {

    @Autowired
    private AluguelServiceImpl aluguelService;

    @Autowired
    private MotoristaServiceImpl motoristaService;


    @GetMapping("/all")
    public ResponseEntity<List<Aluguel>> findAll(){
        List<Aluguel> alugueis = aluguelService.findAll();
        if(alugueis.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }

        return ResponseEntity.status(HttpStatus.OK).body(alugueis);
    }

    @GetMapping(value = "/{email}")
    public ResponseEntity<List<Aluguel>> findByEmail(@PathVariable("email") String email){
        try{
            Motorista motorista = motoristaService.findByEmail(email);
            if(motorista == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            List<Aluguel> alugueisMotorista = aluguelService.findAlugueisMotorista(motorista);
            if(alugueisMotorista.isEmpty()){
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
            }
            return ResponseEntity.status(HttpStatus.OK).body(alugueisMotorista);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody Aluguel aluguel){
        try{
            LocalDate hoje = LocalDate.now();
            aluguel.setDataPedido(hoje);
            aluguelService.save(aluguel);
            return ResponseEntity.status(HttpStatus.CREATED).body("Aluguel realizado com sucesso.");
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}
