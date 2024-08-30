package devtrail.squad6.locadoraveiculos.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "fabricantes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fabricante  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_fabricante", nullable = false)
    private String nome;

    @OneToMany(mappedBy = "fabricante", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ModeloCarro> modelosCarro;

}
