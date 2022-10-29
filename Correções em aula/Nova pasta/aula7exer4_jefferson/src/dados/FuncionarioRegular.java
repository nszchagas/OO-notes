package dados;

import java.text.DecimalFormat;

public class FuncionarioRegular extends Funcionario {

	public FuncionarioRegular(Funcionario funcionario) {
		super(funcionario);
		this.setSalario(this.calculaSalario());
	}

	public float calculaSalario() {
		final float FATOR = 1.1f;
		return super.calculaSalario() * FATOR;
	}

	public String toString() {
		return String.format("| %-24s ", "Funcionario regular") + super.toString()
				+ String.format("| %-17s | %-18s | %-11s", "-----", "-----",
						new DecimalFormat("0.00").format(this.getSalario()));
	}

}
