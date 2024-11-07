package tec.iza.car.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tec.iza.car.infra.business.CampoObrigatorioException;
import tec.iza.car.infra.business.RegistroNaoLocalizadoException;
import tec.iza.car.model.marca.MarcaEntity;
import tec.iza.car.model.marca.MarcaRequest;
import tec.iza.car.model.marca.MarcaResponse;
import tec.iza.car.repository.MarcaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// Regras de negócio
@Service
public class MarcaService {
    @Autowired
    private MarcaRepository repository;

    public Integer incluir(MarcaRequest entity) {
        return gravar(null, entity);
    }
    public Integer alterar(Integer id, MarcaRequest request) {
        return gravar(id, request);
    }


// Excessoes -> disparadas / interceptadas pelo spring -> resposta
    private Integer gravar(Integer id, MarcaRequest request) {
        if (request.getNome() == null || request.getNome().isBlank())
            throw new CampoObrigatorioException();

//
//

//        // protegendo nossa entidade forma 1 verbosa
//        MarcaEntity entity = null;
//        if (id !=null)
//            entity = buscarEntity(id);
//        else
//            entity = new MarcaEntity();
        MarcaEntity entity = Optional.ofNullable(id).isPresent() ? buscarEntity(id)
                : new MarcaEntity();

        BeanUtils.copyProperties(request, entity);

        return repository.save(entity).getId();
    }

//

    // Método para buscar uma marca pelo ID
    private MarcaEntity buscarEntity(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RegistroNaoLocalizadoException());
    }

    public MarcaResponse buscar(Integer id) {
        return converter(buscarEntity(id));
    }
    public void excluir(Integer id){
        repository.deleteById(id);
    }
    public List<MarcaResponse> listar() {
               List<MarcaResponse> response = repository.findAll() .stream()
                .map(this::converter)
                .collect(Collectors.toList());
        return response;
    }
    private MarcaResponse converter(MarcaEntity entity){
        MarcaResponse response = new MarcaResponse();
//            match
//        response.setId(entity.getId());
//        response.setNome(entity.getNome());

        BeanUtils.copyProperties(entity, response);
                return response;
    }
}
