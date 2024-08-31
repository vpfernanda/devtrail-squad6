package devtrail.squad6.locadoraveiculos.service.interfaces;

import devtrail.squad6.locadoraveiculos.model.entity.Fabricante;

import java.util.List;

public interface FabricanteService {
    Fabricante save(Fabricante fabricante);
    List<Fabricante> findAll();
    Fabricante findById(Long id);
    void deleteById(Long id);
}
