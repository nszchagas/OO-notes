package dados;

public class PrestadorServicos extends Funcionario {
	public Float horasTrabalhadas;

	public PrestadorServicos(String nome, String dataNascimento, String cpf, Float horasTrabalhadas) {
		super(nome, dataNascimento, cpf);
		setHorasTrabalhadas(horasTrabalhadas);
	}

	@Override
	public float calculaSalario() {
		return 2 * horasTrabalhadas + super.getPiso();
	}

	public void setHorasTrabalhadas(Float horasTrabalhadas) {
		this.horasTrabalhadas = horasTrabalhadas;
	}

	public Float getHorasTrabalhadas() {
		return horasTrabalhadas;
	}

	@Override
	public float[] calculaSalarioCategorias(float[] salariosRegularPrestadorGerente) {
		return new float[] { salariosRegularPrestadorGerente[0],
				salariosRegularPrestadorGerente[1] + this.calculaSalario(), salariosRegularPrestadorGerente[2] };
	}

	@Override
	public int[] contaFuncionariosCategorias(int[] qtdRegularPrestadorGerente) {
		return new int[] { qtdRegularPrestadorGerente[0], qtdRegularPrestadorGerente[1] + 1,
				qtdRegularPrestadorGerente[2] };
	}
}
