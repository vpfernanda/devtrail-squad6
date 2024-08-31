package devtrail.squad6.locadoraveiculos.service.interfaces;

import devtrail.squad6.locadoraveiculos.model.entity.Motorista;

import java.util.List;

public interface MotoristaService {
    Motorista save(Motorista motorista);
    List<Motorista> findAll();
    Motorista findByEmail(String email);
    void deleteById(Long id);
}
