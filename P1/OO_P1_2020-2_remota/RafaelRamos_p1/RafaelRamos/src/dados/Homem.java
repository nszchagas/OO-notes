package dados;

public class Homem extends Pessoa {
	private Integer idade;

	public Homem(String nome, Integer numCadastro, Character saude, Integer idade) {
		super(nome, numCadastro, saude);
		this.idade = idade;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String toString() {
		return String.format("%-15s%-35s%-30s%-20s%-20s%-2s", this.getNumCadastro(), "| " + this.getNomeCompleto(),
				"| " + (this.getSaude() == 'T' ? "Contaminado em tratamento"
						: (this.getSaude() == 'F' ? "Contaminado falecido"
								: (this.getSaude() == 'C' ? "Contaminado curado" : "Sem contaminacao"))),
				"| " + this.getIdade() + " anos", "| -", "|");
	}

}
