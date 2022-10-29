package dados;

import servicos.Servicos;

public class Passageiro {

	private StringBuilder nomeCompleto;
	private StringBuilder nomeConcatenado;

	public void setNome(StringBuilder nome) {
		this.nomeCompleto = nome;
	}

	public StringBuilder getNome() {
		return this.nomeCompleto;
	}

	public Passageiro(StringBuilder nome) {
		this.setNome(nome);
		this.nomeConcatenado = Servicos.concatenaNomes(Servicos.separaNomes(nome));
	}

	public StringBuilder getNomeConcatenado() {
		return this.nomeConcatenado;
	}

}
