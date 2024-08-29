package devtrail.squad6.locadoraveiculos.repository;

import devtrail.squad6.locadoraveiculos.model.entity.Aluguel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AluguelRepository extends JpaRepository<Aluguel, Long> {
}
