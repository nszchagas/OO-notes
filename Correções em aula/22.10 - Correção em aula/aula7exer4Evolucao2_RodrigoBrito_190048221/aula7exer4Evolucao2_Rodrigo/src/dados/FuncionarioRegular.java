package dados;

public class FuncionarioRegular extends Pessoa {

	public FuncionarioRegular(String nome, String cpf, String dataDeNascimento) {
		super(nome, cpf, dataDeNascimento);
	}

	public float calculaSalario() { // PISO SALARIAL ACRESCIDO DE 10%
		return (this.getPISO() + (this.getPISO() / 10));
	}

	public String toString() {
		String formato = "%-20s %-20s %-20s %-20s %-20s\n";
		return String.format(formato, this.getNome(), this.getDataDeNascimento(), this.getCpf(), "---", "---");
	}
}
