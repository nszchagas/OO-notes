package dados;

public class Pessoa {

	private String nome;
	private Character genero;
	private Integer identificador;
	
	public Pessoa(String nome, Character genero, Integer identificador) {
		this.nome = nome;
		this.genero = genero;
		this.identificador = identificador;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Character getGenero() {
		return genero;
	}
	public void setGenero(Character genero) {
		this.genero = genero;
	}
	public Integer getIdentificador() {
		return identificador;
	}
	public void setIdentificador(Integer identificador) {
		this.identificador = identificador;
	}
	
}
