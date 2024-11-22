package tec.iza.car.service;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tec.iza.car.model.veiculo.VeiculoEntity;
import tec.iza.car.model.veiculo.VeiculoRequest;
import tec.iza.car.repository.VeiculoRepository;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository repository;

    public Integer incluir(VeiculoRequest request) {

        // Regras ou validaçoes
        VeiculoEntity entity = new VeiculoEntity();
        BeanUtils.copyProperties(request, entity);

        return repository.save(entity).getId();
    }
}
