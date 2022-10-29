package principal;

public class Pessoa {
	private String nome;
	private Character genero;
	private Integer identificador;
	
	public Pessoa(String nome, Character genero, Integer identificador) {
		setNome(nome);
		setGenero(genero);
		setIdentificador(identificador);
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setGenero(Character genero) {
		this.genero = genero;
	}
	
	public void setIdentificador(Integer identificador) {
		this.identificador = identificador;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Character getGenero() {
		return genero;
	}
	
	public Integer getIdentificador() {
		return identificador;
	}
}
