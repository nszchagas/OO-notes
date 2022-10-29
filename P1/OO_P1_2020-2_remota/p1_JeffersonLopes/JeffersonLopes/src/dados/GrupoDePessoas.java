package dados;

import java.util.ArrayList;

public class GrupoDePessoas {
	private ArrayList<Pessoa> pessoas;

	public GrupoDePessoas() {
		this.pessoas = new ArrayList<Pessoa>();
	}

	public ArrayList<Pessoa> getPessoas() {
		return pessoas;
	}

	public void addPessoa(Pessoa pessoa) {
		this.pessoas.add(pessoa);
	}

	public boolean verificaDisponibilidadeIdentificador(int identificador) {
		for (Pessoa pessoas : getPessoas()) {
			if (pessoas.getIdentificador().equals(identificador)) {
				return false;
			}
		}
		return true;
	}

}