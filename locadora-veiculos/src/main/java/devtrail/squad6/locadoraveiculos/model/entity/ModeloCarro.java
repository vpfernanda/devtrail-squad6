package devtrail.squad6.locadoraveiculos.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "modelo_carro")
public class ModeloCarro implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descricao", length = 100, nullable = false)
    private String descricao;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "fabricante_id")
    private Fabricante fabricante;
}
