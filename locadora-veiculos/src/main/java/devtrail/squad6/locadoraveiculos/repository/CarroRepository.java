package devtrail.squad6.locadoraveiculos.repository;

import devtrail.squad6.locadoraveiculos.model.entity.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository<Carro, Long> {
}
