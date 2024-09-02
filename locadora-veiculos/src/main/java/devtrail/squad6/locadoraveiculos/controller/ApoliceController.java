package devtrail.squad6.locadoraveiculos.controller;

import devtrail.squad6.locadoraveiculos.model.entity.ApoliceSeguro;
import devtrail.squad6.locadoraveiculos.service.ApoliceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apolice")
public class ApoliceController {

    @Autowired
    private ApoliceServiceImpl apoliceService;

    @PostMapping("/adicionar")
    @ResponseStatus(HttpStatus.CREATED)
    public void adicionarApolice(@RequestBody ApoliceSeguro apoliceSeguro) {
        apoliceService.save(apoliceSeguro);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ApoliceSeguro buscarApolice(@PathVariable Long id) {
        return apoliceService.findById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ApoliceSeguro> buscarApolices() {
        return apoliceService.findAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerApolice(@PathVariable Long id) {
        apoliceService.deleteById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ApoliceSeguro atualizarApolice(@PathVariable Long id, @RequestBody ApoliceSeguro apoliceSeguro) {
        apoliceSeguro.setId(id);
        return apoliceService.save(apoliceSeguro);
    }
}
