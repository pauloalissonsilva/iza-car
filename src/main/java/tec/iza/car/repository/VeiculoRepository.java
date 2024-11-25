package tec.iza.car.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tec.iza.car.model.veiculo.VeiculoEntity;
import tec.iza.car.model.veiculo.VeiculoProjections;

import java.util.List;
import java.util.Optional;

public interface VeiculoRepository extends JpaRepository<VeiculoEntity, Integer> {
    @Query("SELECT e.chassi AS chassi, e.placa AS placa, e.descricao AS descricao, " +
            "e.anoFabricacao AS anoFabricacao, e.categoria AS categoria, e.kmAtual AS kmAtual " +
            "FROM VeiculoEntity e")
    List<VeiculoProjections> list();


}
