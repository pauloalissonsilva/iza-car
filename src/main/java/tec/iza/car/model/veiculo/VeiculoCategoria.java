package tec.iza.car.model.veiculo;

public enum VeiculoCategoria {
    A("Super premiun", 250.0),
    B("Top", 200.0),
    C("Populares", 150.0),
    D("Economicos", 100.0);

    private String descricao;
    private Double valorDiaria;

    private VeiculoCategoria(String descricao, Double valorDiaria) {
        this.descricao = descricao;
        this.valorDiaria = valorDiaria;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getValorDiaria() {
        return valorDiaria;
    }
}
