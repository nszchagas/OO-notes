package dados;

public class Contaminada extends Pessoa {
	private Character situacao;

	public Contaminada(StringBuilder nome, char genero, int identificador, char situacao) {
		super(nome, genero, identificador);
		setSituacao(situacao);
	}

	public Character getSituacao() {
		return situacao;
	}

	public void setSituacao(Character situacao) {
		this.situacao = situacao;
	}

}
