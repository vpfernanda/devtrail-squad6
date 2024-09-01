package devtrail.squad6.locadoraveiculos.controller;

import devtrail.squad6.locadoraveiculos.model.entity.Acessorio;
import devtrail.squad6.locadoraveiculos.service.AcessorioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/acessorios")
public class AcessorioController {

    @Autowired
    private AcessorioServiceImpl acessorioService;

    @GetMapping
    public ResponseEntity<List<Acessorio>> findAll() {
        try {
            List<Acessorio> acessorios = acessorioService.findAll();
            return ResponseEntity.ok(acessorios);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        try {
            Acessorio acessorio = acessorioService.findById(id);
            return acessorio != null ? ResponseEntity.ok(acessorio) : ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Acessório não encontrado com o ID: " + id);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao buscar acessório: " + e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<String> insert(@RequestBody Acessorio acessorio) {
        try {
            acessorioService.save(acessorio);
            return ResponseEntity.ok("Acessório cadastrado com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao cadastrar acessório: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeById(@PathVariable Long id) {
        try {
            acessorioService.deleteById(id);
            return ResponseEntity.ok("Acessório removido com sucesso");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Erro ao remover acessório: " + e.getMessage());
        }
    }
}
