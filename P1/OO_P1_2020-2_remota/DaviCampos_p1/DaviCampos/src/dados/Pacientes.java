package dados;

import java.util.ArrayList;

public class Pacientes {
	ArrayList<Pacientes> pacientes = new ArrayList<Pacientes>();
	private StringBuilder nomeCompleto;
	private Character genero;
	private Integer indentificador;
	
	public Pacientes(StringBuilder nomeCompleto, Character genero, Integer indentificador) {
		setNomeCompleto(nomeCompleto);
		setGenero(genero);
		setIndentificador(indentificador);
	}

	public Pacientes() {
	}

	public ArrayList<Pacientes> getPacientes() {
		return pacientes;
	}

	public void setPacientes(Pacientes pessoa) {
		pacientes.add(pessoa);
	}

	public StringBuilder getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(StringBuilder nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public Character getGenero() {
		return genero;
	}

	public void setGenero(Character genero) {
		this.genero = genero;
	}

	public Integer getIndentificador() {
		return indentificador;
	}

	public void setIndentificador(Integer indentificador) {
		this.indentificador = indentificador;
	}
	
}
