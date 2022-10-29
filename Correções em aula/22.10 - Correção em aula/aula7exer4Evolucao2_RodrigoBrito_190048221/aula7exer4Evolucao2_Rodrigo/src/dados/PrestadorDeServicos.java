package dados;

public class PrestadorDeServicos extends Pessoa {
	private Integer horasTrabalhadas;

	public PrestadorDeServicos(String nome, String cpf, String dataDeNascimento, int horasTrabalhadas) {
		super(nome, cpf, dataDeNascimento);
		setHorasTrabalhadas(horasTrabalhadas);
	}

	public Integer getHorasTrabalhadas() {
		return horasTrabalhadas;
	}

	public void setHorasTrabalhadas(Integer horasTrabalhadas) {
		this.horasTrabalhadas = horasTrabalhadas;
	}

	public float calculaSalario() { // QTD HORAS TRABALHADAS VEZES 2 E ACRESCIDO DO PROPRIO PISO SALARIAL.
		return ((this.getHorasTrabalhadas() * 2) + this.getPISO());
	}

	public String toString() {
		String formato = "%-20s %-20s %-20s %-20s %-20s\n";

		return String.format(formato, this.getNome(), this.getDataDeNascimento(), this.getCpf(),
				this.getHorasTrabalhadas(), "---");
	}

}
