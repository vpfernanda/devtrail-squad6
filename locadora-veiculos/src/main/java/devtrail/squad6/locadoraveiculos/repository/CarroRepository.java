package devtrail.squad6.locadoraveiculos.repository;

import devtrail.squad6.locadoraveiculos.model.entity.Acessorio;
import devtrail.squad6.locadoraveiculos.model.entity.Carro;
import devtrail.squad6.locadoraveiculos.model.entity.Fabricante;
import devtrail.squad6.locadoraveiculos.model.entity.ModeloCarro;
import devtrail.squad6.locadoraveiculos.model.entity.enums.Categoria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {

    boolean existsByPlaca(String placa);

    boolean existsByChassi(String chassi);

    Page<Carro> findAll(Pageable pageable);

    Page<Carro> findByModelo(ModeloCarro modelo, Pageable pageable);

    Page<Carro> findByModelo_Categoria(Categoria categoria, Pageable pageable);

    Page<Carro> findByModelo_Fabricante(Fabricante fabricante, Pageable pageable);

    Page<Carro> findByModelo_CategoriaAndAcessoriosIn(Categoria categoria, List<Acessorio> acessorios, Pageable pageable);

    Page<Carro> findByAcessoriosIn(List<Acessorio> acessorios, Pageable pageable);

    Page<Carro> findByAcessoriosContaining(Acessorio acessorio, Pageable pageable);
}
