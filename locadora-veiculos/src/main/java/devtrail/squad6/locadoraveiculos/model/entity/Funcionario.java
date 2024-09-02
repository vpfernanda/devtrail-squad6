package devtrail.squad6.locadoraveiculos.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Funcionario extends Pessoa implements Serializable {
    @Column(name = "matricula", unique = true)
    private String matricula;
}
