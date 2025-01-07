//package tec.iza.car.webService;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import tec.iza.car.infra.http.Response;
//import tec.iza.car.infra.http.ResponseFactory;
//import tec.iza.car.model.marca.MarcaRequest;
//import tec.iza.car.model.marca.MarcaResponse;
//import tec.iza.car.service.MarcaService;
//
//@RestController
//    @RequestMapping("marcas")
//    public class MarcaResource {
//        @Autowired
//        private MarcaService service;
//
//        @PostMapping
//        public Response post(@RequestBody MarcaRequest request) {
//            return ResponseFactory.create(service.incluir(request), "Marca criada com sucesso!");
//        }
//
//    @PutMapping("/{id}")
//    public Response put(@PathVariable("id") Integer id, @RequestBody MarcaRequest request) {
//        return ResponseFactory.ok(service.alterar(id, request));
//    }
//
//        @GetMapping
//        public Response getList() {
//            // Lógica para o endpoint
//            return ResponseFactory.ok( service.listar());
//        }
//
//        @GetMapping(value = "/{id}")
//        public Response getItem(@PathVariable ("id") Integer id) {
//            MarcaResponse response = service.buscar(id);
//            return ResponseFactory.ok(response);
//        }
//
//    @DeleteMapping("/{id}")
//    public Response delete(@PathVariable("id") Integer id) {
//        service.excluir(id);
//        return ResponseFactory.ok("Marca excluído com sucesso!");
//    }
//    }
//
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
        return ResponseFactory.ok(service.alterar(id, request), "Marca atualizada com sucesso!");
    }


    @GetMapping
    public Response getList() {
        return ResponseFactory.ok(service.listar(), "Lista de marcas recuperada com sucesso!");
    }

    @GetMapping(value = "/{id}")
    public Response getItem(@PathVariable("id") Integer id) {
        MarcaResponse response = service.buscar(id);
        return ResponseFactory.ok(response, "Marca localizada com sucesso!");
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable("id") Integer id) {
        service.excluir(id);
        return ResponseFactory.ok("Marca excluída com sucesso!");
    }
}
