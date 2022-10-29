package dados;

import java.util.Vector;

public class Grupo {
	private Vector<Pessoa> grupoNomes;
	
	public Grupo() {
		this.grupoNomes = new Vector<Pessoa>();
	}
	
	public Vector<Pessoa> getNomes() {
		return grupoNomes;
	}
	
	public void setGrupoNomes(Pessoa pessoa) {
		this.grupoNomes.add(pessoa);
	}
}
