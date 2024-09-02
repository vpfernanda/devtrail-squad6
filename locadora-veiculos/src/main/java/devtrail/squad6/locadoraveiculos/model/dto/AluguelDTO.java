package devtrail.squad6.locadoraveiculos.model.dto;

import jakarta.persistence.Embeddable;

import java.time.LocalDate;

@Embeddable
public record AluguelDTO(Long carroId, Long MotoristaId, LocalDate dataPedido, LocalDate dataEntrega) {
}
