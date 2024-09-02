package devtrail.squad6.locadoraveiculos.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PagamentoDTO {
    private String numeroCartao;
    private String dataExpiracao;
    private String cvv;
}
