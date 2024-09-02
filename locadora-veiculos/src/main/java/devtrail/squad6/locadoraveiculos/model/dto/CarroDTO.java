package devtrail.squad6.locadoraveiculos.model.dto;

import devtrail.squad6.locadoraveiculos.model.entity.Acessorio;
import devtrail.squad6.locadoraveiculos.model.entity.ModeloCarro;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CarroDTO {

    private Long id;

    private ModeloCarro modeloCarro;

    private List<Acessorio> acessorios;

    private byte[] imagem;

}
