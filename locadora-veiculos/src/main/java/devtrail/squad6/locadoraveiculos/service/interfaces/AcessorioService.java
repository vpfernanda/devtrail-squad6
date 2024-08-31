package devtrail.squad6.locadoraveiculos.service.interfaces;

import devtrail.squad6.locadoraveiculos.model.entity.Acessorio;

import java.util.List;

public interface AcessorioService {
    Acessorio findById(Long id);
    Acessorio save(Acessorio acessorio);
    List<Acessorio> findAll();
    void deleteById(Long id);
}
