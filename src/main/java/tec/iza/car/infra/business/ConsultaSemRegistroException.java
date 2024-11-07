package tec.iza.car.infra.business;

public class ConsultaSemRegistroException extends BusinessException{
    public ConsultaSemRegistroException() {
        super("3", "Consulta sem registro", "Preencha os dados devidamente");
    }
}
