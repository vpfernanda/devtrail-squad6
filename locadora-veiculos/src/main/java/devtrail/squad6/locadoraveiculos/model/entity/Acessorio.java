package devtrail.squad6.locadoraveiculos.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "acessorio")
public class Acessorio implements Serializable {

    public Acessorio(String descricao) {
        this.descricao = descricao;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false, length = 100)
    private String descricao;

    @ManyToMany(mappedBy = "acessorios")
    private Set<Carro> carros = new HashSet<>();
}
