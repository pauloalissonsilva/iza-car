package tec.iza.car.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tec.iza.car.infra.business.CampoObrigatorioException;
import tec.iza.car.infra.business.RegistroNaoLocalizadoException;
import tec.iza.car.model.veiculo.VeiculoEntity;
import tec.iza.car.model.veiculo.VeiculoRequest;
import tec.iza.car.model.veiculo.VeiculoEntity;
import tec.iza.car.model.veiculo.VeiculoResponse;
import tec.iza.car.repository.ModeloRepository;
import tec.iza.car.repository.VeiculoRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class VeiculoService {
    @Autowired
    private VeiculoRepository repository;

    // regras ou validaçoes
    public Integer incluir(VeiculoRequest request) {

        VeiculoEntity entity = new VeiculoEntity();
        BeanUtils.copyProperties(request, entity);
        return repository.save(entity).getId();
    }



}
