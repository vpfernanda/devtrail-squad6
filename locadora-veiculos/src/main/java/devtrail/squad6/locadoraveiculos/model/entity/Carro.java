package devtrail.squad6.locadoraveiculos.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "carro")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Carro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "placa", nullable = false, length = 7, unique = true)
    private String placa;

    @Column(name = "chassi", nullable = false, length = 17, unique = true )
    private String chassi;

    @Column(name = "cor", nullable = false, length =100 )
    private String cor;

    @Column(name = "valor_diaria", nullable = false)
    private BigDecimal valorDiaria;

    @Lob
    private byte[] imagem;

    @ManyToMany
    @JoinTable(
            name = "carro_acessorio",
            joinColumns = @JoinColumn(name = "carro_id"),
            inverseJoinColumns = @JoinColumn(name = "acessorio_id")
    )
    private Set<Acessorio> acessorios = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "modelo_id", nullable = false)
    private ModeloCarro modelo;

    @OneToMany(mappedBy = "carro", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Aluguel> alugueis;

    @ElementCollection
    @CollectionTable(name = "carro_datas_ocupadas", joinColumns = @JoinColumn(name = "carro_id"))
    @Column(name = "data_ocupada")
    private List<LocalDate> datasOcupadas = new ArrayList<>();

    public void bloquearDatas(LocalDate dataInicio, LocalDate dataDevolucao) {
        LocalDate data = dataInicio;
        while (!data.isAfter(dataDevolucao)) {
            datasOcupadas.add(data);
            data = data.plusDays(1);
        }
    }


}
