package tec.iza.car.start;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import tec.iza.car.model.MarcaEntity;
import tec.iza.car.repository.MarcaRepository;

@Component
public class StartApp implements ApplicationRunner {
    @Autowired
    private MarcaRepository repository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        MarcaEntity marca = new MarcaEntity();
        marca.setNome("golf");

        repository.save(marca);
        System.out.println(marca.getId() + " - " + marca.getNome());

        marca = new MarcaEntity();
        marca.setNome("toyota");

        repository.save(marca);
        System.out.println(marca.getId() + " - " + marca.getNome());


//        MarcaEntity marca2 = new MarcaEntity();
//        marca2.setNome("Fiat");
//        repository.save(marca2);
//        System.out.println(marca2.getId() + " - " + marca2.getNome());

    }
}
