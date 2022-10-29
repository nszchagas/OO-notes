package dados;

import java.util.ArrayList;

public class Cadastros {
	private ArrayList<Pessoa> cadastros;
	
	public Cadastros() {
		this.cadastros = new ArrayList<Pessoa>();
	}
	
	public void setCadastros(Pessoa pessoa) {
		this.cadastros.add(pessoa);
	}
	
	public ArrayList<Pessoa> getCadastros(){
		return this.cadastros;
	}
}
