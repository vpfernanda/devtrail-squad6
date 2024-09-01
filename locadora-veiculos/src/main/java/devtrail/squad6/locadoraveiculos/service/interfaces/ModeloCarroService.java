package devtrail.squad6.locadoraveiculos.service.interfaces;

import devtrail.squad6.locadoraveiculos.model.entity.ModeloCarro;

import java.util.List;

public interface ModeloCarroService {
    ModeloCarro save(ModeloCarro modeloCarro);
    List<ModeloCarro> findAll();
    ModeloCarro findById(Long id);
    void deleteById(Long id);
}
