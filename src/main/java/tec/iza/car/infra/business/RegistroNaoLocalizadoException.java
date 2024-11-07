package tec.iza.car.infra.business;

public class RegistroNaoLocalizadoException extends BusinessException{
    public RegistroNaoLocalizadoException() {
        super("2", "Registro Nao localizado", "Insira um registro previamente");
    }
}
