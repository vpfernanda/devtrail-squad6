package devtrail.squad6.locadoraveiculos.model.dto;

import devtrail.squad6.locadoraveiculos.model.entity.Acessorio;
import devtrail.squad6.locadoraveiculos.model.entity.enums.Categoria;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FiltroCarroDTO implements Serializable {
    @NotNull(message = "categoria não pode ser nula")
    Categoria categoria;
    @NotNull(message = "lista de acessorios não pode ser vazia")
    List<@NotNull(message = "o acessorio não pode ser nulo") Acessorio> acessorios;
}
