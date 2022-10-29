package dados;

import java.util.ArrayList;

public class GrupoExaminado {
	private ArrayList<Pessoa> grupo;

	public GrupoExaminado() {
		grupo = new ArrayList<Pessoa>();
	}

	public void setGrupo(Pessoa pessoa) {
		this.grupo.add(pessoa);
	}

	public ArrayList<Pessoa> getPessoas() {
		return grupo;
	}
}
