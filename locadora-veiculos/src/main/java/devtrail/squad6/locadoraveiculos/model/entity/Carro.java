package devtrail.squad6.locadoraveiculos.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "carro")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Carro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "placa", nullable = false, length = 7, unique = true)
    private String placa;
    @Column(name = "chassi", nullable = false, length = 17, unique = true )
    private String chassi;
    @Column(name = "cor", nullable = false, length =100 )
    private String cor;
    @Column(name = "", nullable = false)
    private BigDecimal valorDiaria;

    @ManyToMany
    @JoinTable(
            name = "carro_acessorio",
            joinColumns = @JoinColumn(name = "carro_id"),
            inverseJoinColumns = @JoinColumn(name = "acessorio_id")
    )
    private Set<Acessorio> acessorios;


    @ManyToOne
    @JoinColumn(name = "modelo_id", nullable = false)
    private ModeloCarro modelo;

    @OneToMany(mappedBy = "carro")
    private Set<Aluguel> alugueis;
}
