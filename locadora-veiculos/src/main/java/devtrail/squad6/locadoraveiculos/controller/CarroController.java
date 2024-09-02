package devtrail.squad6.locadoraveiculos.controller;

import devtrail.squad6.locadoraveiculos.model.dto.CarroDTO;
import devtrail.squad6.locadoraveiculos.model.dto.CarroDetalheDTO;
import devtrail.squad6.locadoraveiculos.model.dto.CarroForm;
import devtrail.squad6.locadoraveiculos.model.dto.FiltroCarroDTO;
import devtrail.squad6.locadoraveiculos.service.CarroServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carros")
public class CarroController {

    @Autowired
    private CarroServiceImpl service;

    @GetMapping
    public ResponseEntity<Page<CarroDTO>> listAll(Pageable pageable){
        Page<CarroDTO> carros = service.findAll(pageable);
        return new ResponseEntity<Page<CarroDTO>>(carros, HttpStatus.OK);
    }

    @GetMapping("/filter")
    public ResponseEntity<Page<CarroDTO>> listByFilter(@RequestBody FiltroCarroDTO filtroCarroDTO, Pageable pageable) {
        Page<CarroDTO> carros = service.findByFilter(filtroCarroDTO, pageable);

        return new ResponseEntity<Page<CarroDTO>>(carros, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarroDetalheDTO> findById(@Valid @PathVariable Long id) {
        CarroDetalheDTO carroDetalhe = service.findById(id);
        return new ResponseEntity<CarroDetalheDTO>(carroDetalhe, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CarroDetalheDTO> save(@RequestBody CarroForm carroForm) {
        CarroDetalheDTO carroDetalheDTO = service.save(carroForm);
        return new ResponseEntity<CarroDetalheDTO>(carroDetalheDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
