package dados;

public class Pessoa {
	private StringBuilder nome;
	private Character genero;
	private Integer identificador;

	public Pessoa(StringBuilder nome, char genero, int identificador) {
		setNome(nome);
		setGenero(genero);
		setIdentificador(identificador);
	}

	public StringBuilder getNome() {
		return nome;
	}

	public Character getGenero() {
		return genero;
	}

	public Integer getIdentificador() {
		return identificador;
	}

	public void setNome(StringBuilder nome) {
		this.nome = nome;
	}

	public void setGenero(Character genero) {
		this.genero = genero;
	}

	public void setIdentificador(Integer identificador) {
		this.identificador = identificador;
	}

}
