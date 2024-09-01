package devtrail.squad6.locadoraveiculos.repository;

import devtrail.squad6.locadoraveiculos.model.entity.CarrinhoCompra;
import devtrail.squad6.locadoraveiculos.model.entity.Motorista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrinhoCompraRepository extends JpaRepository<CarrinhoCompra, Long> {
    CarrinhoCompra findByMotorista(Motorista motorista);
}