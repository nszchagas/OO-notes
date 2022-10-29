package dados;

public class PessoaContaminada extends Pessoas {

	private Character situacao;

	public PessoaContaminada(StringBuilder nome, char genero, int id, char situacao) {
		super(nome, genero, id);
		this.situacao = situacao;
	}

	public Character getSituacao() {
		return situacao;
	}

	
	public String toString() {
		return String.format("%-30s%-30s%-60s%-30s", getId(), getNome(), getGenero(), situacao);
	}
}
