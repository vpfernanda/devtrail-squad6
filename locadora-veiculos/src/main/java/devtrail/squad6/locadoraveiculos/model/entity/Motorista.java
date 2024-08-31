package devtrail.squad6.locadoraveiculos.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
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
