package dados;

public class Masculino extends Pessoa {
	private Integer idade;

	public Masculino(String codigoPessoa, StringBuilder nome, Character situacaoSaude, Integer idade) {
		super(codigoPessoa, nome, situacaoSaude);
		setIdade(idade);
	}

	//Getters
	public Integer getIdade() {
		return idade;
	}

	//Setters
	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	//Metodo toString
	public String toString() {
		return String.format("%-30s%-30s%-35s%-30s%-20%", getCodigoPessoa(), getNome(), getSituacaoSaude(),
				getIdade(), "#");
	}

	public int homensSemContaminacao() {
		int contador = 0;
		if (getSituacaoSaude() == 'S')
			contador++;
		return contador;
	}
}
