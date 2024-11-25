package tec.iza.car.model.veiculo;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import tec.iza.car.model.marca.MarcaEntity;

@Entity
@Table(name = "tab_veiculo")
@Data
public class VeiculoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer id;

    @Column(length = 32, nullable = false)
    private String chassi;

    @Column(length = 10, nullable = false)
    private String placa;

    @Column(length = 50, nullable = false)
    private String descricao;

    @Column(name = "ano_fabricacao", length = 8, nullable = false)
    private String anoFabricacao;

    @Enumerated(EnumType.STRING)
    @Column(length = 1, nullable = false)
    private VeiculoCategoria categoria;

    @Column(nullable = false)
    private Integer kmAtual;


    @Column(name = "modelo_id", nullable = false)
    private Integer modelo;

    @Column(name = "marca_id", nullable = false)
    private Integer marca;


}
