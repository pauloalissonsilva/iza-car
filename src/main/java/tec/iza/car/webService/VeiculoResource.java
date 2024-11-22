package tec.iza.car.webService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tec.iza.car.infra.http.Response;
import tec.iza.car.infra.http.ResponseFactory;
import tec.iza.car.model.veiculo.VeiculoProjections;
import tec.iza.car.model.veiculo.VeiculoRequest;
import tec.iza.car.repository.VeiculoRepository;
import tec.iza.car.service.VeiculoService;

import java.util.List;

@RestController
@RequestMapping("veiculos")
public class VeiculoResource {
    @Autowired
    private VeiculoService service;

    @Autowired
    private VeiculoRepository repository;


    @PostMapping
    public Response post(@RequestBody VeiculoRequest request) {
        return ResponseFactory.create(service.incluir(request), "veiculo criado com sucesso!");
    }
    @GetMapping
    public List<VeiculoProjections> lisa(){
        return repository.list();
    }

//    @PutMapping("/{id}")
//    public Response put(@PathVariable("id") Integer id, @RequestBody MarcaRequest request) {
//        return ResponseFactory.ok(service.alterar(id, request));
//    }
}

