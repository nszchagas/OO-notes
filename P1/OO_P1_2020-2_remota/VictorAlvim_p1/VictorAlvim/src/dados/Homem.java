package dados;

public class Homem extends Pessoa {
	private Integer idade;

	public Homem(Integer identificador, String nome, Character situacaoSaude, Integer idade) {
		super(identificador, nome, situacaoSaude);
		setIdade(idade);
	}

	private void setIdade(int idade) {
		this.idade = idade;
	}

	public Integer getIdade() {
		return this.idade;
	}

	public String toString() {
		return String.format("%-15s%-40s%-28s%-15s%-20s", this.getIdentificador(), this.getNome(),
				this.getSituacaoSaudePorExtenso(), this.getIdade(), "");
	}

}
