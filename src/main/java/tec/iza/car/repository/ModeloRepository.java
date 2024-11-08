package tec.iza.car.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tec.iza.car.model.marca.MarcaEntity;
import tec.iza.car.model.modelo.ModeloEntity;

import java.util.List;

public interface ModeloRepository extends JpaRepository <ModeloEntity, Integer> {
    List<ModeloEntity> findByMarca(Integer marca);
}
