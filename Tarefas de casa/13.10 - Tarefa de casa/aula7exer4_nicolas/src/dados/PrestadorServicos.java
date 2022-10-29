package dados;

public class PrestadorServicos extends Pessoa {

	protected Integer horasTrabalhadas;

	public PrestadorServicos(Pessoa pessoa, Integer horasTrabalhadas) {
		super(pessoa);
		this.setHorasTrabalhadas(horasTrabalhadas);
		this.setSalario(calculaSalario());
	}

	public Integer getHorasTrabalhadas() {
		return this.horasTrabalhadas;
	}

	public void setHorasTrabalhadas(int horasTrabalhadas) {
		this.horasTrabalhadas = horasTrabalhadas;
	}

	public Float calculaSalario() {
		final float VALOR_HORA = 2F;
		return (super.calculaSalario() + this.getHorasTrabalhadas() * VALOR_HORA);

	}
	
	public String toString() {

		String formato = "%-22s|";
		return super.toString().concat(String.format(formato, "Prestador de servicos "));
	}

}
