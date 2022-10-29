package dados;

import java.util.ArrayList;

public class Cadastro {
	private ArrayList<Pessoa> cadastros;
	
	
	// Metodo construtor
	public Cadastro() {
		this.cadastros = new ArrayList<Pessoa>();
	}

	
	
	// Metodods assessores
	public ArrayList<Pessoa> getCadastros() {
		return this.cadastros;
	}
	
	
	public Pessoa getCadastro(int posicao) {
		return this.cadastros.get(posicao);
	}
	
	
	public void setPessoa(Pessoa pessoa) {
		this.cadastros.add(pessoa);
	}
}
