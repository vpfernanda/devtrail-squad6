package devtrail.squad6.locadoraveiculos.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_role")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class User extends Pessoa {
    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;
}
