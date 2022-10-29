package dados;

import java.util.ArrayList;

public class Grupo {
	private ArrayList<Pessoa> grupo;

	public Grupo() {
		grupo = new ArrayList<Pessoa>();
	}

	public ArrayList<Pessoa> getGrupo() {
		return grupo;
	}

	public void setPessoa(Pessoa pessoa) {
		this.grupo.add(pessoa);
	}

}
