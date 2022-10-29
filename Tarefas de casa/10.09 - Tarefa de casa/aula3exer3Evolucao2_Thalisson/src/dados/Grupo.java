package dados;

public class Grupo {
	private Pessoa[] pessoas;

	public Grupo(int length) {
		pessoas = new Pessoa[length];
	}

	public void guardaPessoaNoGrupo(Pessoa pessoaRecebida, int posicao) {
		pessoas[posicao] = pessoaRecebida;
	}

	public Pessoa[] getGrupo() {
		return this.pessoas;
	}

}
