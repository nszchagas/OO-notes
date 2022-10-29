package dados;

import java.text.DecimalFormat;

public class PrestadorServicos extends Funcionario {
	public Float horasTrabalhadas;

	public PrestadorServicos(String nome, String dataNascimento, String cpf, Float horasTrabalhadas) {
		super(nome, dataNascimento, cpf);
		setHorasTrabalhadas(horasTrabalhadas);
	}

	@Override
	public float calculaSalario() {
		return 2 * horasTrabalhadas + PISO;
	}

	public void setHorasTrabalhadas(Float horasTrabalhadas) {
		this.horasTrabalhadas = horasTrabalhadas;
	}

	public Float getHorasTrabalhadas() {
		return horasTrabalhadas;
	}
	
	public String toString() {
		DecimalFormat formato = new DecimalFormat("0.00");
		return String.format("%-15s%-15s%-15s%-15s%s", this.getNome(), this.getDataNascimento(), this.getCpf(), 
														formato.format(this.calculaSalario()), formato.format(this.getHorasTrabalhadas()));		
	}
}
