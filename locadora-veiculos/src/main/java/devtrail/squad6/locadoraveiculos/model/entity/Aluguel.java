package devtrail.squad6.locadoraveiculos.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
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

    @Column(name = "datapedido", nullable = false)
    private Calendar dataPedido;

    @Column(name = "dataentrega", nullable = false)
    private Date dataEntrega;

    @Column(name = "datadevolucao", nullable = false)
    private Date dataDevolucao;

    @Column(name = "valortotal", nullable = false)
    private BigDecimal valorTotal;

}
