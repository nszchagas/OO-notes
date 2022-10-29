package dados;

public class GerenteDeEquipe extends Pessoa {
	private Integer quantidadeDeProjetos;

	public GerenteDeEquipe(String nome, String cpf, String dataDeNascimento, int quantidadeDeProjetos) {
		super(nome, cpf, dataDeNascimento);
		setQuantidadeDeProjetos(quantidadeDeProjetos);
	}

	public Integer getQuantidadeDeProjetos() {
		return quantidadeDeProjetos;
	}

	public void setQuantidadeDeProjetos(Integer quantidadeDeProjetos) {
		this.quantidadeDeProjetos = quantidadeDeProjetos;
	}

	public float calculaSalario() { // QTD DE PROJETOS VEZES 50% DO PISO SALARIAL ACRESCIDO DO PROPRIO PISO
		return (this.getQuantidadeDeProjetos() * (this.getPISO() / 2));
	}

	public String toString() {
		String formato = "%-20s %-20s %-20s %-20s %-20s\n";
		return String.format(formato, this.getNome(), this.getDataDeNascimento(), this.getCpf(), "---",
				this.getQuantidadeDeProjetos());
	}

}
