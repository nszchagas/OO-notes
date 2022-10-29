package dados;

import java.util.Vector;

public class Grupo {
	private Vector<Pessoa> nomes;
	
	public Grupo() {
		this.nomes = new Vector<>();
	}
	
	public Vector<Pessoa> getNomes() {
		return nomes;
	}
	
	public void setNomes(Pessoa pessoa) {
		this.nomes.add(pessoa);
	}
}
