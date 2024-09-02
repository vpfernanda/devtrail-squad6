package devtrail.squad6.locadoraveiculos.model.entity;

import devtrail.squad6.locadoraveiculos.model.dto.AluguelDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarrinhoCompra implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name="motorista_id")
    private Motorista motorista;

    @ElementCollection
    @CollectionTable(name = "carrinho_compra_aluguel", joinColumns = @JoinColumn(name = "carrinho_id"))
    private List<AluguelDTO> listaAlugueis = new ArrayList<>();
}
