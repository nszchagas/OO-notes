package dados;

import java.util.ArrayList;

public class Populacao {
	private ArrayList<Pessoa> populacao;
	private ArrayList<Feminino> grupoFeminino;
	private ArrayList<Masculino> grupoMasculino;

	public Populacao() {
		this.populacao = new ArrayList<Pessoa>();
		this.grupoFeminino = new ArrayList<Feminino>();
		this.grupoMasculino = new ArrayList<Masculino>();
	}

	//Getters
	public ArrayList<Pessoa> getPopulacao() {
		return populacao;
	}

	public ArrayList<Feminino> getGrupoFeminino() {
		return grupoFeminino;
	}
	
	public ArrayList<Masculino> getGrupoMasculino() {
		return grupoMasculino;
	}

	//Setters
	public void setPopulacao(Pessoa populacao) {
		this.populacao.add(populacao);
	}

	public void setGrupoFeminino(Feminino feminino) {
		this.grupoFeminino.add(feminino);
	}

	public void setGrupoMasculino(Masculino masculino) {
		this.grupoMasculino.add(masculino);
	}
}
