package dados;

public class Homem extends Pessoa {
	private Integer idade;

	public Homem(StringBuilder nome, String situacaoSaude, Integer codigo, Integer idade) {
		super(nome, situacaoSaude, codigo);
		this.setIdade(idade);
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String toString() {
		String formato = "%-20s%-20s%-20s%-20s%-30s%-30s\n";
		return String.format(formato, this.getCodigo(), this.getNome(), "MASCULINO", this.getSituacaoSaude(),
				this.getIdade(), "---");
	}
}
