package dados;

import java.util.Vector;

public class GrupoDePessoas {

	Vector<Pessoa> grupoDePessoas;

	public GrupoDePessoas() {
		grupoDePessoas = new Vector<Pessoa>();
	}

	public void setPessoa(Pessoa pessoa) {
		this.grupoDePessoas.add(pessoa);
	}

	public Vector<Pessoa> getPessoas() {
		return this.grupoDePessoas;
	}

}
