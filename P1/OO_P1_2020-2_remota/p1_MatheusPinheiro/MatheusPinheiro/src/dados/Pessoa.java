package dados;

public class Pessoa {
	private StringBuffer nome;
	private String genero;
	private Integer identificador;
	
	public Pessoa(String nome, String genero, Integer identificador) {
		setNome(nome);
		setGenero(genero);
		setIdentificador(identificador);
	}
	
	public StringBuffer getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = new StringBuffer(nome);
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public Integer getIdentificador() {
		return identificador;
	}
	public void setIdentificador(Integer identificador) {
		this.identificador = identificador;
	}
}
