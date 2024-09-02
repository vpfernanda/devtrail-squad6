package devtrail.squad6.locadoraveiculos.service.interfaces;

import devtrail.squad6.locadoraveiculos.model.dto.CarroDTO;
import devtrail.squad6.locadoraveiculos.model.dto.CarroDetalheDTO;
import devtrail.squad6.locadoraveiculos.model.dto.CarroForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CarroService {
    CarroDetalheDTO save(CarroForm carroForm);
    Page<CarroDTO> findAll(Pageable pageable);
    CarroDetalheDTO findById(Long id);
    void deleteById(Long id);

}
