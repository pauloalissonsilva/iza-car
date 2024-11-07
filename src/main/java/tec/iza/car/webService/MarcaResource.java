package tec.iza.car.webService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tec.iza.car.infra.http.Response;
import tec.iza.car.infra.http.ResponseFactory;
import tec.iza.car.model.marca.MarcaRequest;
import tec.iza.car.model.marca.MarcaResponse;
import tec.iza.car.service.MarcaService;

@RestController
    @RequestMapping("marcas")
    public class MarcaResource {
        @Autowired
        private MarcaService service;

        @PostMapping
        public Response post(@RequestBody MarcaRequest request) {
            return ResponseFactory.create(service.incluir(request), "Marca criada com sucesso!");
        }

    @PutMapping("/{id}")
    public Response put(@PathVariable("id") Integer id, @RequestBody MarcaRequest request) {
        return ResponseFactory.ok(service.alterar(id, request));
    }

        @GetMapping
        public Response getList() {
            // Lógica para o endpoint
            return ResponseFactory.ok( service.listar());
        }

        @GetMapping(value = "/{id}")
        public Response getItem(@PathVariable ("id") Integer id) {
            MarcaResponse response = service.buscar(id);
            return ResponseFactory.ok(response);
        }

        @DeleteMapping
        public void delete() {
            // Lógica para o endpoint
        }
    }

