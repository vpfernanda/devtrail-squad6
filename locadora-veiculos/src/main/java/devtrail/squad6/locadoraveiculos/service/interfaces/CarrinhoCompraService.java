package devtrail.squad6.locadoraveiculos.service.interfaces;

import devtrail.squad6.locadoraveiculos.model.entity.CarrinhoCompra;
import devtrail.squad6.locadoraveiculos.model.entity.Carro;

import java.util.List;

public interface CarrinhoCompraService {
    CarrinhoCompra save(CarrinhoCompra carrinhoCompra);
    List<CarrinhoCompra> findAll();
    CarrinhoCompra findById(Long id);
    void removeAluguel(CarrinhoCompra carrinhoCompra, Long carroId);
}
