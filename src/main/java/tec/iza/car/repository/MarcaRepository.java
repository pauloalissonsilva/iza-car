package tec.iza.car.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tec.iza.car.model.marca.MarcaEntity;

public interface MarcaRepository extends JpaRepository <MarcaEntity, Integer> {
}
