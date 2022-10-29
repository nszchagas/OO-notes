package principal;

import java.util.ArrayList;

public class GrupoTodasPessoas {
	private ArrayList<Pessoa> grupoTodasPessoas;
	
	public GrupoTodasPessoas() {
		grupoTodasPessoas = new ArrayList<Pessoa>(); 
	}
	
	public ArrayList<Pessoa> getGrupoTodasPessoas(){
		return grupoTodasPessoas;
	}
	
	public void setGrupoTodasPessoas(Pessoa pessoa) {
		this.grupoTodasPessoas.add(pessoa);
	}
}
