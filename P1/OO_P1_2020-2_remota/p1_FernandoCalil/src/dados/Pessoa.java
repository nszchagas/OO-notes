package dados;

public class Pessoa {
	private StringBuilder nome;
	private Character genero;
	private Integer identificacao;
	
	
	// Metodo construtor
	public Pessoa(StringBuilder nome, char genero, int identiticacao) {
		this.setNome(nome);
		this.setGenero(genero);
		this.setIdentificacao(identiticacao);
	}
	
	
	
	
	// Metodos assessores
	public void setNome(StringBuilder nome) {
		this.nome = nome;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}

	public void setIdentificacao(int identificacao) {
		this.identificacao = identificacao;
	}
	
	
	
	public StringBuilder getNome() {
		return this.nome;
	}
	
	public Character getGenero() {
		return this.genero;
	}
	
	public Integer getIdentificacao() {
		return this.identificacao;
	}
	
	
	public String generoPorExtenso(char tipo) {
		if (tipo == 'F')
			return "Feminino";
		else 
			return "Masculino";
	}
}
