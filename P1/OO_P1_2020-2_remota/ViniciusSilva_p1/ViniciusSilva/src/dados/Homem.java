package dados;

public class Homem extends Pessoa{
    private Integer idade;

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return String.format("%15s %25s %30s %10s %10s", getNumero(), getNome(), nomeToExtenso(getSituacaoSaude()), getIdade(), "-");
    }


}
