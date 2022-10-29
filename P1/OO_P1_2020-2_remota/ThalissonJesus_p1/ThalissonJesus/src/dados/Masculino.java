package dados;

public class Masculino extends Pessoa {
	private Integer idade;
	
	public Masculino(int id, StringBuilder nome, char situacaoSaude, int idade) {
		super(id, nome, situacaoSaude);
		this.idade = idade;
	}
	
	public String toString() {
		return String.format("%s %-10.10s", super.toString(), idade);
	}
}
