package dados;

public class NaoContaminada extends Pessoa {
	private Integer idade;

	public NaoContaminada(StringBuilder nome, char genero, int identificador, int idade) {
		super(nome, genero, identificador);
		setIdade(idade);
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

}
