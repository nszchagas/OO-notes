package dados;

public class Pessoa {

	private StringBuilder nome;

	public Pessoa(StringBuilder nome) {
		this.setNome(nome);
	}

	public void setNome(StringBuilder nome) {
		this.nome = nome;
	}

	public StringBuilder getNome() {
		return this.nome;
	}
}
