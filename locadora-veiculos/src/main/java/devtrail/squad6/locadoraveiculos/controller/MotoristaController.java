package devtrail.squad6.locadoraveiculos.controller;

import devtrail.squad6.locadoraveiculos.model.entity.Motorista;
import devtrail.squad6.locadoraveiculos.service.MotoristaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/motoristas")
public class MotoristaController {

    @Autowired
    private MotoristaServiceImpl motoristaService;

    @GetMapping
    public List<Motorista> findAll() {
        return motoristaService.findAll();
    }

    @PostMapping
    public ResponseEntity<String> insert(@RequestBody @Validated Motorista motorista) {
        try {
            Motorista novoMotorista = motoristaService.save(motorista);
            return ResponseEntity.ok("Motorista cadastrado com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao cadastrar motorista: " + e.getMessage());
        }
    }

    @GetMapping("/{email}")
    public ResponseEntity<?> findByEmail(@PathVariable String email) {
        Motorista motorista = motoristaService.findByEmail(email);

        return motorista == null ? ResponseEntity.status(HttpStatus.NOT_FOUND).body("Email não encontrado!") : ResponseEntity.ok(motorista);
    }

    @DeleteMapping("/{motoristaId}")
    public ResponseEntity<String> removeMotorista(@PathVariable Long motoristaId) {
        try {
            motoristaService.remove(motoristaId);
            return ResponseEntity.ok("Motorista removido com sucesso");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao remover motorista: " + e.getMessage());
        }
    }
}
