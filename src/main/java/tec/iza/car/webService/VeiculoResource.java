package tec.iza.car.webService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tec.iza.car.infra.http.Response;
import tec.iza.car.infra.http.ResponseFactory;
import tec.iza.car.model.modelo.ModeloRequest;
import tec.iza.car.model.modelo.ModeloResponse;
import tec.iza.car.model.veiculo.VeiculoProjections;
import tec.iza.car.model.veiculo.VeiculoRequest;
import tec.iza.car.repository.VeiculoRepository;
import tec.iza.car.service.ModeloService;
import tec.iza.car.service.VeiculoService;

import java.util.List;

@RestController
@RequestMapping("veiculos")
public class VeiculoResource {

    @Autowired
    private ModeloService service;

    @PostMapping
    public Response post(@RequestBody ModeloRequest request) {
        return ResponseFactory.create(service.incluir(request), "Modelo criado com sucesso!");
    }

    @PutMapping("/{id}")
    public Response put(@PathVariable("id") Integer id, @RequestBody ModeloRequest request) {
        return ResponseFactory.ok(service.alterar(id, request));
    }

    @GetMapping
    public Response getList() {
        return ResponseFactory.ok(service.listar());
    }


    @GetMapping(value = "/{id}")
    public Response getItem(@PathVariable("id") Integer id) {
        ModeloResponse response = service.buscar(id);
        return ResponseFactory.ok(response);
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable("id") Integer id) {
        service.excluir(id);
        return ResponseFactory.ok("Modelo excluído com sucesso!");
    }

}

