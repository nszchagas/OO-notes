package dados;

import java.util.ArrayList;

public class Grupo {
	private ArrayList<Pessoa> grupoSaudavel;
	private ArrayList<PessoaContaminada> grupoContaminado;

	public Grupo() {
		this.grupoSaudavel = new ArrayList<Pessoa>();
		this.grupoContaminado = new ArrayList<PessoaContaminada>();
	}

	public int getTamanhoGrupo() {
		return (this.getGrupoSaudavel().size() + this.getGrupoContaminado().size());
	}

	public int getTamangoGrupoContaminado() {
		return this.getGrupoContaminado().size();
	}

	public int getTamangoGrupoSaudavel() {
		return this.getGrupoSaudavel().size();
	}

	public ArrayList<Pessoa> getGrupoSaudavel() {
		return grupoSaudavel;
	}

	public void setPessoaSaudavel(Pessoa pessoa) {
		this.grupoSaudavel.add(pessoa);
	}

	public ArrayList<PessoaContaminada> getGrupoContaminado() {
		return grupoContaminado;
	}

	public void setPessoaContaminada(PessoaContaminada pessoa) {
		this.grupoContaminado.add(pessoa);
	}

}
