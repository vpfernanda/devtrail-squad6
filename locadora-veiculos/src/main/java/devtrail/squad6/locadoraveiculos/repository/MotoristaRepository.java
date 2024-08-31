package devtrail.squad6.locadoraveiculos.repository;

import devtrail.squad6.locadoraveiculos.model.entity.Motorista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotoristaRepository extends JpaRepository<Motorista, Long> {
    Motorista findMotoristaByEmail(String email);
    Motorista findMotoristaByCpf(String cpf);
    Motorista findMotoristasByNumeroCNH(String numeroCNH);
}
