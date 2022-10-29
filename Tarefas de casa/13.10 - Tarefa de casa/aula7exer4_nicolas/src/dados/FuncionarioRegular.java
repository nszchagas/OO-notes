package dados;

public class FuncionarioRegular extends Pessoa {

	public FuncionarioRegular(Pessoa pessoa) {
		super(pessoa);
		this.setSalario(calculaSalario());
	}

	public Float calculaSalario() {
		final float FATOR = 1.1F; // AUMENTAR 10%
		return super.calculaSalario() * FATOR;
	}
	
	public String toString() {

		String formato = "%-22s|";
		return super.toString().concat(String.format(formato, "Funcionario regular "));
	}
}
