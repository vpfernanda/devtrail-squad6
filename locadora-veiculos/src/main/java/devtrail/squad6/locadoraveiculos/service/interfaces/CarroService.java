package devtrail.squad6.locadoraveiculos.service.interfaces;

import devtrail.squad6.locadoraveiculos.model.dto.CarroDTO;
import devtrail.squad6.locadoraveiculos.model.dto.CarroDetalheDTO;
import devtrail.squad6.locadoraveiculos.model.entity.Carro;

import java.util.List;

public interface CarroService {
    Carro save(Carro carro);
    List<CarroDTO> findAll();
    CarroDetalheDTO findById(Long id);
    void deleteById(Long id);

}
