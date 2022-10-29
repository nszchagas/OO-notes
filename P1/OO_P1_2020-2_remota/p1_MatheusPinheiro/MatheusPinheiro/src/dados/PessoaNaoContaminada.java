package dados;

public class PessoaNaoContaminada extends Pessoa {
	private Integer idade;
	public PessoaNaoContaminada(String nome, String genero, Integer identificador, Integer idade) {
		super(nome, genero, identificador);
		setIdade(idade);
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public String toString() {
		String formato = "%-20s%-20s%-20s%-20s%-20s\n";
		return String.format(formato, getIdentificador(), getNome(), getGenero(), getIdade(), "-----");
	}
}
