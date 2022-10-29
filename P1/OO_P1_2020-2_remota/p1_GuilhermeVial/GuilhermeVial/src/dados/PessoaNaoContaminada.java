package dados;

public class PessoaNaoContaminada extends Pessoas {

	private Integer idade;
	
	public PessoaNaoContaminada(StringBuilder nome, char genero, int id, int idade) {
		super(nome, genero, idade);
		this.idade = idade;
	}

	public String toString() {
		return String.format("%-30s%-30s%-30s%-30s", getId(), getNome(), getGenero(), this.idade);
	}
	
	
	
	
}
