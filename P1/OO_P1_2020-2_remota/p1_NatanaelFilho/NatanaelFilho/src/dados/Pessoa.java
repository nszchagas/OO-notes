package dados;

public class Pessoa {
	private String nome;
	private Character sexo;
	private Integer indentificador;
	private Integer idade;

	public Pessoa(String nome, Character sexo, Integer indentificador, Integer idade) {
		this.nome = nome;
		this.sexo = sexo;
		this.indentificador = indentificador;
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Character getSexo() {
		return sexo;
	}

	public void setSexo(Character sexo) {
		this.sexo = sexo;
	}

	public Integer getIndentificador() {
		return indentificador;
	}

	public void setIndentificador(Integer indentificador) {
		this.indentificador = indentificador;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	// indentificador | idade | sexo | nome | situacao
	public String toString() {
		return getIndentificador() + " | " + getIdade() + " | " + getSexo() + " | " + getNome() + " | Nao Contaminado";
	}

}
