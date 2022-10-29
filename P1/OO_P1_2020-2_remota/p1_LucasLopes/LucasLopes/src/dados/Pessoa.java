package dados;

public class Pessoa {
	private StringBuilder nome; 
	private String genero;
	private Integer codigo;
	
	public Pessoa(String nome, String genero, Integer codigo) {
		this.nome = new StringBuilder(nome);
		this.genero = genero;
		this.codigo = codigo;
	}
	
	public String getNome() {
		return this.nome.toString();
	}
	
	public String getGenero() {
		return this.genero;
	}
	
	public Integer getCodigo() {
		return this.codigo;
	}

}
