package dados;

public class Pessoas {

	private StringBuilder nome;
	private Character genero;
	private Integer id;
	
	public Pessoas(StringBuilder nome, char genero, int id) {
		this.nome = nome;
		this.genero = genero;
		this.id = id;
	}

	public StringBuilder getNome() {
		return nome;
	}

	public Character getGenero() {
		return genero;
	}

	public Integer getId() {
		return id;
	}

	
	
	
}
