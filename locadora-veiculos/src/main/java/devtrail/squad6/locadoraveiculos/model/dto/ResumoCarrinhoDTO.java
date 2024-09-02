package devtrail.squad6.locadoraveiculos.model.dto;

import java.math.BigDecimal;
import java.util.List;

public record ResumoCarrinhoDTO(List<AluguelDTO> itens, BigDecimal total) {
}
