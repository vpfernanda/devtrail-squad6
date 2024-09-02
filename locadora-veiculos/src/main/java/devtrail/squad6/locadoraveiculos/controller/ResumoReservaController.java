package devtrail.squad6.locadoraveiculos.controller;

import devtrail.squad6.locadoraveiculos.service.AluguelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resumo-reserva")
public class ResumoReservaController {

    @Autowired
    private AluguelServiceImpl aluguelService;

    @GetMapping
    public ResponseEntity<String> resumoReserva() {

        String resumo = aluguelService.toString();

        if (resumo != null) {
            return ResponseEntity.status(HttpStatus.OK).body(resumo);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Resumo da reserva não encontrado.");
        }
    }
}

