package tec.iza.car.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

// Java beans
// Lombok
@Entity
@Table(name = "tab_marca")
@Getter
@Setter
public class MarcaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer id;
    @Column(nullable = false, length = 30)
    private  String nome;

}
