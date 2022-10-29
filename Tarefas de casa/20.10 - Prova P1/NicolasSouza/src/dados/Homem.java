package dados;

public class Homem extends Pessoa {
	private Integer idade;

	public Homem(Pessoa pessoa, Integer idade) {
		super(pessoa);
		this.setIdade(idade);
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String toString() {
		String formato = "%-5s | %-15s |";
		return (super.toString() + String.format(formato, this.getIdade(), "---"));
	}

}
