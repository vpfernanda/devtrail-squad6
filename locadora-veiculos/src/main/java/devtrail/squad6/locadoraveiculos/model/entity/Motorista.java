package devtrail.squad6.locadoraveiculos.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "motorista")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Motorista extends Pessoa implements Serializable {
    @Column(name = "numeroCNH", unique = true)
    private String numeroCNH;

    @OneToMany(mappedBy = "motorista")
    private Set<Aluguel> alugueis = new HashSet<>();

}
