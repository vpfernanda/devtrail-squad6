package devtrail.squad6.locadoraveiculos.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "aluguel")
public class Aluguel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "motorista_id", nullable = false)
    private Motorista motorista;

    @ManyToOne(optional = false)
    @JoinColumn(name = "carro_id", nullable = false)
    private Carro carro;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "apolice_seguro_id")
    private ApoliceSeguro apoliceSeguro;

    @Column(name = "datapedido", nullable = false)
    private LocalDate dataPedido;

    @Column(name = "dataentrega", nullable = false)
    private LocalDate dataEntrega;

    @Column(name = "datadevolucao", nullable = false)
    private LocalDate dataDevolucao;

    @Column(name = "valortotal", nullable = false)
    private BigDecimal valorTotal;


}
