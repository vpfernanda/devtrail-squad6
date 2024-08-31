package devtrail.squad6.locadoraveiculos.service.interfaces;

import java.util.List;

public interface ApoliceSeguro {
    ApoliceSeguro findById(Long id);
    ApoliceSeguro save(ApoliceSeguro apoliceSeguro);
    List<ApoliceSeguro> findAll();
    void deleteById(Long id);
}
