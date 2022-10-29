package dados;

public class NaoContaminada extends Pessoa {
	private Integer idade;
	
	
	// Metodo construtor
	public NaoContaminada(StringBuilder nome, char genero, int identiticacao, int idade) {
		super(nome, genero, identiticacao);
		this.setIdade(idade);
	}
	
	
	// Metodos assessores
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public Integer getIdade() {
		return this.idade;
	}
	
	
	public String toString() {
		String formato = "%-15s%-25s%-18s%-10s%-15s\n";
		return String.format(formato, this.getIdentificacao(), this.getNome(), generoPorExtenso(this.getGenero()),
				this.getIdade(), "---");
	}
	
	

}
