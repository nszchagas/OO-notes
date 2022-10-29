package dados;

import java.text.DecimalFormat;

public class Gerente extends Funcionario {
	private Integer quantidadeDeProjetos;

	public Gerente(Funcionario funcionario, int quantidadeDeProjetos) {
		super(funcionario);
		setQuantidadeDeProjetos(quantidadeDeProjetos);
		this.setSalario(this.calculaSalario());
	}

	public Integer getQuantidadeDeProjetos() {
		return quantidadeDeProjetos;
	}

	public void setQuantidadeDeProjetos(Integer quantidadeDeProjetos) {
		this.quantidadeDeProjetos = quantidadeDeProjetos;
	}

	public float calculaSalario() {
		final float PERCENTUAL_POR_PROJETO = 0.5f;
		return super.calculaSalario() * (1 + PERCENTUAL_POR_PROJETO * this.getQuantidadeDeProjetos());
	}

	public String toString() {
		return String.format("| %-24s ", "Gerente") + super.toString() + String.format("| %-17s | %-18s | %-11s",
				"-----", this.getQuantidadeDeProjetos(), new DecimalFormat("0.00").format(this.getSalario()));
	}

}
