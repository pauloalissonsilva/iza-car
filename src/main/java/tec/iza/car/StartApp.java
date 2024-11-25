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


    @Override
    public void run(ApplicationArguments args) throws Exception {

    }
}
