package tec.iza.car.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tec.iza.car.infra.business.CampoObrigatorioException;
import tec.iza.car.infra.business.RegistroNaoLocalizadoException;
import tec.iza.car.model.modelo.ModeloEntity;
import tec.iza.car.model.modelo.ModeloRequest;
import tec.iza.car.model.modelo.ModeloResponse;
import tec.iza.car.repository.ModeloRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class ModeloService {
    @Autowired
    private ModeloRepository repository;

    public Integer incluir(ModeloRequest request) {
        return gravar(null, request);
    }

    public Integer alterar(Integer id, ModeloRequest request) {
        return gravar(id, request);
    }

    private Integer gravar(Integer id, ModeloRequest request) {
        if (request.getNome() == null || request.getNome().isBlank()) {
            throw new CampoObrigatorioException();
        }

        ModeloEntity entity = Optional.ofNullable(id).isPresent() ? buscarEntity(id) : new ModeloEntity();


        BeanUtils.copyProperties(request, entity);
        return repository.save(entity).getId();
    }

    private ModeloEntity buscarEntity(Integer id) {
        return repository.findById(id)
                .filter(e -> !e.isExcluido())  // Verifica se o modelo não está excluído
                .orElseThrow(() -> new RegistroNaoLocalizadoException());
    }

    public ModeloResponse buscar(Integer id) {
        return converter(buscarEntity(id));
    }

    public void excluir(Integer id) {
        ModeloEntity entity = buscarEntity(id);
        entity.setExcluido(true);  // Marca o registro como excluído
        repository.save(entity);
    }

    public List<ModeloResponse> listar() {
        return repository.findAll()
                .stream()
                .filter(modelo -> !modelo.isExcluido())  // Filtra modelos que não estão excluídos
                .map(this::converter)
                .collect(Collectors.toList());
    }

    public List<ModeloResponse> listar(Integer marca) {
        return repository.findByMarca(marca)
                .stream()
                .filter(modelo -> !modelo.isExcluido())  // Filtra modelos que não estão excluídos
                .map(this::converter)
                .collect(Collectors.toList());
    }

    private ModeloResponse converter(ModeloEntity entity) {
        ModeloResponse response = new ModeloResponse();
        BeanUtils.copyProperties(entity, response);
        return response;
    }
}
