package devtrail.squad6.locadoraveiculos.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table (name = "apolice_seguro")
public class ApoliceSeguro implements Serializable {

    public ApoliceSeguro(BigDecimal valorFranquia, boolean protecaoTerceiro, boolean protecaoCausasNaturais, boolean protecaoRoubo) {
        this.valorFranquia = valorFranquia;
        this.protecaoTerceiro = protecaoTerceiro;
        this.protecaoCausasNaturais = protecaoCausasNaturais;
        this.protecaoRoubo = protecaoRoubo;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)
    private BigDecimal valorFranquia;

    @Column (nullable = false)
    private boolean protecaoTerceiro;

    @Column (nullable = false)
    private boolean protecaoCausasNaturais;

    @Column (nullable = false)
    private boolean protecaoRoubo;

    @OneToOne
    @JoinColumn(name = "aluguel_id")
    private Aluguel aluguel;


}
