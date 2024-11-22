package tec.iza.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import tec.iza.car.model.veiculo.VeiculoCategoria;
import tec.iza.car.model.veiculo.VeiculoEntity;
import tec.iza.car.model.veiculo.VeiculoProjections;
import tec.iza.car.model.veiculo.VeiculoRequest;
import tec.iza.car.repository.VeiculoRepository;
import tec.iza.car.service.VeiculoService;

import java.util.List;


@Component
public class StartApp implements ApplicationRunner {

    @Autowired
    private VeiculoService service;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        VeiculoRequest novoVeiculo = new VeiculoRequest();
        novoVeiculo.setAnoFabricacao("2024");
        novoVeiculo.setCategoria(VeiculoCategoria.A);
        novoVeiculo.setChassi(",56ef-9919ds");
        novoVeiculo.setMarca(1);
        novoVeiculo.setModelo(1);
        novoVeiculo.setPlaca("53w52f2");
        novoVeiculo.setDescricao("Cronos 1.4");
        novoVeiculo.setKmAtual(10);

        service.incluir(novoVeiculo);
    }
}
