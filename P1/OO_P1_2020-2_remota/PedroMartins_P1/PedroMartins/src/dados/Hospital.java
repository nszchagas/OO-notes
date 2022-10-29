package dados;

import java.util.ArrayList;

public class Hospital {
	// Declaracoes

	private ArrayList<Pessoa> listaPessoa;

	public ArrayList<Pessoa> getPessoa() {
		return listaPessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.listaPessoa.add(pessoa);
	}

//	public static void cadastraPessoa()
}
