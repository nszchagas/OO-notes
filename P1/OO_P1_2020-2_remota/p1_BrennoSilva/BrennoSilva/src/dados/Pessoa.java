package dados;

public class Pessoa {
	private StringBuilder nome;
	private Character genero;
	private Integer identificacao;
	
	public Pessoa(Integer identificacao, StringBuilder nome, Character genero) {
		setIdentificacao(identificacao);
		setNome(nome);
		setGenero(genero);
	}
	public StringBuilder getNome() {
		return nome;
	}
	public void setNome(StringBuilder nome) {
		this.nome = nome;
	}
	public Character getGenero() {
		return genero;
	}
	public void setGenero(Character genero) {
		this.genero = genero;
	}
	public Integer getIdentificacao() {
		return identificacao;
	}
	public void setIdentificacao(Integer identificacao) {
		this.identificacao = identificacao;
	}
}
