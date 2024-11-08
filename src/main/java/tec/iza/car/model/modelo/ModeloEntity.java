package tec.iza.car.model.modelo;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import tec.iza.car.model.marca.MarcaEntity;

@Entity
@Table(name = "tab_modelo")
@Getter
@Setter
public class ModeloEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer id;

    @Column(nullable = false, length = 30)
    private String nome;

    @Column(nullable = false)
    private boolean excluido = false;  // Campo para controle de exclusão lógica

    @Column(name = "marca_id")
    private Integer marca;
}
