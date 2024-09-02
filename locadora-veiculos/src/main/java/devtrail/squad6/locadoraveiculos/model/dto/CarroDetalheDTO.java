package devtrail.squad6.locadoraveiculos.model.dto;

import devtrail.squad6.locadoraveiculos.model.entity.Acessorio;
import devtrail.squad6.locadoraveiculos.model.entity.Aluguel;
import devtrail.squad6.locadoraveiculos.model.entity.ModeloCarro;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CarroDetalheDTO {

    private Long id;

    private String placa;

    private String chassi;

    private String cor;

    private BigDecimal valorDiaria;

    private byte[] imagem;

    private List<Acessorio> acessorios;

    private ModeloCarro modelo;

    private List<LocalDate> datasOcupadas;
}
