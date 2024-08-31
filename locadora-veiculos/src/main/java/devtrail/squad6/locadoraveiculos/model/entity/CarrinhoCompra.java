package devtrail.squad6.locadoraveiculos.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
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

    @ManyToMany
    @JoinTable(
            name = "carrinho_compra_carro",
            joinColumns = @JoinColumn(name = "carrinho_id"),
            inverseJoinColumns =  @JoinColumn(name = "carro_id")
    )
    private List<Carro> carros;
}
