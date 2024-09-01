package devtrail.squad6.locadoraveiculos.repository;

import devtrail.squad6.locadoraveiculos.model.entity.Acessorio;
import devtrail.squad6.locadoraveiculos.model.entity.Carro;
import devtrail.squad6.locadoraveiculos.model.entity.ModeloCarro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {

    boolean existsByPlaca(String placa);

    boolean existsByChassi(String chassi);

    List<Carro> findByModeloCarro(ModeloCarro modelo);

    List<Carro> findByAcessoriosContaining(Acessorio acessorio);
}
