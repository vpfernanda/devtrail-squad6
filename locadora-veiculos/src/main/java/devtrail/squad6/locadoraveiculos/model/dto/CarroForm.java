package devtrail.squad6.locadoraveiculos.model.dto;

import devtrail.squad6.locadoraveiculos.model.entity.Acessorio;
import devtrail.squad6.locadoraveiculos.model.entity.ModeloCarro;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CarroForm {

    private String placa;

    private String chassi;

    private String cor;

    private BigDecimal valorDiaria;

    private byte[] imagem;

    private List<Acessorio> acessorios;

    private ModeloCarro modelo;
}
