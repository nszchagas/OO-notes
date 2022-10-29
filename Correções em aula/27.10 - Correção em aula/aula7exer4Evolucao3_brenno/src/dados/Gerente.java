package dados;

import java.text.DecimalFormat;

public class Gerente extends Funcionario {
	private Integer quantidadeProjetos;

	public Gerente(String nome, String dataNascimento, String cpf, Integer quantidadeProjetos) {
		super(nome, dataNascimento, cpf);
		setQuantidadeProjetos(quantidadeProjetos);
	}

	@Override
	public float calculaSalario() {
		return PISO * (1 + 0.5F * quantidadeProjetos);
	}

	public Integer getQuantidadeProjetos() {
		return quantidadeProjetos;
	}

	public void setQuantidadeProjetos(Integer quantidadeProjetos) {
		this.quantidadeProjetos = quantidadeProjetos;
	}
	
	public String toString() {
		DecimalFormat formato = new DecimalFormat("0.00");
		return String.format("%-15s%-15s%-15s%-15s%-22s%s", this.getNome(), this.getDataNascimento(), this.getCpf(), 
				formato.format(this.calculaSalario()), " ", this.getQuantidadeProjetos());		
	}
}
