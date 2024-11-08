package tec.iza.car.webService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tec.iza.car.infra.http.Response;
import tec.iza.car.infra.http.ResponseFactory;
import tec.iza.car.model.modelo.ModeloRequest;
import tec.iza.car.model.modelo.ModeloResponse;
import tec.iza.car.service.ModeloService;

@RestController
@RequestMapping("modelos")
public class ModeloResource {
    @Autowired
    private ModeloService service;  // Corrigido para ModeloService

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

    @GetMapping("/marcas/{marcaId}")
    public Response getListByMarca(@PathVariable("marcaId") Integer marcaId) {
        return ResponseFactory.ok(service.listar(marcaId));
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
