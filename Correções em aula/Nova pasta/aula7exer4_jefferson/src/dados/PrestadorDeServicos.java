package dados;

import java.text.DecimalFormat;

public class PrestadorDeServicos extends Funcionario {
	private Integer horasTrabalhadas;

	public PrestadorDeServicos(Funcionario funcionario, int horasTrabalhadas) {
		super(funcionario);
		setHorasTrabalhadas(horasTrabalhadas);
		this.setSalario(this.calculaSalario());
	}

	public Integer getHorasTrabalhadas() {
		return horasTrabalhadas;
	}

	public void setHorasTrabalhadas(Integer horasTrabalhadas) {
		this.horasTrabalhadas = horasTrabalhadas;
	}

	public float calculaSalario() {
		final float VALOR_DA_HORA = 2f;
		return (VALOR_DA_HORA * this.getHorasTrabalhadas() + super.calculaSalario());
	}

	public String toString() {
		return String.format("| %-24s ", "Prestador de servicos") + super.toString()
				+ String.format("| %-17s | %-18s | %-11s", this.getHorasTrabalhadas(), "-----",
						new DecimalFormat("0.00").format(this.getSalario()));
	}

}
