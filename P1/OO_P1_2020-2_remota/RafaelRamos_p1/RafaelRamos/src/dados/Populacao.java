package dados;

import java.util.ArrayList;

public class Populacao {
	
	private ArrayList<Pessoa> populacao;
	
	public Populacao() {
		this.populacao = new ArrayList<Pessoa>();
	}

	public ArrayList<Pessoa> getPopulacao() {
		return populacao;
	}

	public void setPessoa (Pessoa pessoa) {
		this.populacao.add(pessoa);
	}
}
