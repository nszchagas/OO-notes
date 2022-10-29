package principal;

public class PessoaNaoInfectada extends Pessoa{
	private Integer idade;
	
	public PessoaNaoInfectada(String nome, Character genero, Integer identificador, Integer idade) {
		super(nome, genero, identificador);
		setIdade(idade);
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	
	public Integer getIdade() {
		return idade;
	}
	
	public String toString() {
		String formato = "%-3s%-15s%-20s%-13s\n";
		return String.format(formato, "", this.getNome(), this.getGenero(),
				this.getIdentificador(), this.getIdade());
	}
}
