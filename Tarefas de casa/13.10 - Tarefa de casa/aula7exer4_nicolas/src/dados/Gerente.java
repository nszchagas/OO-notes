package dados;

public class Gerente extends Pessoa {

	protected Integer quantidadeProjetos;

	public Gerente(Pessoa pessoa, Integer quantidadeProjetos) {
		super(pessoa);
		this.setQuantidadeProjetos(quantidadeProjetos);
		this.setSalario(calculaSalario());
	}

	public Integer getQuantidadeProjetos() {
		return quantidadeProjetos;
	}

	public void setQuantidadeProjetos(Integer quantidadeProjetos) {
		this.quantidadeProjetos = quantidadeProjetos;
	}

	public Float calculaSalario() {
		final float PERCENTAGEM_PROJETO = 0.5F;
		return super.calculaSalario() * (1 + PERCENTAGEM_PROJETO * this.getQuantidadeProjetos());
	}
	
	public String toString() {

		String formato = "%-22s|";
		return super.toString().concat(String.format(formato, "Gerente"));
	}

}
