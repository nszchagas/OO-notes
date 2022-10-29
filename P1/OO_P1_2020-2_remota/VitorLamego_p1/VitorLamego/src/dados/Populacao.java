package dados;

import java.util.ArrayList;

public class Populacao {
	private ArrayList<Pessoa> populacao;
	
	public Populacao() {
		populacao = new ArrayList<Pessoa>();
	}
	
	public ArrayList<Pessoa> getPopulacao(){
		return populacao;
	}
	
	public Pessoa getPessoa(int index) {
		return populacao.get(index);
	}
	
	public void setPopulacao(Pessoa pessoa) {
		populacao.add(pessoa);
	}
}
