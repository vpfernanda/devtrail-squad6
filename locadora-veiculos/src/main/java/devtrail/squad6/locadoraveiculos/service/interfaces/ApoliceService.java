package devtrail.squad6.locadoraveiculos.service.interfaces;

import devtrail.squad6.locadoraveiculos.model.entity.ApoliceSeguro;

import java.util.List;

public interface ApoliceService {
    ApoliceSeguro findById(Long id);
    ApoliceSeguro save(ApoliceSeguro apoliceService);
    List<ApoliceSeguro> findAll();
    void deleteById(Long id);
}
