package devtrail.squad6.locadoraveiculos.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "fabricantes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fabricante  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_fabricante", nullable = false,length = 100)
    private String nome;

    @OneToMany(mappedBy = "fabricante", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ModeloCarro> modelosCarro = new HashSet<>();

}
