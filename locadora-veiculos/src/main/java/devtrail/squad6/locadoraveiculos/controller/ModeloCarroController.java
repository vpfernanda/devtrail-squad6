package devtrail.squad6.locadoraveiculos.controller;

import devtrail.squad6.locadoraveiculos.model.entity.ModeloCarro;
import devtrail.squad6.locadoraveiculos.model.entity.enums.Categoria;
import devtrail.squad6.locadoraveiculos.service.ModeloCarroServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/modelos-carro")
public class ModeloCarroController {

    @Autowired
    private ModeloCarroServiceImpl modeloCarroService;

    @GetMapping
    public ResponseEntity<List<ModeloCarro>> findAll() {
        try {
            List<ModeloCarro> modelos = modeloCarroService.findAll();
            return ResponseEntity.ok(modelos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @PostMapping
    public ResponseEntity<String> insert(@RequestBody ModeloCarro modeloCarro) {
        try {
            modeloCarroService.save(modeloCarro);
            return ResponseEntity.ok("Modelo de carro cadastrado com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao cadastrar modelo de carro: " + e.getMessage());
        }
    }

    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<List<ModeloCarro>> findByCategoria(@PathVariable Categoria categoria) {
        try {
            List<ModeloCarro> modelos = modeloCarroService.findByCategoria(categoria);
            return modelos.isEmpty() ? ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null) : ResponseEntity.ok(modelos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        try {
            ModeloCarro modeloCarro = modeloCarroService.findById(id);
            return ResponseEntity.ok(modeloCarro);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Modelo de carro não encontrado com o ID: " + id);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        try {
            modeloCarroService.deleteById(id);
            return ResponseEntity.ok("Modelo de carro removido com sucesso");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao remover modelo de carro: " + e.getMessage());
        }
    }
}
