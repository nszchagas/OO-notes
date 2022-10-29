package dados;

import java.util.ArrayList;

public class GrupoPessoas {
	private ArrayList<Pessoa> grupoPessoas;

	public GrupoPessoas() {
		grupoPessoas = new ArrayList<Pessoa>();
	}

	public ArrayList<Pessoa> getGrupoPessoas() {
		return grupoPessoas;
	}

	public void setGrupoPessoas(Pessoa pessoa) {
		this.grupoPessoas.add(pessoa);
	}
}
