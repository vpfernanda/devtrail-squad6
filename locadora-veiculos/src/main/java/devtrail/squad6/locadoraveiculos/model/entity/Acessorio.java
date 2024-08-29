package devtrail.squad6.locadoraveiculos.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter

@Entity
@Table(name = "acessorio")
public class Acessorio {

    public Acessorio(String descricao) {
        this.descricao = descricao;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)
    private String descricao;

    @ManyToMany(mappedBy = "acessorios")
    private Set<Carro> carros;
}
