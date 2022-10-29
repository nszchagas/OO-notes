package dados;

import java.text.DecimalFormat;

public class Funcionario extends Pessoa{

	public Funcionario(String nome, String dataNascimento, String cpf) {
		super(nome, dataNascimento, cpf);
	}

	public float calculaSalario() {
		return PISO * 1.1F;
	}
	
	public String toString() {
		DecimalFormat formato = new DecimalFormat("0.00");
		return String.format("%-15s%-15s%-15s%s", this.getNome(), this.getDataNascimento(), this.getCpf(), 
													formato.format(this.calculaSalario()));		
	}

}
