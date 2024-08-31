package devtrail.squad6.locadoraveiculos.repository;

import devtrail.squad6.locadoraveiculos.model.entity.Categoria;
import devtrail.squad6.locadoraveiculos.model.entity.ModeloCarro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModeloCarroRepository extends JpaRepository<ModeloCarro, Long> {
    List<ModeloCarro> findModeloCarroByCategoria(Categoria categoria);
}
