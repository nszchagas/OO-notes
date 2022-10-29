package dados;

public class PessoaContaminada extends Pessoa {

	private Character situacao;

	public PessoaContaminada(String nome, Character sexo, Integer indentificador, Integer idade, Character situacao) {
		super(nome, sexo, indentificador, idade);
		this.setSituacao(situacao);
	}

	public char estaContaminada() {
		return situacao;
	}

	public Character getSituacao() {
		return situacao;
	}

	public void setSituacao(Character situacao) {
		this.situacao = situacao;
	}

	public String toString() {
			return getIndentificador() + " | " + getIdade() + " | " + getSexo() + " | " + getNome();
	}

}
