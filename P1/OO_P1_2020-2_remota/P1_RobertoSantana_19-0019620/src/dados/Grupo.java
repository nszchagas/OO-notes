package dados;

import java.util.ArrayList;

public class Grupo {
	ArrayList<Pessoa> grupo;

	public Grupo() {
		this.grupo = new ArrayList<Pessoa>();
	}
	
	public void addPessoa(Pessoa pessoa) {
		this.grupo.add(pessoa);
	}
	
	public ArrayList<Pessoa> getGrupo(){
		return this.grupo;
	}
}	
