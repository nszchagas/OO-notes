package dados;

import java.util.ArrayList;

public class GrupoPessoa {
	private ArrayList<Pessoa> pessoas;

	public GrupoPessoa() {
		this.pessoas = new ArrayList<Pessoa>();
	}

	public ArrayList<Pessoa> getPessoas() {
		return pessoas;
	}

	public Pessoa getPessoas(int indice) {
		return pessoas.get(indice);
	}

	public void setPessoas(Pessoa pessoa) {
		this.pessoas.add(pessoa);
	}

	public boolean isPessoaCadastrada(Integer id) {
		int indice = 0;
		while (indice < pessoas.size() && !getPessoas(indice).getId().equals(id)) {
			indice++;
		}
		return indice != pessoas.size();
	}
}
