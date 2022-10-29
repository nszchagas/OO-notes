package dados;

public class Homem extends Pessoa {
	private Integer idade;

	public Homem(Integer id, StringBuilder nomeCompleto, Integer idade, Character situacaoSaude) {
		super(id, nomeCompleto, situacaoSaude);
		this.setIdade(idade);
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	@Override
	public String toString() {
		return super.toString() + String.format("%-10s", getIdade());
	}
}
