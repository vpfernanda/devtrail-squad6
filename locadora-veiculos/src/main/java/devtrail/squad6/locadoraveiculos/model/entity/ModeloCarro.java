package devtrail.squad6.locadoraveiculos.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ModeloCarro  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String descricao;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @OneToMany
    private Fabricante fabricante;

    public ModeloCarro(String descricao, Categoria categoria, Fabricante fabricante) {
        this.descricao = descricao;
        this.categoria = categoria;
        this.fabricante = fabricante;
    }
}
