package dados;

public class Grupo {

	private Pessoa[] grupo;

	public Grupo(int tamanho) {
		grupo = new Pessoa[tamanho];
	}

	public Pessoa[] getGrupo() {
		return grupo;
	}

	public void setPessoaNoGrupo(Pessoa pessoa, int posicao) {

		this.grupo[posicao] = pessoa;
	}

	public void setGrupo(Pessoa[] grupoNovo) {
		this.grupo = grupoNovo;
	}

}
