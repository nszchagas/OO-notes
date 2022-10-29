package principal;

public class Grupo {

	private Pessoa[] pessoas;

	public Grupo(final int TAMANHO) {
		this.pessoas = new Pessoa[TAMANHO]; // cria um array de pessoas com tamanho definido pela constante
	}

	public void setPosicaoPessoa(int numeroDaPessoa, Pessoa pessoa) {
		pessoas[numeroDaPessoa] = pessoa; // aloca na posicao passada por parametro a pessoa escolhida

	}

	public Pessoa getPessoaNaPosicao(int posicao) {
		return pessoas[posicao]; 
	}

	public int getTamanhoGrupo() {
		return pessoas.length;
	}
	

}
