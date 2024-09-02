package devtrail.squad6.locadoraveiculos.controller;

import devtrail.squad6.locadoraveiculos.model.dto.AluguelDTO;
import devtrail.squad6.locadoraveiculos.model.dto.ResumoCarrinhoDTO;
import devtrail.squad6.locadoraveiculos.service.CarrinhoCompraServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carrinho")
public class CarrinhoCompraController {

    @Autowired
    private CarrinhoCompraServiceImpl carrinhoCompraService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AluguelDTO> visualizarCarrinho(@RequestParam Long motoristaId) {
        return carrinhoCompraService.getAlugueisByMotoristaId(motoristaId);
    }

    @PostMapping("/adicionar")
    @ResponseStatus(HttpStatus.CREATED)
    public void adicionarAoCarrinho(@RequestParam Long motoristaId, @Valid @RequestBody AluguelDTO aluguelDTO) {
        carrinhoCompraService.addAluguelByMotoristaId(motoristaId, aluguelDTO);
    }

    @DeleteMapping("/remover/{carroId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerDoCarrinho(@RequestParam Long motoristaId, @PathVariable Long carroId) {
        carrinhoCompraService.removeAluguelByMotoristaId(motoristaId, carroId);
    }

    @GetMapping("/resumo")
    public ResponseEntity<ResumoCarrinhoDTO> obterResumoCarrinho(@RequestParam Long carrinhoId) {
        ResumoCarrinhoDTO resumo = carrinhoCompraService.obterResumoCarrinho(carrinhoId);
        return ResponseEntity.ok(resumo);
    }

    @PostMapping("/confirmar")
    public ResponseEntity<String> confirmarReserva(@RequestParam Long carrinhoId) {
        try {
            carrinhoCompraService.confirmarReserva(carrinhoId);
            return ResponseEntity.ok("Reserva confirmada com sucesso!");
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

}
