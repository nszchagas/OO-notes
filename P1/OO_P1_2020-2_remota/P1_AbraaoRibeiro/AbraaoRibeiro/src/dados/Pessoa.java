package dados;


public class Pessoa {
	final int MINIMO = 1;
	private StringBuilder nome;
	private Character genero;
	private Integer identificador;
	
	public Pessoa(StringBuilder nome, Character genero, Integer identificador) {
		setNome(nome);
		setGenero(genero);
		setIdentificador(identificador);
	}
	public void setNome(StringBuilder nome) {
		this.nome.append(nome);
	}
	public void setGenero(Character genero) {
		this.genero = genero;
	}
	public void setIdentificador(Integer identificador) {
		this.identificador = identificador;
	}
	public StringBuilder getNome() {
		return nome;
	}
	public Integer getIdentificador() {
		return identificador;
	}
	public String getGenero() {
		if (genero == 'M')
			return "Masculino";
		return "Feminino";
	}
}
