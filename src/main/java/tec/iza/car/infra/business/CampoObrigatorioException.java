package tec.iza.car.infra.business;

public class CampoObrigatorioException extends BusinessException{
    public CampoObrigatorioException() {
        super("1", "Campo obrigatorio", "Preencha os dados devidamente");
    }
}
