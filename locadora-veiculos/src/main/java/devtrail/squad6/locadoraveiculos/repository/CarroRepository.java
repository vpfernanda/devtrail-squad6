package devtrail.squad6.locadoraveiculos.repository;

import devtrail.squad6.locadoraveiculos.model.entity.Acessorio;
import devtrail.squad6.locadoraveiculos.model.entity.Carro;
import devtrail.squad6.locadoraveiculos.model.entity.Fabricante;
import devtrail.squad6.locadoraveiculos.model.entity.ModeloCarro;
import devtrail.squad6.locadoraveiculos.model.entity.enums.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {

    boolean existsByPlaca(String placa);

    boolean existsByChassi(String chassi);

    List<Carro> findByModelo(ModeloCarro modelo);

    List<Carro> findByModelo_Categoria(Categoria categoria);

    List<Carro> findByModelo_Fabricante(Fabricante fabricante);

    List<Carro> findByModelo_CategoriaAndAcessoriosIn(Categoria categoria, List<Acessorio> acessorios);

    List<Carro> findByAcessoriosIn(List<Acessorio> acessorios);

    List<Carro> findByAcessoriosContaining(Acessorio acessorio);
}
