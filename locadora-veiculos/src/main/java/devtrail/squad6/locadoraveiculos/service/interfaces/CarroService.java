package devtrail.squad6.locadoraveiculos.service.interfaces;

import devtrail.squad6.locadoraveiculos.model.entity.Carro;

import java.util.List;

public interface CarroService {
    Carro save(Carro carro);
    List<Carro> findAll();
    Carro findById(Long id);
    void deleteById(Long id);

}
