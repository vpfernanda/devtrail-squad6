package devtrail.squad6.locadoraveiculos.service.interfaces;

import devtrail.squad6.locadoraveiculos.model.entity.Aluguel;

import java.util.List;

public interface AluguelService {

    Aluguel save(Aluguel aluguel);
    List<Aluguel> findAll();
}
